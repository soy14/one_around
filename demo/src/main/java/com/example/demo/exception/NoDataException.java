package com.example.demo.exception;

import java.text.MessageFormat;

public class NoDataException extends RuntimeException {
    public NoDataException(String msg) {
        super(MessageFormat.format("Exception : {0}", msg));
    }
}
