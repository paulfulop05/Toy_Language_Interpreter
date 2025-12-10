package model.expressions;


import exceptions.ExpressionEvalException;
import exceptions.TypecheckException;
import model.states.HeapInterface;
import model.types.Type;
import model.values.Value;

public interface Expression {
    Value evaluate(SymbolTableInterface symTable, HeapInterface heapTable) throws ExpressionEvalException;
    Type typecheck(TypeTableInterface typeTable) throws TypecheckException;
}

