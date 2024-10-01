package _i5i.AISecurity.web.service;

import _i5i.AISecurity.apiPayload.code.status.ErrorStatus;
import _i5i.AISecurity.web.domain.member.entity.Member;
import _i5i.AISecurity.web.domain.member.repository.MemberRepository;
import _i5i.AISecurity.web.domain.personal_information.converter.PersonalInfConverter;
import _i5i.AISecurity.web.domain.personal_information.dto.PersonalInfRequestDTO;
import _i5i.AISecurity.web.domain.personal_information.entity.PersonalInformation;
import _i5i.AISecurity.web.domain.personal_information.repository.PersonalInformationRepository;
import _i5i.AISecurity.web.handler.MemberHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalInfService {

    private final MemberRepository memberRepository;
    private final PersonalInformationRepository informationRepository;

    public PersonalInformation createPersonalInf(PersonalInfRequestDTO.PersonalInfDTO dto,Long memberId){
        Member member=memberRepository.findById(memberId)
                .orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        PersonalInformation personalInformation=PersonalInfConverter.toEntity(dto,member);
        return informationRepository.save(personalInformation);
    }
}


