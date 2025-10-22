package model.expressions;


import exceptions.MyException;
import model.adts.SymbolTableInterface;
import model.values.Value;

public interface Expression {
    Value evaluate(SymbolTableInterface symTable) throws MyException;
}

