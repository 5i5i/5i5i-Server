package _i5i.AISecurity.web.flask;

import _i5i.AISecurity.web.domain.posting.dto.PostingRequestDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FlaskController {

    private final FlaskService flaskService;

    @PostMapping("/flask/{memberId}")
    public String sendToFlask(@PathVariable Long memberId, @RequestBody PostingRequestDTO.PostingUploadRequestDTO dto) throws JsonProcessingException {
        return flaskService.sendToFlask(memberId,dto);
    }
}
