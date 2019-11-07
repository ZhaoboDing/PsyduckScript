package net.dingzhaobo.PsyduckScript.Lexer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.dingzhaobo.PsyduckScript.Utils.PsyduckSyntexError;

import java.io.*;

@RequiredArgsConstructor
public class Lexer {
    @NonNull
    private InputStream input;

    @NonNull
    private int row, col;

    private ReservedWords reservedWords = new ReservedWords();

    char getNext() throws EOFException {
        int c = 0;

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

    char peekNext() throws EOFException {
        int c = 0;

        try {
            input.mark(1);
            c = input.read();
            input.reset();
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


    public LexerResult analyze() throws PsyduckSyntexError {
        try {
            char next = getNext();

            if (meaningless(next)) {
                while (meaningless(next)) {
                    if (next == '\'') {
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

            if (Character.isDigit(next)) {
                int r = row, c = col;
                boolean isInt = true;
                char p = peekNext();
                StringBuffer stringBuffer = new StringBuffer(next);

                while (Character.isDigit(p) || p == '.') {
                    if (p == '.') {
                        if (isInt) {
                            isInt = false;
                        }
                        else {
                            throw new PsyduckSyntexError("Cannot recognize number", r, c);
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
                }

                if (isInt) {
                    return new LexerResult(Token.INT, stringBuffer.toString());
                }
                else {
                    return new LexerResult(Token.DOUBLE, stringBuffer.toString());
                }
            }

            if (Character.isLetter(next) || next == '_') {
                char p = peekNext();
                StringBuffer stringBuffer = new StringBuffer(next);

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
                    throw new PsyduckSyntexError("InComplete string", r, c);
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

            throw new PsyduckSyntexError("Unrecognized token", row, col);

        }
        catch (EOFException e) {
            return new LexerResult(Token.EOF, "");
        }
    }

    private boolean meaningless(char c) {
        return c == ' ' || c == '\t' || c == '\r' || c == '\n';
    }

    private String errorLocation() {
        return "Line " + String.valueOf(row) + ", Row " + String.valueOf(col);
    }
}
