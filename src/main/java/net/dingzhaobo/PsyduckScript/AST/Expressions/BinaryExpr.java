package net.dingzhaobo.PsyduckScript.AST.Expressions;

import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;
import net.dingzhaobo.PsyduckScript.AST.Operator;

public class BinaryExpr extends Expression {
    public BinaryExpr(int r, int c, Expression lh, Operator o, Expression rh) {
        super(r, c);
        lhs = lh;
        rhs = rh;
        opt = o;
    }

    @NonNull
    private Expression lhs, rhs;

    @NonNull
    private Operator opt;

    @Override
    public String toString() {
        return "BinaryExpr(" + lhs.toString() + opt.toString() + rhs.toString() + ")";
    }
}
