package net.dingzhaobo.PsyduckScript.AST.Statements;

import lombok.Getter;
import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;
import net.dingzhaobo.PsyduckScript.AST.Statement;

import java.util.List;

@Getter
public class WhileStmt extends Statement {
    public WhileStmt(int r, int c, Expression cond, List<Statement> w) {
        super(r, c);
        condition = cond;
        whileBlock = w;
    }

    @NonNull
    private Expression condition;

    @NonNull
    private List<Statement> whileBlock;
}
