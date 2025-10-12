package model.statements;

import exceptions.MyException;
import model.adt.MyIStack;
import model.PrgState;

public class CompStmt implements Istmt {
    Istmt first;
    Istmt snd;

    @Override
    public String toString() {
        return "("+first.toString() + ";" + snd.toString()+")";
    }

    PrgState execute(PrgState state) throws MyException {
        MyIStack<Istmt> stk = state.getStk();
        stk.push(snd);
        stk.push(first);
        return state;
    }
}
}
