package model.statements;

import model.PrgState;
import model.expressions.Exp;
import exceptions.MyException;
import model.types.BoolType;
import model.values.BoolValue;

class IfStmt implements Istmt{
    Exp exp;
    Istmt thenS;
    Istmt elseS;

    IfStmt(Exp exp, Istmt thenS, Istmt elseS) {
        this.exp = exp;
        this.thenS = thenS;
        this.elseS = elseS;
    }

    @Override
    public String toString(){ return "(IF("+ exp.toString()+") THEN(" +thenS.toString()
            +")ELSE("+elseS.toString()+"))";}

    public PrgState execute(PrgState state) throws MyException{
        var exeStack = state.getExeStack();
        var cond = exp.eval(state.getSymTable());
        if (cond.getType() == BoolType.INSTANCE) {
            if (cond.equals(new BoolValue(true)))
                exeStack.push(thenS);
            else
                exeStack.push(elseS);
        }
        else throw new MyException("Condition is not boolean");

        return state;
    }
}
