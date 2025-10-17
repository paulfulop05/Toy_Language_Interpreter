package model.statements;

import exceptions.MyException;
import model.adts.MyIStack;
import model.PrgState;

public class CompStmt implements Istmt {
    Istmt first;
    Istmt second;

    @Override
    public String toString() {
        return "("+first.toString() + ";" + second.toString()+")";
    }

    public CompStmt(Istmt second, Istmt first) {
        this.second = second;
        this.first = first;
    }

    public PrgState execute(PrgState state) throws MyException {
        var exeStack = state.getExeStack();
        exeStack.push(second);
        exeStack.push(first);
        return state;
    }
}
