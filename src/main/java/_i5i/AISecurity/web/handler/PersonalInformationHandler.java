package _i5i.AISecurity.web.handler;

import _i5i.AISecurity.apiPayload.code.BaseErrorCode;
import _i5i.AISecurity.apiPayload.exception.GeneralException;

public class PersonalInformationHandler extends GeneralException {
    public PersonalInformationHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
