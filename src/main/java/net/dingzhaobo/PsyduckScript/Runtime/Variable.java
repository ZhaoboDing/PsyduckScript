package net.dingzhaobo.PsyduckScript.Runtime;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Variable {
    private Value value;

    @NonNull
    private String varName;
}
