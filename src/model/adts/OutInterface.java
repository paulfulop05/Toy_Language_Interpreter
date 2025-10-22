package model.adts;

import exceptions.MyException;
import model.values.Value;

public interface OutInterface{
    void add(Value value);
    Value getFirst() throws MyException;
    void removeElementAt(int pos) throws MyException;
    boolean isEmpty();
}

