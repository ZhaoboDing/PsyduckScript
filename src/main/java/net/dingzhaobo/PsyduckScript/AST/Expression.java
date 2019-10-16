package net.dingzhaobo.PsyduckScript.AST;

import lombok.experimental.NonFinal;

@NonFinal
public class Expression extends ASTNode {
    public Expression(int r, int c) {
        super(r, c);
    }

    @Override
    public String toString() {
        return "Expression()";
    }
}
