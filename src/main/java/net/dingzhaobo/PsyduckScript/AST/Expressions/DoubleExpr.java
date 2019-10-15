package net.dingzhaobo.PsyduckScript.AST.Expressions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;

@Builder
@AllArgsConstructor
public class DoubleExpr extends Expression {
    @NonNull
    private double value;

    @Override
    public String toString() {
        return "DoubleExpr(" + String.valueOf(value) + ")";
    }
}
