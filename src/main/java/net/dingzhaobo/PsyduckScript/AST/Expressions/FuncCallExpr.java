package net.dingzhaobo.PsyduckScript.AST.Expressions;

import java.util.ArrayList;
import java.util.List;
import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;

public class FuncCallExpr extends Expression {
    public FuncCallExpr(int r, int c, String name) {
        super(r, c);
        id = name;
        params = new ArrayList<Expression>();
    }

    public FuncCallExpr(int r, int c, String name, List<Expression> p) {
        super(r, c);
        id = name;
        params = p;
    }

    @NonNull
    private String id;

    @NonNull
    private List<Expression> params;

    @Override
    public String toString() {
        return "FuncCallExpr(" + id + ")";
    }
}
