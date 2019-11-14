package net.dingzhaobo.PsyduckScript.Runtime;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.dingzhaobo.PsyduckScript.AST.Expression;
import net.dingzhaobo.PsyduckScript.AST.Statement;

import java.util.List;

@RequiredArgsConstructor
public class Function {
    @NonNull
    private String funcName;

    private List<String> params;
    private List<Statement> instr;
    private Expression ret;
}
