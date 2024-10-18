package _i5i.AISecurity.web.flask;


import _i5i.AISecurity.apiPayload.code.status.ErrorStatus;
import _i5i.AISecurity.web.domain.member.entity.Member;
import _i5i.AISecurity.web.domain.member.repository.MemberRepository;
import _i5i.AISecurity.web.domain.personal_information.entity.PersonalInformation;
import _i5i.AISecurity.web.domain.personal_information.repository.PersonalInformationRepository;
import _i5i.AISecurity.web.domain.posting.dto.PostingRequestDTO;
import _i5i.AISecurity.web.handler.MemberHandler;
import _i5i.AISecurity.web.handler.PersonalInformationHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class FlaskService {
    //데이터를 JSON 객체로 변환하기 위해서 사용
    private final ObjectMapper objectMapper;
    private final PersonalInformationRepository personalInfRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public String sendToFlask(Long memberId, PostingRequestDTO.PostingUploadRequestDTO dto) throws JsonProcessingException {

        Member member=memberRepository.findById(memberId)
                .orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        PersonalInformation personalInf=personalInfRepository.findByMember(member)
                .orElseThrow(()->new PersonalInformationHandler(ErrorStatus.PERSONALINFORMATION_NOT_FOUND));

        RestTemplate restTemplate = new RestTemplate();

        //헤더를 JSON으로 설정함
        HttpHeaders headers = new HttpHeaders();

        //파라미터로 들어온 dto를 JSON 객체로 변환
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestData = new HashMap<>();
        requestData.put("content", dto.getContent());
        requestData.put("personalInf-address", personalInf.getAddress());
        requestData.put("personalInf-birth",personalInf.getBirth());
        requestData.put("personalInf-gender",personalInf.getGender());
        requestData.put("personalInf-name",personalInf.getName());
        requestData.put("personalInf-phonenum",personalInf.getPhoneNum());

        String param = objectMapper.writeValueAsString(requestData);

        HttpEntity<String> entity = new HttpEntity<String>(param , headers);

        //실제 Flask 서버랑 연결하기 위한 URL
        String url = "http://127.0.0.1:8082/receive_string";

        //Flask 서버로 데이터를 전송하고 받은 응답 값을 return
        return restTemplate.postForObject(url, entity, String.class);
    }
}
