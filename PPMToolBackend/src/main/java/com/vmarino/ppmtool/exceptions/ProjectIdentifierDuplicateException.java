package com.vmarino.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdentifierDuplicateException extends RuntimeException {

    public ProjectIdentifierDuplicateException(String message) {
        super(message);
    }
}
