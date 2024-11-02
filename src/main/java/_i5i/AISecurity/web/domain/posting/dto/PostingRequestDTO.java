package _i5i.AISecurity.web.domain.posting.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Getter;

public class PostingRequestDTO {

    @Getter
    public static class PostingUploadRequestDTO{
        private String title;
        @JsonRawValue
        private String content;
    }
}
