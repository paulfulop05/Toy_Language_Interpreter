package model.expressions;


import exceptions.MyException;
import model.adts.MyIDictionary;
import model.values.Value;

//TODO implement the functionalities for all expression classes
public interface Exp {
    Value eval(MyIDictionary<String,Value> tbl) throws MyException;
}

