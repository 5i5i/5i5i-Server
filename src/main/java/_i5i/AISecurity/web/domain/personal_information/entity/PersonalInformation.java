package _i5i.AISecurity.web.domain.personal_information.entity;

import _i5i.AISecurity.web.domain.member.entity.Member;
import jakarta.persistence.*;
import jdk.jfr.Description;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PersonalInformation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phoneNum;

    private String address;

    @Description("남자는0, 여자는1")
    private Boolean gender;

    private String birth;

    @ManyToOne @JoinColumn(name = "member_id")
    private Member member;
}
