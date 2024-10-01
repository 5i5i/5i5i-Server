package _i5i.AISecurity.web.domain.personal_information.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class PersonalInfResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class resultDTO{
        Long personalInformationId;
        LocalDateTime createdAt;
    }
}
