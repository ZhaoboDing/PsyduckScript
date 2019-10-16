package net.dingzhaobo.PsyduckScript.AST;

import lombok.experimental.NonFinal;

@NonFinal
public class Statement extends ASTNode {
    public Statement(int r, int c) {
        super(r, c);
    }
    @Override
    public String toString() {
        return "Statement()";
    }
}
