package model.statements;

import model.PrgState;
import model.expressions.Exp;
import exceptions.MyException;

class IfStmt implements Istmt{
    Exp exp;
    Istmt thenS;
    Istmt elseS;
 //....
    IfStmt(Exp e, Istmt t, Istmt el) {exp=e; thenS=t;elseS=el;}

    @Override
    public String toString(){ return "(IF("+ exp.toString()+") THEN(" +thenS.toString()
            +")ELSE("+elseS.toString()+"))";}

    public PrgState execute(PrgState state) throws MyException{
 //......
        return state;
    }
 //...
}
