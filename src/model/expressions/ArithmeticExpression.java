package model.expressions;

import exceptions.MyException;
import model.types.IntType;
import model.values.IntValue;
import model.states.SymbolTableInterface;
import model.values.Value;

/**
 * @param op 1-plus, 2-minus, 3-star, 4-divide
 */

public record ArithmeticExpression(Expression e1, Expression e2, int op) implements Expression {

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

        if (n2 == 0 && op == 4) throw new MyException("division by zero");

        return switch (op) {
            case 1 -> new IntValue(n1 + n2);
            case 2 -> new IntValue(n1 - n2);
            case 3 -> new IntValue(n1 * n2);
            case 4 -> new IntValue(n1 / n2);
            default -> throw new MyException("ArithExp: invalid operation");
        };
    }
}
