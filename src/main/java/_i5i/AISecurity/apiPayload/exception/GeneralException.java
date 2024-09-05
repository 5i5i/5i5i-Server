package _i5i.AISecurity.apiPayload.exception;

import _i5i.AISecurity.apiPayload.code.BaseErrorCode;
import _i5i.AISecurity.apiPayload.code.ErrorReasonDTO;
import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException {

  private BaseErrorCode code;

  public GeneralException(String message) {
    super(message);
    this.code = null;
  }

  public GeneralException(BaseErrorCode code) {
    super(code.getReason().getMessage());
    this.code = code;
  }

  public ErrorReasonDTO getErrorReason(){
    return this.code.getReason();
  }

  public ErrorReasonDTO getErrorReasonHttpStatus(){
    return this.code.getReasonHttpStatus();
  }
}

