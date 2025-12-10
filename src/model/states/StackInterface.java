package model.states;

import model.statements.StatementInterface;
import java.util.EmptyStackException;

public interface StackInterface<T> {
    T pop() throws EmptyStackException;
    void push(T v);
    boolean isEmpty();
}

