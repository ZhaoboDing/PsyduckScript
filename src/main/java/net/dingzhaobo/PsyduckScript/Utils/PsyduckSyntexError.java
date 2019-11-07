package net.dingzhaobo.PsyduckScript.Utils;

public class PsyduckSyntexError extends PsyduckException {
    protected int row, col;
    public PsyduckSyntexError(String errorMessage, int r, int c) {
        super(errorMessage);
        row = r;
        col = c;
    }

    public String errorMessage() {
        return "Error: " + message +
                " at Line " + Integer.toString(row) + ", Row " + Integer.toString(col) + ".";
    }
}
