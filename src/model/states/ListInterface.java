package model.states;

import exceptions.EmptyCollectionException;
import exceptions.InvalidPositionException;
import model.values.Value;

public interface ListInterface<T> {
    void add(T value);
    T getFirst() throws EmptyCollectionException;
    void removeElementAt(int pos) throws InvalidPositionException;
    boolean isEmpty();
}

