package model.states;

import exceptions.MyException;
import model.values.Value;

import java.util.LinkedList;
import java.util.List;

public class ArrayListOut implements OutInterface {
    private final List<Value> list;

    public ArrayListOut() {
        list = new LinkedList<Value>();
    }

    @Override
    public void add(Value value) {
        list.add(value);
    }

    @Override
    public Value getFirst() throws MyException {
        if (isEmpty()) throw new MyException("List is empty!");
        return list.getFirst();
    }

    @Override
    public void removeElementAt(int pos) throws MyException {
        if (isEmpty()) throw new MyException("List is empty!");
        list.remove(pos);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
