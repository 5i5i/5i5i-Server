package _i5i.AISecurity.web.domain.personal_information.converter;

import _i5i.AISecurity.web.domain.member.entity.Member;
import _i5i.AISecurity.web.domain.personal_information.dto.PersonalInfRequestDTO;
import _i5i.AISecurity.web.domain.personal_information.dto.PersonalInfResponseDTO;
import _i5i.AISecurity.web.domain.personal_information.entity.PersonalInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PersonalInfConverter {

    public static PersonalInfResponseDTO.resultDTO toResultDTO(PersonalInformation personalInformation){
        return PersonalInfResponseDTO.resultDTO.builder()
                .personalInformationId(personalInformation.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static PersonalInformation toEntity(PersonalInfRequestDTO.PersonalInfDTO dto, Member member){
        return PersonalInformation.builder()
                .name(dto.getName())
                .phoneNum(dto.getPhoneNum())
                .address(dto.getAddress())
                .birth(dto.getBirth())
                .gender(dto.getGender())
                .member(member)
                .build();
    }
}
