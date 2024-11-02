package _i5i.AISecurity.web.flask;


import _i5i.AISecurity.apiPayload.code.status.ErrorStatus;
import _i5i.AISecurity.web.domain.member.entity.Member;
import _i5i.AISecurity.web.domain.member.repository.MemberRepository;
import _i5i.AISecurity.web.domain.personal_information.dto.PersonalInfRequestDTO;
import _i5i.AISecurity.web.domain.personal_information.entity.PersonalInformation;
import _i5i.AISecurity.web.domain.personal_information.repository.PersonalInformationRepository;
import _i5i.AISecurity.web.domain.posting.converter.PostingConverter;
import _i5i.AISecurity.web.domain.posting.dto.PostingRequestDTO;
import _i5i.AISecurity.web.domain.posting.dto.PostingResponseDTO;
import _i5i.AISecurity.web.domain.posting.entity.Posting;
import _i5i.AISecurity.web.domain.posting.repository.PostingRepository;
import _i5i.AISecurity.web.handler.MemberHandler;
import _i5i.AISecurity.web.handler.PersonalInformationHandler;
import _i5i.AISecurity.web.handler.PostingHandler;
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
import java.util.Map;


@Service
@RequiredArgsConstructor
public class FlaskService {
    //데이터를 JSON 객체로 변환하기 위해서 사용
    private final ObjectMapper objectMapper;
    private final PersonalInformationRepository personalInfRepository;
    private final MemberRepository memberRepository;
    private final PostingRepository postingRepository;

    @Transactional
    public PostingResponseDTO.resultDTO sendToFlask(Long memberId, Long postingId) throws JsonProcessingException {

        Member member=memberRepository.findById(memberId)
                .orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Posting posting = postingRepository.findById(postingId)
                .orElseThrow(()->new PostingHandler(ErrorStatus.POSTING_NOT_FOUND));

        PersonalInformation personalInf=personalInfRepository.findByMember(member)
                .orElseThrow(()->new PersonalInformationHandler(ErrorStatus.PERSONALINFORMATION_NOT_FOUND));

        PersonalInfRequestDTO.PersonalInfDTO personalInfDTO=PersonalInfRequestDTO.PersonalInfDTO.builder()
                                                                .name(personalInf.getName())
                                                                .phoneNum(personalInf.getPhoneNum())
                                                                .address(personalInf.getAddress())
                                                                .gender(personalInf.getGender())
                                                                .birth(personalInf.getBirth())
                                                                .univ(personalInf.getUniv())
                                                                .major(personalInf.getMajor())
                                                                .club(personalInf.getClub())
                                                                .company(personalInf.getCompany())
                                                                .department(personalInf.getDepartment())
                                                                .rating(personalInf.getRating())
                                                                .build();

        RestTemplate restTemplate = new RestTemplate();

        //헤더를 JSON으로 설정함
        HttpHeaders headers = new HttpHeaders();

        //파라미터로 들어온 dto를 JSON 객체로 변환
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestData = new HashMap<>();
        requestData.put("content", posting.getContent());
        requestData.put("personalInf", personalInfDTO);

        String param = objectMapper.writeValueAsString(requestData);

        HttpEntity<String> entity = new HttpEntity<String>(param , headers);

        //실제 Flask 서버랑 연결하기 위한 URL
        String url = "http://127.0.0.1:8082/receive_string";

        //Flask 서버로 데이터를 전송하고 받은 응답 값을 return
        restTemplate.postForObject(url, entity, String.class);

        return PostingConverter.toPostingResultDTO(posting);
    }
}
