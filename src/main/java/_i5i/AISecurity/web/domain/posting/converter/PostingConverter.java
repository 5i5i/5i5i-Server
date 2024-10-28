package _i5i.AISecurity.web.domain.posting.converter;

import _i5i.AISecurity.web.domain.member.entity.Member;
import _i5i.AISecurity.web.domain.posting.dto.PostingRequestDTO;
import _i5i.AISecurity.web.domain.posting.dto.PostingResponseDTO;
import _i5i.AISecurity.web.domain.posting.entity.Posting;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PostingConverter {

    public static PostingResponseDTO.resultDTO toResultDTO(Posting posting){
        return PostingResponseDTO.resultDTO.builder()
                .postingId(posting.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static PostingResponseDTO.postingListDTO toPostingListDTO(Page<Posting> postingList){
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

    public static Posting toEntity(Member member){
        return Posting.builder()
                .member(member)
                .build();
    }

    public static PostingResponseDTO.postingcontentDTO toPostingcontentDTO(Posting posting,String memberName){
        return PostingResponseDTO.postingcontentDTO.builder()
                .postingId(posting.getId())
                .title(posting.getTitle())
                .content(posting.getContent())
                .name(memberName)
                .build();
    }
}
