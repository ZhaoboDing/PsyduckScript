package net.dingzhaobo.PsyduckScript.AST.Expressions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;
import net.dingzhaobo.PsyduckScript.AST.Operator;

@Builder
@AllArgsConstructor
public class BinaryExpr extends Expression {
    @NonNull
    private Expression lhs, rhs;

    @NonNull
    private Operator opt;

    @Override
    public String toString() {
        return "BinaryExpr(" + lhs.toString() + opt.toString() + rhs.toString() + ")";
    }
}
