package net.dingzhaobo.PsyduckScript.AST.Expressions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;

@Builder
@AllArgsConstructor
public class IndexExpr extends Expression {
    @NonNull
    private String id;

    @NonNull
    private Expression index;

    @Override
    public String toString() {
        return "IndexExpr(" + id + "[" + index.toString() + "])";
    }
}
