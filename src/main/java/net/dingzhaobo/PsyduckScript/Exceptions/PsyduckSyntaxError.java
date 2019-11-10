package net.dingzhaobo.PsyduckScript.Exceptions;

import lombok.Getter;

@Getter
public class PsyduckSyntaxError extends PsyduckException {
    private int row, col;

    public PsyduckSyntaxError(String errorMessage, int r, int c) {
        super(errorMessage);
        row = r;
        col = c;
    }

    @Override
    public String errorMessage() {
        return "Syntax Error: " + message +
                " at Line " + Integer.toString(row) + ", Column " + Integer.toString(col) + ".";
    }
}
