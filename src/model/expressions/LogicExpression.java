package model.expressions;

import exceptions.MyException;
import model.adts.SymbolTableInterface;
import model.types.BoolType;
import model.values.BoolValue;
import model.values.Value;

/**
 * @param op 1-and, 2-or (possibly more in the future)
 */

public record LogicExpression(Expression e1, Expression e2, int op) implements Expression {

    public Value evaluate(SymbolTableInterface symTable) throws MyException {
        Value v1, v2;
        v1 = e1.evaluate(symTable);
        v2 = e2.evaluate(symTable);

        if (!v1.getType().equals(BoolType.INSTANCE) || !v2.getType().equals(BoolType.INSTANCE)) {
            throw new MyException("LogicExp: invalid operation");
        }

        BoolValue b1 = (BoolValue) v1;
        BoolValue b2 = (BoolValue) v2;
        boolean n1, n2;
        n1 = b1.val();
        n2 = b2.val();

        return switch (op) {
            case 1 -> new BoolValue(n1 && n2);
            case 2 -> new BoolValue(n1 || n2);
            default -> throw new MyException("LogicExp: invalid operation");
        };
    }
}

