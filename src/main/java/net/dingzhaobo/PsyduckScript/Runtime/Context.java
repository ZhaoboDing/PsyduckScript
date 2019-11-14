package net.dingzhaobo.PsyduckScript.Runtime;

import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class Context {
    // TODO: we must add some exceptions for this class, say when adding duplicated variables
    protected Map<String, Variable> vars;
    protected Map<String, Function> funcs;

    public boolean hasVariable(String name) {
        return vars.containsKey(name);
    }

    public boolean hasFunction(String name) {
        return funcs.containsKey(name);
    }

    public Variable getVariable(String name) {
        return vars.get(name);
    }

    public void setValue(String name, Value value) {
        vars.get(name).setValue(value);
    }

    public void newVariable(String name, Variable variable) {
        vars.put(name, variable);
    }

    public void newFunction(String name, Function function) {
        funcs.put(name, function);
    }
}
