package net.dingzhaobo.PsyduckScript.Utils;

import lombok.NonNull;

public class PsyduckException extends Exception {
    @NonNull
    private String message;

    private int row, col;

    public PsyduckException(String errorMessage) {
        super();
        message = errorMessage;
        row = col = -1;
    }

    public PsyduckException(String errorMessage, int r, int c) {
        super();
        message = errorMessage;
        row = r;
        col = c;
    }

    public String errorMessage() {
        if (row == -1 || col == -1) {
            return "Error: " + message + ".";
        }
        else {
            return "Error: " + message +
                    " at Line " + Integer.toString(row) + ", Row " + Integer.toString(col) + ".";
        }
    }
}
