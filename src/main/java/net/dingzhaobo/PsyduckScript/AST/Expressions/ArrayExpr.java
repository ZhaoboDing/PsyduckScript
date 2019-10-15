package net.dingzhaobo.PsyduckScript.AST.Expressions;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.dingzhaobo.PsyduckScript.AST.Expression;

@Builder
@RequiredArgsConstructor
public class ArrayExpr extends Expression {
    @NonNull
    private String id;

    private List<Expression> arr = new ArrayList<Expression>();

    @Override
    public String toString() {
        return "ArrayExpr(" + id + ")";
    }
}
