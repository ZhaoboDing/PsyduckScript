package net.dingzhaobo.PsyduckScript.AST.Statements;

import lombok.Getter;
import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;
import net.dingzhaobo.PsyduckScript.AST.Statement;

import java.util.List;

@Getter
public class IfStmt extends Statement {
    public IfStmt(int r, int c, Expression cond, List<Statement> i) {
        super(r, c);
        condition = cond;
        ifBlock = i;
    }

    @NonNull
    private Expression condition;

    @NonNull
    private List<Statement> ifBlock;
}
