package net.dingzhaobo.PsyduckScript.AST;

public enum OperatorsEnum {
    INVALID,   // invalid
    PLUS,      // +
    MINUS,     // -
    MULTI,  // *
    DIV,    // /
    MOD,       // %

    AND,       // &&
    OR,        // ||
    NOT,       // !
    XOR,       // ^
    BITAND,    // &
    BITOR,     // |
    BITNOT,    // !

    EQ,        // ==
    NE,        // !=
    GT,        // >
    LT,        // <
    GE,        // >=
    LE,        // <=

    AGN,         // =
    PLUSAGN,     // +=
    MINUSAGN,    // -=
    MULTIPLYAGN, // *=
    DIVIDEAGN,   // /=
    MODAGN,      // %=
}
