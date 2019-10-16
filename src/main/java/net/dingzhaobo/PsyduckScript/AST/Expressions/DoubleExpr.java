package net.dingzhaobo.PsyduckScript.AST.Expressions;

import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;

public class DoubleExpr extends Expression {
    public DoubleExpr(int r, int c) {
        super(r, c);
        value = 0;
    }

    public DoubleExpr(int r, int c, double v) {
        super(r, c);
        value = v;
    }

    @NonNull
    private double value;

    @Override
    public String toString() {
        return "DoubleExpr(" + String.valueOf(value) + ")";
    }
}
