package model.expressions;

import exceptions.MyException;
import model.adt.MyIDictionary;
import model.values.Value;

public class ValueExp implements Exp{
    Value e;
 //....
    public Value eval(MyIDictionary<String,Value> tbl) throws MyException {
        return e;
    }}
 //....}
