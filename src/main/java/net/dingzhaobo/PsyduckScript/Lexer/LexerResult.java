package net.dingzhaobo.PsyduckScript.Lexer;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LexerResult {
    @NonNull
    private Token token;

    @NonNull
    private String lexeme;
}
