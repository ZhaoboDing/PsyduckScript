package net.dingzhaobo.PsyduckScript.Utils;

import lombok.Getter;

@Getter
public class PsyduckSyntexError extends PsyduckException {
    protected int row, col;
    public PsyduckSyntexError(String errorMessage, int r, int c) {
        super(errorMessage);
        row = r;
        col = c;
    }

    @Override
    public String errorMessage() {
        return "Error: " + message +
                " at Line " + Integer.toString(row) + ", Column " + Integer.toString(col) + ".";
    }
}
