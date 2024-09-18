package _i5i.AISecurity.web.domain.posting.converter;

import _i5i.AISecurity.web.domain.posting.dto.PostingResponseDTO;
import _i5i.AISecurity.web.domain.posting.entity.Posting;

import java.util.List;

public class PostingConverter {

    public static PostingResponseDTO.postingListDTO toPostingListDTO(List<Posting> postingList){
        List<PostingResponseDTO.postingSummaryDTO> postingSummaryDTOS=postingList.stream()
                .map(PostingConverter::toPostingSummaryDTO).toList();

        return new PostingResponseDTO.postingListDTO(postingSummaryDTOS);
    }

    public static PostingResponseDTO.postingSummaryDTO toPostingSummaryDTO(Posting posting){
        return PostingResponseDTO.postingSummaryDTO.builder()
                .postingId(posting.getId())
                .title(posting.getTitle())
                .createdAt(posting.getCreatedAt())
                .build();
    }
}
