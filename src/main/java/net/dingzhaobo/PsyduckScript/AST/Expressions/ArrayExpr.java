package net.dingzhaobo.PsyduckScript.AST.Expressions;

import java.util.ArrayList;
import java.util.List;
import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;

public class ArrayExpr extends Expression {
    public ArrayExpr(int r, int c) {
        super(r, c);
        arr = new ArrayList<Expression>();
    }

    public ArrayExpr(int r, int c, String id, List<Expression> a) {
        super(r, c);
        arr = a;
    }

    @NonNull
    private String id;

    @NonNull
    private List<Expression> arr;

    @Override
    public String toString() {
        return "ArrayExpr(" + id + ")";
    }
}
