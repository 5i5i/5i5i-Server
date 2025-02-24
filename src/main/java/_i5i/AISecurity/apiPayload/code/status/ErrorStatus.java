package _i5i.AISecurity.apiPayload.code.status;

import _i5i.AISecurity.apiPayload.code.BaseErrorCode;
import _i5i.AISecurity.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    //Exception 핸들링 테스트
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "에러 핸들링 테스트"),

    //MEMBER
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND,"MEMBER001","Member not found"),

    //POSTING
    POSTING_NOT_FOUND(HttpStatus.NOT_FOUND,"POSTING001","Posting not found"),

    //PersonalInformation
    PERSONALINFORMATION_NOT_FOUND(HttpStatus.NOT_FOUND,"PERSONALINFORMATION001","PersonalInf not found"),

    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }

}
