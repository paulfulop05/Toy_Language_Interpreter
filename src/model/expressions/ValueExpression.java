package model.expressions;

import model.adts.SymbolTableInterface;
import model.values.Value;

public record ValueExpression(Value e) implements Expression {

    public Value evaluate(SymbolTableInterface symTable) {
        return e;
    }
}
