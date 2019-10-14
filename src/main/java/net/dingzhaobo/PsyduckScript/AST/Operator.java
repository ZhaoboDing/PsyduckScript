package net.dingzhaobo.PsyduckScript.AST;

public class Operator {
    public enum Optr {
        Invalid,   // invalid
        Plus,      // +
        Minus,     // -
        Multiply,  // *
        Divide,    // /
        Mod,       // %

        And,       // &&
        Or,        // ||
        Not,       // !
        Xor,       // ^
        BitAnd,    // &
        BitOr,     // |
        BitNot,    // !

        EQ,        // ==
        NE,        // !=
        GT,        // >
        LT,        // <
        GE,        // >=
        LE,        // <=

        AGN,         // =
        PlusAGN,     // +=
        MinusAGN,    // -=
        MultiplyAGN, // *=
        DivideAGN,   // /=
        ModAGN,      // %=
    }

    public Optr optr;

    public String toString() {
        switch (optr) {
            case Plus:
                return "+";
            case Minus:
                return "-";
            case Multiply:
                return "*";
            case Divide:
                return "/";
            case Mod:
                return "%";
            case And:
                return "and";
            case Or:
                return "or";
            case Not:
                return "not";
            case Xor:
                return "^";
            case BitAnd:
                return "&";
            case BitOr:
                return "|";
            case BitNot:
                return "~";
            case EQ:
                return "==";
            case NE:
                return "!=";
            case GT:
                return ">";
            case LT:
                return "<";
            case GE:
                return ">=";
            case LE:
                return "<=";
            case AGN:
                return "=";
            case PlusAGN:
                return "+=";
            case MinusAGN:
                return "-=";
            case MultiplyAGN:
                return "*=";
            case DivideAGN:
                return "/=";
            case ModAGN:
                return "%=";
            default:
                return "<INVALID>";
        }
    }
}
