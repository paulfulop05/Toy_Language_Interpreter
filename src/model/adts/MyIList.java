package model.adts;

import exceptions.MyException;

public interface MyIList<T>{
    void add(T value);
    T getElementAt(int pos) throws MyException;
    T getFirst() throws MyException;
    T getLast() throws MyException;
    void removeElementAt(int pos) throws MyException;
    int getSize();
    boolean isEmpty();
    boolean find(T value);
}

