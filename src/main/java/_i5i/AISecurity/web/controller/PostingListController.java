package _i5i.AISecurity.web.controller;

import _i5i.AISecurity.apiPayload.ApiResponse;
import _i5i.AISecurity.web.domain.posting.converter.PostingConverter;
import _i5i.AISecurity.web.domain.posting.dto.PostingResponseDTO;
import _i5i.AISecurity.web.domain.posting.entity.Posting;
import _i5i.AISecurity.web.service.PostingListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostingListController {
    private final PostingListService postingListService;

    @GetMapping("/{memberId}/postingList")
    @Operation(summary = "게시글 전체 조회 API",description = "특정 블로거의 게시글 리스트를 조회하는 API")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "Ok, 성공")
    }) @Parameters({
            @Parameter(name="page",description = "페이지 번호")
    }) public ApiResponse<PostingResponseDTO.postingListDTO> getPostingList(@PathVariable(name="memberId") Long memberId,@RequestParam(name="page") Integer page){
        Page<Posting> postingList=postingListService.getPostingList(memberId, page);
        return ApiResponse.onSuccess(PostingConverter.toPostingListDTO(postingList));
    }
}
