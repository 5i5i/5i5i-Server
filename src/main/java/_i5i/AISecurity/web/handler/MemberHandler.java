package _i5i.AISecurity.web.handler;

import _i5i.AISecurity.apiPayload.code.BaseErrorCode;
import _i5i.AISecurity.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
