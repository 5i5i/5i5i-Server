package _i5i.AISecurity.web.domain.location.entity;

import _i5i.AISecurity.web.domain.posting.entity.Posting;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Location {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @OneToOne @JoinColumn(name = "posting_id")
    private Posting posting;
}
