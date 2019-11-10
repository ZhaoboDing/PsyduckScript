package net.dingzhaobo.PsyduckScript.Exceptions;

import lombok.NonNull;

public class PsyduckException extends Exception {
    @NonNull
    protected String message;

    public PsyduckException(String errorMessage) {
        super();
        message = errorMessage;
    }

    public String errorMessage() {
        return "Error: " + message + ".";
    }
}
