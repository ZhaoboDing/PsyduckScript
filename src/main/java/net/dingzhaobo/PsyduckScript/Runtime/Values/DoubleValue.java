package net.dingzhaobo.PsyduckScript.Runtime.Values;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.dingzhaobo.PsyduckScript.Runtime.Value;

@RequiredArgsConstructor
@Getter
public class DoubleValue extends Value {
    @NonNull
    private double value;
}
