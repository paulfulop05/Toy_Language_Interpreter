package model.expressions;

import model.states.HeapInterface;
import model.values.Value;

public record ValueExpression(Value e) implements Expression {

    public Value evaluate(SymbolTableInterface symTable, HeapInterface heapTable) {
        return e;
    }

    @Override
    public String toString() {
        return e.toString();
    }
}
