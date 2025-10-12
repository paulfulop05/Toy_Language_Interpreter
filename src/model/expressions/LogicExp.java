package model.expressions;

import exceptions.MyException;
import model.adt.MyIDictionary;
import model.values.Value;

public class LogicExp implements Exp {
    Exp e1;
    Exp e2;
    int op;
 //....
    public Value eval(MyIDictionary<String,Value> tbl) throws MyException {
        //...
        return(e1.eval(tbl));
    }
}

