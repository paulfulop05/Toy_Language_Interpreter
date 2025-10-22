package model.expressions;

import exceptions.MyException;
import model.adts.SymbolTableInterface;
import model.values.Value;

public record VariableExpression(String id) implements Expression {

    public Value evaluate(SymbolTableInterface symTable) throws MyException {
        return symTable.lookup(id);
    }
}
