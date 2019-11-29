package net.dingzhaobo.PsyduckScript.Lexer;

import net.dingzhaobo.PsyduckScript.Exceptions.PsyduckSyntaxError;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class PsyduckLexerTest {
    @Test
    public void testSyntaxCorrectInput() throws Exception {
        String scriptPath = "src/test/resources/syntaxCorrect.pds";
        InputStream inputStream = new FileInputStream(scriptPath);
        Lexer psyduckLexer = new PsyduckLexer(inputStream);

        psyduckLexer.tokenization();
    }

    @Test
    public void testComments() throws Exception {
        String scriptPath = "src/test/resources/comments.pds";
        InputStream inputStream = new FileInputStream(scriptPath);
        Lexer psyduckLexer = new PsyduckLexer(inputStream);

        psyduckLexer.tokenization();
    }

    @Test(expected = PsyduckSyntaxError.class)
    public void testNumbers() throws Exception {
        String scriptPath = "src/test/resources/numbers.pds";
        InputStream inputStream = new FileInputStream(scriptPath);
        Lexer psyduckLexer = new PsyduckLexer(inputStream);

        psyduckLexer.tokenization();
    }

    @Test
    public void testIds() throws Exception {
        String scriptPath = "src/test/resources/validId.pds";
        InputStream inputStream = new FileInputStream(scriptPath);
        Lexer psyduckLexer = new PsyduckLexer(inputStream);

        psyduckLexer.tokenization();
    }

    @Test
    public void testReservedWords() throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        List<Token> expectedTokens = new ArrayList<Token>();

        Map<String, Token> reservedMap = getReservedMap();

        Iterator iterator = reservedMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            stringBuffer.append(pair.getKey() + " ");
            expectedTokens.add((Token) pair.getValue());
        }

        Lexer psyduckLexer = new PsyduckLexer(new ByteArrayInputStream(stringBuffer.toString().getBytes()));
        List<LexerResult> results = psyduckLexer.tokenization();
        List<Token> actualTokens = results.stream().map(LexerResult::getToken).collect(Collectors.toList());
        assertEquals(expectedTokens, actualTokens);
    }

    @Test(expected = PsyduckSyntaxError.class)
    public void testStrings() throws Exception {
        String scriptPath = "src/test/resources/strings.pds";
        InputStream inputStream = new FileInputStream(scriptPath);
        Lexer psyduckLexer = new PsyduckLexer(inputStream);

        psyduckLexer.tokenization();
    }

    private Map<String ,Token> getReservedMap() throws Exception {
        ReservedWords reservedWords = new ReservedWords();
        Field field = ReservedWords.class.getDeclaredField("map");
        field.setAccessible(true);
        return (HashMap) field.get(reservedWords);
    }
}