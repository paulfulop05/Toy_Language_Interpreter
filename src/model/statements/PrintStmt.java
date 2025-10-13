package model.statements;

import model.PrgState;
import model.expressions.Exp;
import exceptions.MyException;

public class PrintStmt implements Istmt{
    Exp exp;
 //....

    @Override
    public String toString(){
        return "print(" +exp.toString()+")";
    }

    public PrgState execute(PrgState state) throws MyException{
 //......
        return state;
    }

    //...
}
