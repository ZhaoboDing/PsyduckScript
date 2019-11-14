package net.dingzhaobo.PsyduckScript.Runtime.Values;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.dingzhaobo.PsyduckScript.Runtime.Value;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class ArrayValue extends Value {
    @NonNull
    private List<Value> values;
}
