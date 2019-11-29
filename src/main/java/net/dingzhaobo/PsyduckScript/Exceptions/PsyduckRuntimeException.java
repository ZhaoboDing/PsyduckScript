package net.dingzhaobo.PsyduckScript.Exceptions;

public class PsyduckRuntimeException extends PsyduckException {
    private int row, col;

    public PsyduckRuntimeException(String errorMessage, int r, int c) {
        super(errorMessage);
        row = r;
        col = c;
    }

    @Override
    public String errorMessage() {
        return "Runtime Error: " + message +
                " at Line " + Integer.toString(row) +
                ", Column " + Integer.toString(col) + ".";
    }
}
