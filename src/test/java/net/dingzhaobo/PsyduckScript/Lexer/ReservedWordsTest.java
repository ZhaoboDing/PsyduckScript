package net.dingzhaobo.PsyduckScript.Lexer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReservedWordsTest {
    private ReservedWords reservedWords;

    @Before
    public void setUp() throws Exception {
        reservedWords = new ReservedWords();
    }

    @Test
    public void testIfProvidedWordsExist() {
        assertEquals(reservedWords.getToken("and"), Token.AND);
        assertEquals(reservedWords.getToken("if"), Token.IF);
        assertEquals(reservedWords.getToken("or"), Token.OR);
        assertEquals(reservedWords.getToken("true"), Token.TRUE);
    }

    @Test
    public void testIfUnprovidedWordsNotExist() {
        assertEquals(reservedWords.getToken("dne"), Token.ID);
        assertEquals(reservedWords.getToken("NOT"), Token.ID);
        assertEquals(reservedWords.getToken("nONE"), Token.ID);
        assertEquals(reservedWords.getToken("False"), Token.ID);
    }
}