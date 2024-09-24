package _i5i.AISecurity.web.controller;

import _i5i.AISecurity.apiPayload.ApiResponse;
import _i5i.AISecurity.web.domain.posting.converter.PostingConverter;
import _i5i.AISecurity.web.domain.posting.dto.PostingRequestDTO;
import _i5i.AISecurity.web.domain.posting.dto.PostingResponseDTO;
import _i5i.AISecurity.web.domain.posting.entity.Posting;
import _i5i.AISecurity.web.service.PostingUploadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostingUploadController {
    private final PostingUploadService postingUploadService;

    @PostMapping(value = "/posting/upload/{memberId}")
    @Operation(summary = "블로그 글 등록 API",description = "블로그 글을 등록하는 API입니다. 글 내용은 html형식의 string으로 보내주시면 됩니다")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK, 성공"),
    })
    public ApiResponse<PostingResponseDTO.resultDTO> createPosting(@PathVariable Long memberId, @RequestPart PostingRequestDTO.PostingUploadRequestDTO dto){
        Posting posting=postingUploadService.createPosting(dto, memberId);
        return ApiResponse.onSuccess(PostingConverter.toResultDTO(posting));
    }
}
