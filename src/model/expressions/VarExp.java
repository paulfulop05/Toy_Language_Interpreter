package model.expressions;

import exceptions.MyException;
import model.adts.MyIDictionary;
import model.values.Value;

class VarExp implements Exp {
    private final String id;

    public VarExp(String id) {
        this.id = id;
    }

    public Value eval(MyIDictionary<String,Value> tbl) {
        return tbl.lookup(id);
    }
}
