package com.database.artvenue.api.exception.handler;

import com.database.artvenue.api.code.BaseErrorCode;
import com.database.artvenue.api.exception.GeneralException;

public class UserHandler extends GeneralException {
    public UserHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
