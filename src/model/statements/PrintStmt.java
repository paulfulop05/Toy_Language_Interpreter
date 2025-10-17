package model.statements;

import model.PrgState;
import model.expressions.Exp;
import exceptions.MyException;

public class PrintStmt implements Istmt{
    Exp exp;

    public PrintStmt(Exp exp) {
        this.exp = exp;
    }

    @Override
    public String toString(){
        return "print(" +exp.toString()+")";
    }

    public PrgState execute(PrgState state) throws MyException {
        var out = state.getOut();
        out.push(exp.eval(state.getSymTable()));

        return state;
    }

}
