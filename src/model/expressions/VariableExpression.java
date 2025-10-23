package model.expressions;

import exceptions.MyException;
import model.states.SymbolTableInterface;
import model.values.Value;

public record VariableExpression(String id) implements Expression {

    public Value evaluate(SymbolTableInterface symTable) throws MyException {
        return symTable.lookup(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
