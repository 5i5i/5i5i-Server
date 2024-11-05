package _i5i.AISecurity.web.domain.posting.dto;

import _i5i.AISecurity.web.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class PostingResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class resultDTO{
        Long postingId;
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class postingListDTO{
        List<postingSummaryDTO> postingList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class postingSummaryDTO{
        Long postingId;
        String title;
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class postingcontentDTO{
        Long postingId;
        String title;
        String content;
        String name;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class infResultDTO{
        String leakedInfContent;
        String locationContent;
    }

}
