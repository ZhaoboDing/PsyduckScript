package net.dingzhaobo.PsyduckScript.AST.Expressions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;

@Builder
@AllArgsConstructor
public class IntegerExpr extends Expression {
    @NonNull
    private int value;

    @Override
    public String toString() {
        return "IntegerExpr(" + String.valueOf(value) + ")";
    }
}
