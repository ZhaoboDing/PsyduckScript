package net.dingzhaobo.PsyduckScript.Exceptions;

public class PsyduckCompileException extends PsyduckException {
    private int row, col;

    public PsyduckCompileException(String errorMessage, int r, int c) {
        super(errorMessage);
        row = r;
        col = c;
    }

    @Override
    public String errorMessage() {
        return "Compile Error: " + message +
                " at Line " + Integer.toString(row) + ", Column " + Integer.toString(col) + ".";
    }
}
