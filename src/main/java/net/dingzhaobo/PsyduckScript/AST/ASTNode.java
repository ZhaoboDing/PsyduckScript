package net.dingzhaobo.PsyduckScript.AST;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class ASTNode {
    @NonNull
    protected int row, col;
    // Store the location for each node in AST

    public String toString() {
        return "ASTNode()";
    }
}
