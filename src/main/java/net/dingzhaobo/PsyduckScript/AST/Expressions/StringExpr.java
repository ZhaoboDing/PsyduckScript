package net.dingzhaobo.PsyduckScript.AST.Expressions;

import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;

public class StringExpr extends Expression {
    public StringExpr(int r, int c) {
        super(r, c);
        value = "";
    }

    public StringExpr(int r, int c, String v) {
        super(r, c);
        value = v;
    }

    @NonNull
    private String value;

    @Override
    public String toString() {
        return "StringExpr(\"" + value + "\")";
    }
}
