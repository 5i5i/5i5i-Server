package _i5i.AISecurity.web.domain.location.entity;

import _i5i.AISecurity.web.domain.posting.entity.Posting;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Location {
    private Long id;

    private String content;

    @ManyToOne @JoinColumn(name = "posting_id")
    private Posting posting;
}
