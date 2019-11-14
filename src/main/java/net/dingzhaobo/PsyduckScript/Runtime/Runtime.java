package net.dingzhaobo.PsyduckScript.Runtime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import net.dingzhaobo.PsyduckScript.AST.Statement;

import java.util.List;

@NoArgsConstructor
@Getter
public class Runtime extends Context {
    private List<Statement> statements;

    public void addStatement(Statement statement) {
        // To be implemented
    }
}
