package model.expressions;

import exceptions.MyException;
import model.adts.MyIDictionary;
import model.values.Value;

public class ValueExp implements Exp {
    private final Value e;

    public ValueExp(Value e) {
        this.e = e;
    }

    public Value eval(MyIDictionary<String,Value> tbl) {
        return e;
    }
}
