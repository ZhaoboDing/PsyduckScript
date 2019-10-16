package net.dingzhaobo.PsyduckScript.AST.Expressions;

import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;

public class IndexExpr extends Expression {
    public IndexExpr(int r, int c, String name, Expression idx) {
        super(r, c);
        id = name;
        index = idx;
    }

    @NonNull
    private String id;

    @NonNull
    private Expression index;

    @Override
    public String toString() {
        return "IndexExpr(" + id + "[" + index.toString() + "])";
    }
}
