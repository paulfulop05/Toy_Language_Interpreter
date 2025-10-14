package model.adts;

import java.util.Stack;

class MyStack<T> implements MyIStack<T> {
    Stack<T> stack; //a field whose type CollectionType is an appropriate generic java library collection

    @Override
    public T pop() {
        return null;
    }

    @Override
    public void push(T v) {
    }
}
