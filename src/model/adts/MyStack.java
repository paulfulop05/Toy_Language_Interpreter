package model.adts;

import exceptions.MyException;

import java.util.Stack;

class MyStack<T> implements MyIStack<T> {
    Stack<T> stack;

    @Override
    public T pop() throws MyException {
        if (isEmpty()) throw new MyException("The stack is already empty!");
        return stack.pop();
    }

    @Override
    public void push(T v) {
        stack.push(v);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
