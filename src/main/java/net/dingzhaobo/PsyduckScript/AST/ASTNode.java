package net.dingzhaobo.PsyduckScript.AST;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.NonFinal;

@Getter
@NonFinal
public class ASTNode {
    public ASTNode(int r, int c) {
        row = r;
        col = c;
    }

    @NonNull
    protected int row, col;
    // Store the location for each node in AST

    public String toString() {
        return "ASTNode()";
    }
}
