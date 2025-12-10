package model.states;

import exceptions.EmptyCollectionException;

import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack<T> implements StackInterface<T> {
    Stack<T> stack;

    public MyStack() {this.stack = new Stack<>();}

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyCollectionException();
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

    @Override
    public String toString() {
        String text = "";
        for (int i = stack.size() - 1; i >= 0; i--) {
            text += stack.get(i).toString() + '\n';
        }

        return text;
    }
}
