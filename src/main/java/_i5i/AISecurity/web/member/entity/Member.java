package _i5i.AISecurity.web.member.entity;

import _i5i.AISecurity.web.personal_information.entity.PersonalInformation;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<PersonalInformation> personalInformationList;
}
