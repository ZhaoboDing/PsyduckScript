package net.dingzhaobo.PsyduckScript.Lexer;

import net.dingzhaobo.PsyduckScript.Exceptions.PsyduckException;

import java.util.List;

public interface Lexer {
    List<LexerResult> tokenization() throws PsyduckException;
}
