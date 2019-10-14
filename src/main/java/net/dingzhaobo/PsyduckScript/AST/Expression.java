package net.dingzhaobo.PsyduckScript.AST;

import lombok.Builder;

@Builder
public class Expression extends ASTNode {
    @Override
    public String toString() {
        return "Expression()";
    }
}
