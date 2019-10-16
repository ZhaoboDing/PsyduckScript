package net.dingzhaobo.PsyduckScript.AST.Expressions;

import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;

public class IntegerExpr extends Expression {
    public IntegerExpr(int r, int c) {
        super(r, c);
        value = 0;
    }

    public IntegerExpr(int r, int c, int v) {
        super(r, c);
        value = v;
    }

    @NonNull
    private int value;

    @Override
    public String toString() {
        return "IntegerExpr(" + String.valueOf(value) + ")";
    }
}
