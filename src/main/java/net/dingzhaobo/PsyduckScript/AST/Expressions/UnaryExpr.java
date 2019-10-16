package net.dingzhaobo.PsyduckScript.AST.Expressions;

import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;
import net.dingzhaobo.PsyduckScript.AST.Operator;

public class UnaryExpr extends Expression {
    public UnaryExpr(int r, int c, Operator o, Expression e) {
        super(r, c);
        opt = o;
        expr = e;
    }

    @NonNull
    private Expression expr;

    @NonNull
    private Operator opt;

    @Override
    public String toString() {
        return "UnaryExpr(" + opt.toString() + expr.toString() + ")";
    }
}
