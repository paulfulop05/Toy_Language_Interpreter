package model.expressions;

import exceptions.MyException;
import model.types.IntType;
import model.values.IntValue;
import model.states.SymbolTableInterface;
import model.values.Value;

import java.util.Objects;

public record ArithmeticExpression(String op, Expression e1, Expression e2) implements Expression {

    public Value evaluate(SymbolTableInterface symTable) throws MyException {
        Value v1, v2;
        v1 = e1.evaluate(symTable);
        v2 = e2.evaluate(symTable);

        if (!v1.getType().equals(IntType.INSTANCE) || !v2.getType().equals(IntType.INSTANCE)) {
            throw new MyException("ArithExp: invalid operation");
        }

        IntValue i1 = (IntValue) v1;
        IntValue i2 = (IntValue) v2;
        int n1, n2;
        n1 = i1.val();
        n2 = i2.val();

        if (n2 == 0 && op.equals("/")) throw new MyException("division by zero");

        return switch (op) {
            case "+" -> new IntValue(n1 + n2);
            case "-" -> new IntValue(n1 - n2);
            case "*" -> new IntValue(n1 * n2);
            case "/" -> new IntValue(n1 / n2);
            default -> throw new MyException("ArithExp: invalid operation");
        };
    }

    @Override
    public String toString() {
        return "( " + e1.toString() + ' ' + op + ' ' + e2.toString() + " )";
    }
}
