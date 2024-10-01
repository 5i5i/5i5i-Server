package _i5i.AISecurity.web.domain.posting.dto;

import lombok.Getter;

public class PostingRequestDTO {

    @Getter
    public static class PostingUploadRequestDTO{
        private String title;
        private String content;
    }
}
