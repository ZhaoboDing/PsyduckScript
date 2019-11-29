package net.dingzhaobo.PsyduckScript.Lexer;

public enum Token {
    INVALID,   // invalid

    ID,        // identifier
    EOF,       // end of file

    INT,       // integer
    DOUBLE,    // double
    STRING,    // string

    PLUS,      // +
    MINUS,     // -
    MULT,      // *
    DIV,       // /
    MOD,       // %

    AND,       // &&
    OR,        // ||
    NOT,       // !
    BITXOR,    // ^
    BITAND,    // &
    BITOR,     // |
    BITNOT,    // !

    EQ,        // ==
    NE,        // !=
    GT,        // >
    LT,        // <
    GE,        // >=
    LE,        // <=

    AGN,       // =
    PLUSAGN,   // +=
    MINUSAGN,  // -=
    MULTAGN,   // *=
    DIVAGN,    // /=
    MODAGN,    // %=

    COMMA,     // ,
    LPAREN,    // (
    RPAREN,    // )
    LBRACE,    // {
    RBRACE,    // }
    LBRACKET,  // [
    RBRACKET,  // ]

    IF,        // if
    ELSE,      // else
    WHILE,     // while
    FUNC,      // function
    RETURN,    // return
    TRUE,      // True
    FALSE,     // False
    NONE       // NoneVal
}
