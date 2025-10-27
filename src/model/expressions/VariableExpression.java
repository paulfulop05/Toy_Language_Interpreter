package model.expressions;

import exceptions.ExpressionEvalException;
import exceptions.MyException;
import model.states.SymbolTableInterface;
import model.values.Value;

public record VariableExpression(String id) implements Expression {

    public Value evaluate(SymbolTableInterface symTable) throws ExpressionEvalException {
        try{
            return symTable.lookup(id);
        }
        catch (Exception e){
            throw new ExpressionEvalException("VariableExpression: variable not found");
        }
    }

    @Override
    public String toString() {
        return id;
    }
}
