package net.dingzhaobo.PsyduckScript.AST.Expressions;

import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;

public class IdentifierExpr extends Expression {
    public IdentifierExpr(int r, int c, String name) {
        super(r, c);
        id = name;
    }

    @NonNull
    private String id;

    @Override
    public String toString() {
        return "IdentifierExpr(" + id + ")";
    }
}
