package net.dingzhaobo.PsyduckScript.AST.Statements;

import lombok.Getter;
import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;
import net.dingzhaobo.PsyduckScript.AST.Statement;

@Getter
public class ReturnStmt extends Statement {
    public ReturnStmt(int r, int c, Expression e) {
        super(r, c);
        expr = e;
    }

    @NonNull
    private Expression expr;
}
