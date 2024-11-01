package _i5i.AISecurity.web.domain.posting.entity;

import _i5i.AISecurity.common.BaseEntity;
import _i5i.AISecurity.web.domain.leaked_information.entity.LeakedInformation;
import _i5i.AISecurity.web.domain.location.entity.Location;
import _i5i.AISecurity.web.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Posting extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String content;

    @ManyToOne @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "posting",cascade = CascadeType.ALL)
    private List<LeakedInformation> leakedInformationList;

    @OneToMany(mappedBy = "posting",cascade = CascadeType.ALL)
    private List<Location> locationList;

    public void updateContent(String content, String title) {
        this.content = content;
        this.title = title;
    }
}
