package net.dingzhaobo.PsyduckScript.AST.Expressions;

import net.dingzhaobo.PsyduckScript.AST.Expression;

public class NoneExpr extends Expression {
    public NoneExpr(int r, int c) {
        super(r, c);
    }

    @Override
    public String toString() {
        return "NoneExpr()";
    }
}
