package net.dingzhaobo.PsyduckScript.Lexer;

import net.dingzhaobo.PsyduckScript.Utils.PsyduckSyntexError;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

import static org.junit.Assert.*;

public class LexerTest {
    @Test
    public void testSyntaxCorrectInput() throws Exception {
        String scriptPath = "src/test/resources/syntaxCorrect.pds";
        InputStream inputStream = new FileInputStream(scriptPath);
        Lexer lexer = new Lexer(inputStream);

        LexerResult lexerResult = lexer.analyze();
        while (lexerResult.getToken() != Token.EOF) {
            // System.out.println("<" + lexerResult.getToken().toString() + ", " + lexerResult.getLexeme() + ">");
            lexerResult = lexer.analyze();
        }
    }

    @Test
    public void testComments() throws Exception {
        String scriptPath = "src/test/resources/comments.pds";
        InputStream inputStream = new FileInputStream(scriptPath);
        Lexer lexer = new Lexer(inputStream);

        LexerResult lexerResult = lexer.analyze();
        while (lexerResult.getToken() != Token.EOF) {
            lexerResult = lexer.analyze();
        }
    }

    @Test(expected = PsyduckSyntexError.class)
    public void testNumbers() throws Exception {
        String scriptPath = "src/test/resources/numbers.pds";
        InputStream inputStream = new FileInputStream(scriptPath);
        Lexer lexer = new Lexer(inputStream);

        LexerResult lexerResult = lexer.analyze();
        while (lexerResult.getToken() != Token.EOF) {
            lexerResult = lexer.analyze();
        }
    }

    @Test
    public void testIds() throws Exception {
        String scriptPath = "src/test/resources/validId.pds";
        InputStream inputStream = new FileInputStream(scriptPath);
        Lexer lexer = new Lexer(inputStream);

        LexerResult lexerResult = lexer.analyze();
        while (lexerResult.getToken() != Token.EOF) {
            assertEquals(lexerResult.getToken(), Token.ID);
            lexerResult = lexer.analyze();
        }
    }

    @Test
    public void testReservedWords() throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        List<Token> tokens = new ArrayList<Token>();

        Map<String, Token> reservedMap = getReservedMap();

        Iterator iterator = reservedMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            stringBuffer.append(pair.getKey() + " ");
            tokens.add((Token) pair.getValue());
        }

        Lexer lexer = new Lexer(new ByteArrayInputStream(stringBuffer.toString().getBytes()));
        LexerResult lexerResult = lexer.analyze();
        int index = 0;
        while (lexerResult.getToken() != Token.EOF) {
            assertEquals(lexerResult.getToken(), tokens.get(index++));
            lexerResult = lexer.analyze();
        }
    }

    @Test(expected = PsyduckSyntexError.class)
    public void testStrings() throws Exception {
        String scriptPath = "src/test/resources/strings.pds";
        InputStream inputStream = new FileInputStream(scriptPath);
        Lexer lexer = new Lexer(inputStream);

        LexerResult lexerResult = lexer.analyze();
        while (lexerResult.getToken() != Token.EOF) {
            lexerResult = lexer.analyze();
        }
    }

    private Map<String ,Token> getReservedMap() throws Exception {
        ReservedWords reservedWords = new ReservedWords();
        Field field = ReservedWords.class.getDeclaredField("map");
        field.setAccessible(true);
        return (HashMap) field.get(reservedWords);
    }
}