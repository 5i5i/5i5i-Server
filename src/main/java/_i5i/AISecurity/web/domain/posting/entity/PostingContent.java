package _i5i.AISecurity.web.domain.posting.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostingContent {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String img;

    @ManyToOne@JoinColumn(name = "posting_id")
    private Posting posting;
}
