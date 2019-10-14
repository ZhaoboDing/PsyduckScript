package net.dingzhaobo.PsyduckScript.AST;

import lombok.Builder;

@Builder
public class Statement extends ASTNode {
    @Override
    public String toString() {
        return "Statement()";
    }
}
