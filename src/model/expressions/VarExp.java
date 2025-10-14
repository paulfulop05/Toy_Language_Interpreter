package model.expressions;

import exceptions.MyException;
import model.adts.MyIDictionary;
import model.values.Value;

class VarExp implements Exp{
    String id;
 //....
    public Value eval(MyIDictionary<String,Value> tbl) throws MyException
    {return tbl.lookup(id);}
 //....

}
