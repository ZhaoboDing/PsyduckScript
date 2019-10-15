package net.dingzhaobo.PsyduckScript.AST.Expressions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;
import net.dingzhaobo.PsyduckScript.AST.Operator;

@Builder
@AllArgsConstructor
public class UnaryExpr extends Expression {
    @NonNull
    private Expression expr;

    @NonNull
    private Operator opt;

    @Override
    public String toString() {
        return "UnaryExpr(" + opt.toString() + expr.toString() + ")";
    }
}
