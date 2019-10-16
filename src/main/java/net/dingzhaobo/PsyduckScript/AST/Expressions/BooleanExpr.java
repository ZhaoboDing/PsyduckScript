package net.dingzhaobo.PsyduckScript.AST.Expressions;

import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;

public class BooleanExpr extends Expression {
    public BooleanExpr(int r, int c) {
        super(r, c);
        value = false;
    }

    public BooleanExpr(int r, int c, boolean v) {
        super(r, c);
        value = v;
    }

    @NonNull
    private boolean value;

    @Override
    public String toString() {
        return "Boolean(" + String.valueOf(value) + ")";
    }
}
