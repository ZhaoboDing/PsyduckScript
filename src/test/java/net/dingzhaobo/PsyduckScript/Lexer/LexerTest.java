package net.dingzhaobo.PsyduckScript.Lexer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class LexerTest {

    private Lexer lexer;

    @Test
    public void testSyntaxCorrectInput() throws Exception {
        String scriptPath = "src/test/resources/LexerTest.pds";
        InputStream inputStream = new FileInputStream(scriptPath);
        lexer = new Lexer(inputStream);

        LexerResult lexerResult = lexer.analyze();
        while (lexerResult.getToken() != Token.EOF) {
            // System.out.println("<" + lexerResult.getToken().toString() + "," + lexerResult.getLexeme() + ">");
            lexerResult = lexer.analyze();
        }
    }
}