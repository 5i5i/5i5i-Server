package _i5i.AISecurity.web.leaked_information.entity;
import _i5i.AISecurity.web.posting.entity.Posting;
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

    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'NOMASKING'")
    private MaskingStatus maskingStatus=MaskingStatus.NOMASKING;

    private Long riskLevel;

    @ManyToOne @JoinColumn(name = "posting_id")
    private Posting posting;
}
