package _i5i.AISecurity.web.domain.member.entity;

import _i5i.AISecurity.web.domain.personal_information.entity.PersonalInformation;
import _i5i.AISecurity.web.domain.posting.entity.Posting;
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

    private String name;

    @OneToOne(mappedBy = "member",cascade = CascadeType.ALL)
    private PersonalInformation personalInformation;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Posting> postingList;
}
