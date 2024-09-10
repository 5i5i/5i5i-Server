package _i5i.AISecurity.web.posting.entity;

import jakarta.persistence.*;

public class PostingContent {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String img;

    @ManyToOne@JoinColumn(name = "posting_id")
    private Posting posting;
}
