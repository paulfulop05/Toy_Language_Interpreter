package model.expressions;

import exceptions.ExpressionEvalException;
import exceptions.TypecheckException;
import model.states.MyHeap;
import model.states.MyMap;
import model.types.Type;
import model.values.Value;

public record NotExpression(Expression expression) implements Expression {
    @Override
    public Value evaluate(MyMap<String, Value> symTable, MyHeap heapTable) throws ExpressionEvalException {
        return null;
    }

    @Override
    public Type typecheck(MyMap<String, Type> typeTable) throws TypecheckException {
        return null;
    }
}
