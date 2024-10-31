package _i5i.AISecurity.web.domain.leaked_information.entity;
import _i5i.AISecurity.web.domain.posting.entity.Posting;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LeakedInformation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long riskLevel;

    private String content;

    @ManyToOne @JoinColumn(name = "posting_id")
    private Posting posting;
}
