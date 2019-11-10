package net.dingzhaobo.PsyduckScript.Lexer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.dingzhaobo.PsyduckScript.Exceptions.PsyduckSyntaxError;

import java.io.*;

@RequiredArgsConstructor
public class Lexer {
    @NonNull
    private InputStream input;

    private int row = 1, col = 0;
    private char nextBuffer = '\0';
    private ReservedWords reservedWords = new ReservedWords();

    private char getNext() throws EOFException {
        int c = 0;

        if (nextBuffer != '\0') {
            char res = nextBuffer;
            nextBuffer = '\0';
            return res;
        }

        try {
            c = input.read();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        col++;
        if (c != -1) {
            return (char) c;
        }
        else {
            throw new EOFException();
        }

    }

    private char peekNext() throws EOFException {
        int c = 0;

        if (nextBuffer != '\0') {
            return nextBuffer;
        }

        try {
            c = input.read();
            nextBuffer = (char) c;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        if (c != -1) {
            return (char) c;
        }
        else {
            throw new EOFException();
        }
    }


    public LexerResult analyze() throws PsyduckSyntaxError {
        try {
            char next = getNext();

            while (meaningless(next) || next == '#') {
                if (meaningless(next)) {
                    while (meaningless(next)) {
                        if (next == '\n') {
                            row++;
                            col = 0;
                        }
                        next = getNext();
                    }
                }

                if (next == '#') {
                    while (next == '#') {
                        while (next != '\n') {
                            next = getNext();
                        }

                        while (next == '\n') {
                            row++;
                            col = 0;
                            next = getNext();
                        }
                    }
                }
            }

            if (Character.isDigit(next)) {
                return readNumbers(next, true);
            }

            if (Character.isLetter(next) || next == '_') {
                char p = peekNext();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(next);

                while (Character.isLetter(p) || p =='_') {
                    next = getNext();
                    p = peekNext();
                    stringBuffer.append(next);
                }

                String lexeme = stringBuffer.toString();
                return new LexerResult(reservedWords.getToken(lexeme), lexeme);
            }

            if (next == '\"') {
                int r = row, c = col;
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    next = getNext();
                    while (next != '\"') {
                        stringBuffer.append(next);
                        next = getNext();
                    }
                }
                catch (EOFException e) {
                    throw new PsyduckSyntaxError("InComplete string", r, c);
                }

                return new LexerResult(Token.STRING, stringBuffer.toString());
            }

            if (next == '+') {
                if (peekNext() == '=') {
                    next = getNext();
                    return new LexerResult(Token.PLUSAGN, "+=");
                }
                else {
                    return new LexerResult(Token.PLUS, "+");
                }
            }
            else if (next == '-') {
                if (peekNext() == '=') {
                    next = getNext();
                    return new LexerResult(Token.MINUSAGN, "-=");
                }
                else if (Character.isDigit(peekNext())) {
                    return readNumbers(getNext(), false);
                }
                else {
                    return new LexerResult(Token.MINUS, "-");
                }
            }
            else if (next == '*') {
                if (peekNext() == '=') {
                    next = getNext();
                    return new LexerResult(Token.MULTAGN, "*=");
                }
                else {
                    return new LexerResult(Token.MULT, "*");
                }
            }
            else if (next == '/') {
                if (peekNext() == '=') {
                    next = getNext();
                    return new LexerResult(Token.DIVAGN, "/=");
                }
                else {
                    return new LexerResult(Token.DIV, "/");
                }
            }
            else if (next == '%') {
                if (peekNext() == '=') {
                    next = getNext();
                    return new LexerResult(Token.MODAGN, "%=");
                }
                else {
                    return new LexerResult(Token.MOD, "%");
                }
            }
            else if (next == '[') {
                return new LexerResult(Token.LBRACKET, "[");
            }
            else if (next == ']') {
                return new LexerResult(Token.RBRACKET, "]");
            }
            else if (next == '(') {
                return new LexerResult(Token.LPAREN, "(");
            }
            else if (next == ')') {
                return new LexerResult(Token.RPAREN, ")");
            }
            else if (next == '{') {
                return new LexerResult(Token.LBRACE, "{");
            }
            else if (next == '}') {
                return new LexerResult(Token.RBRACE, "}");
            }
            else if (next == ',') {
                return new LexerResult(Token.COMMA, ",");
            }
            else if (next == '&') {
                return new LexerResult(Token.BITAND, "&");
            }
            else if (next == '|') {
                return new LexerResult(Token.BITOR, "|");
            }
            else if (next == '^') {
                return new LexerResult(Token.BITNOT, "^");
            }
            else if (next == '=') {
                if (peekNext() == '=') {
                    next = getNext();
                    return new LexerResult(Token.EQ, "==");
                }
                else {
                    return new LexerResult(Token.AGN, "=");
                }
            }
            else if (next == '!') {
                if (peekNext() == '=') {
                    return new LexerResult(Token.NE, "!=");
                }
                else {
                    return new LexerResult(Token.NOT, "!");
                }
            }
            else if (next == '>') {
                if (peekNext() == '=') {
                    next = getNext();
                    return new LexerResult(Token.GE, ">=");
                }
                else {
                    return new LexerResult(Token.GT, ">");
                }
            }
            else if (next == '<') {
                if (peekNext() == '=') {
                    next = getNext();
                    return new LexerResult(Token.LE, "<=");
                }
                else {
                    return new LexerResult(Token.LT, "<");
                }
            }

            throw new PsyduckSyntaxError("Unrecognized token \"" + String.valueOf((int) next) + "\"", row, col);

        }
        catch (EOFException e) {
            return new LexerResult(Token.EOF, "");
        }
    }

    private LexerResult readNumbers(char next, boolean positive) throws PsyduckSyntaxError, EOFException {
        int r = row, c = col;
        boolean isInt = true;
        boolean leadingZero = true;
        char p = peekNext();
        StringBuffer stringBuffer = new StringBuffer();

        if (!positive) {
            stringBuffer.append('-');
        }
        stringBuffer.append(next);

        while (Character.isDigit(p) || p == '.') {
            if (p == '.') {
                if (isInt) {
                    isInt = false;
                }
                else {
                    throw new PsyduckSyntaxError("Cannot recognize number", r, c);
                }
            }
            else if (leadingZero && p == '0') {
                next = getNext();
                p = peekNext();
                continue;
            }
            else {
                leadingZero = false;
            }

            try {
                next = getNext();
                p = peekNext();
                stringBuffer.append(next);
            }
            catch (EOFException e) {
                break;
            }
        }

        if (isInt) {
            return new LexerResult(Token.INT, stringBuffer.toString());
        }
        else {
            return new LexerResult(Token.DOUBLE, stringBuffer.toString());
        }
    }

    private boolean meaningless(char c) {
        return c == ' ' || c == '\t' || c == '\r' || c == '\n';
    }

    private String errorLocation() {
        return "Line " + String.valueOf(row) + ", Row " + String.valueOf(col);
    }
}
