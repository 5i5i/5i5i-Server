package _i5i.AISecurity.web.controller;

import _i5i.AISecurity.apiPayload.ApiResponse;
import _i5i.AISecurity.web.domain.posting.converter.PostingConverter;
import _i5i.AISecurity.web.domain.posting.dto.PostingRequestDTO;
import _i5i.AISecurity.web.domain.posting.dto.PostingResponseDTO;
import _i5i.AISecurity.web.domain.posting.entity.Posting;
import _i5i.AISecurity.web.service.PostingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class PostingController {

    private final PostingService postingService;
    private final Logger logger= LoggerFactory.getLogger(PostingController.class);

    @GetMapping("/{memberId}/postingList")
    @Operation(summary = "게시글 전체 조회 API",description = "특정 블로거의 게시글 리스트를 조회하는 API")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "Ok, 성공")
    }) @Parameters({
            @Parameter(name="page",description = "페이지 번호")
    }) public ApiResponse<PostingResponseDTO.postingListDTO> getPostingList(@PathVariable(name="memberId") Long memberId, @RequestParam(name="page") Integer page){
        Page<Posting> postingList=postingService.getPostingList(memberId, page);
        return ApiResponse.onSuccess(PostingConverter.toPostingListDTO(postingList));
    }

    @PostMapping(value = "/posting/upload/{memberId}")
    @Operation(summary = "블로그 글 등록 API",description = "블로그 글을 등록하는 API입니다. 글 내용은 html형식의 string으로 보내주시면 됩니다")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK, 성공"),
    })
    public ApiResponse<PostingResponseDTO.resultDTO> createPosting(@PathVariable Long memberId, @RequestBody PostingRequestDTO.PostingUploadRequestDTO dto){
        if (dto.getContent() != null && dto.getContent().length() > 10000) {  // 예를 들어 50,000자로 제한
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Content length exceeds allowed limit.");
        }
        Posting posting=postingService.createPosting(dto, memberId);
        return ApiResponse.onSuccess(PostingConverter.toPostingResultDTO(posting));
    }

    @GetMapping("/{postingId}")
    @Operation(summary = "게시글 조회 API",description ="특정 블로거의 게시글을 조회하는 API")
    @ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "Ok, 성공")
    })public ApiResponse<PostingResponseDTO.postingcontentDTO> getPosting(@PathVariable(name = "postingId")Long postingId){
        PostingResponseDTO.postingcontentDTO postingDTO=postingService.getPosting(postingId);
        return ApiResponse.onSuccess(postingDTO);
    }

    @PatchMapping("/{postingId}/patch")
    @Operation(summary = "게시글 수정 api", description = "게시글을 수정하는 api")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "ok, 성공")
    })public ApiResponse<PostingResponseDTO.resultDTO> patchPosting(@PathVariable(name = "postingId")Long postingId, @RequestBody PostingRequestDTO.PostingUploadRequestDTO dto){
        PostingResponseDTO.resultDTO result = postingService.updatePosting(postingId, dto);
        return ApiResponse.onSuccess(result);
    }

    @GetMapping("/{postingId}/infResult")
    @Operation(summary = "게시글 위험도&노출된 위치 결과 반환 API")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "ok, 성공")
    })public ApiResponse<PostingResponseDTO.infResultDTO> getInfResult(@PathVariable(name = "postingId")Long postingId){
        PostingResponseDTO.infResultDTO dto=postingService.getInfResult(postingId);
        return ApiResponse.onSuccess(dto);
    }

}


