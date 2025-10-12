package model.statements;

import exceptions.MyException;
import model.PrgState;

public interface Istmt {
    PrgState execute(PrgState state) throws MyException;
    //which is the execution method for a statement.
}
