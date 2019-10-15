package net.dingzhaobo.PsyduckScript.AST.Expressions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;

@Builder
@AllArgsConstructor
public class BooleanExpr extends Expression {
    @NonNull
    private boolean value;

    @Override
    public String toString() {
        return "Boolean(" + String.valueOf(value) + ")";
    }
}
