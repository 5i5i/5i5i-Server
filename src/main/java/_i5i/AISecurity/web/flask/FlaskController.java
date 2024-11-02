package _i5i.AISecurity.web.flask;

import _i5i.AISecurity.apiPayload.ApiResponse;
import _i5i.AISecurity.web.domain.posting.dto.PostingRequestDTO;
import _i5i.AISecurity.web.domain.posting.dto.PostingResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FlaskController {

    private final FlaskService flaskService;

    @PostMapping("/flask/{memberId}/{postingId}")
    @Operation(summary = "플라스크로 게시글, 개인정보 넘기기")
    public ApiResponse<PostingResponseDTO.resultDTO> sendToFlask(@PathVariable Long memberId,@PathVariable Long postingId) throws JsonProcessingException {
        PostingResponseDTO.resultDTO result=flaskService.sendToFlask(memberId,postingId);
        return ApiResponse.onSuccess(result);
    }
}
