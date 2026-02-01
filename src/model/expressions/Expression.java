package model.expressions;


import exceptions.ExpressionEvalException;
import exceptions.TypecheckException;
import model.states.map.*;
import model.types.Type;
import model.values.Value;

public interface Expression {
    Value evaluate(SymbolTable symTable, HeapTable heapTable) throws ExpressionEvalException;
    Type typecheck(TypeTable typeTable) throws TypecheckException;
}

