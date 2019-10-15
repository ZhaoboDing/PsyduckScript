package net.dingzhaobo.PsyduckScript.AST.Expressions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;

@Builder
@AllArgsConstructor
public class IdentifierExpr extends Expression {
    @NonNull
    private String id;

    @Override
    public String toString() {
        return "IdentifierExpr(" + id + ")";
    }
}
