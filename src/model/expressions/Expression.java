package model.expressions;


import exceptions.ExpressionEvalException;
import exceptions.MyException;
import model.states.SymbolTableInterface;
import model.values.Value;

public interface Expression {
    Value evaluate(SymbolTableInterface symTable) throws ExpressionEvalException;
}

