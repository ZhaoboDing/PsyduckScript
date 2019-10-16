package net.dingzhaobo.PsyduckScript.AST;

public class Operator {
    public OperatorsEnum opt;

    public String toString() {
        switch (opt) {
            case PLUS:
                return "+";
            case MINUS:
                return "-";
            case MULTI:
                return "*";
            case DIV:
                return "/";
            case MOD:
                return "%";
            case AND:
                return "and";
            case OR:
                return "or";
            case NOT:
                return "not";
            case XOR:
                return "^";
            case BITAND:
                return "&";
            case BITOR:
                return "|";
            case BITNOT:
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
            case PLUSAGN:
                return "+=";
            case MINUSAGN:
                return "-=";
            case MULTIPLYAGN:
                return "*=";
            case DIVIDEAGN:
                return "/=";
            case MODAGN:
                return "%=";
            default:
                return "<INVALID>";
        }
    }
}
