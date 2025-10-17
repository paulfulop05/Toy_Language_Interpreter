package model.adts;

import exceptions.MyException;

import java.util.ArrayList;
import java.util.List;

class MyList<T> implements MyIList<T> {
    private int capacity;
    private int size;
    private final List<T> list;

    MyList() {
        capacity = 10;
        size = 0;
        list = new ArrayList<>(capacity);
    }


    @Override
    public void add(T value) {
        if  (size == capacity) { resize(); }
        list.add(value);
        size++;
    }

    private void resize() {
        capacity *= 2;
    }

    @Override
    public T getElementAt(int pos) throws MyException {
        if (pos < 0 || pos >= size) throw new MyException("Out of bounds!");
        return list.get(pos);
    }

    @Override
    public T getFirst() throws MyException {
        if (isEmpty()) throw new MyException("List is empty!");
        return list.getFirst();
    }

    @Override
    public T getLast() throws MyException {
        if (isEmpty()) throw new MyException("List is empty!");
        return list.getLast();
    }

    @Override
    public void removeElementAt(int pos) throws MyException {
        if (isEmpty()) throw new MyException("List is empty!");
        list.remove(pos);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean find(T value) {
        return list.contains(value);
    }
}
