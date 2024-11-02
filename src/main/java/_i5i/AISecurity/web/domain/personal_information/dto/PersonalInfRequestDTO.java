package _i5i.AISecurity.web.domain.personal_information.dto;

import lombok.Builder;
import lombok.Getter;

public class PersonalInfRequestDTO {

    @Getter
    @Builder
    public static class PersonalInfDTO{
        private String name;

        private String phoneNum;

        private String address;

        private Boolean gender;

        private String birth;

        private String univ;

        private String major;

        private String club;

        private String company;

        private String department;

        private String rating;

    }
}
