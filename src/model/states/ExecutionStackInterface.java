package model.states;

import exceptions.MyException;
import model.statements.StatementInterface;

public interface ExecutionStackInterface{
    StatementInterface pop() throws MyException;
    void push(StatementInterface v);
    boolean isEmpty();
}

