package net.dingzhaobo.PsyduckScript.AST.Expressions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import net.dingzhaobo.PsyduckScript.AST.Expression;

@Builder
@AllArgsConstructor
public class StringExpr extends Expression {
    @NonNull
    private String value;

    @Override
    public String toString() {
        return "StringExpr(\"" + value + "\")";
    }
}
