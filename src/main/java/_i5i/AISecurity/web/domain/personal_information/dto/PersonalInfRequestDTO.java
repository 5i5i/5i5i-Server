package _i5i.AISecurity.web.domain.personal_information.dto;

import lombok.Getter;

public class PersonalInfRequestDTO {

    @Getter
    public static class PersonalInfDTO{
        private String name;

        private String phoneNum;

        private String address;

        private Boolean gender;

        private String birth;
    }
}
