package model.expressions;

import exceptions.TypecheckException;
import model.states.map.*;
import model.types.Type;
import model.values.Value;

public record ValueExpression(Value e) implements Expression {

    public Value evaluate(SymbolTable symTable, HeapTable heapTable) {
        return e;
    }

    @Override
    public Type typecheck(TypeTable typeTable) throws TypecheckException {
        return e.getType();
    }

    @Override
    public String toString() {
        return e.toString();
    }
}
