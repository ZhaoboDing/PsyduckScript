package net.dingzhaobo.PsyduckScript.AST.Expressions;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;

@Builder
@AllArgsConstructor
public class FuncCallExpr extends Expression {
    @NonNull
    private String id;

    @NonNull
    private List<Expression> params;

    @Override
    public String toString() {
        return "FuncCallExpr(" + id + ")";
    }
}
