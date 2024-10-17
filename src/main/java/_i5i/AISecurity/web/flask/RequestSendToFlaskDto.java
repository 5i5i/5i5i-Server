package _i5i.AISecurity.web.flask;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RequestSendToFlaskDto {
    private final String nickname;
    private final String fileId;
}
