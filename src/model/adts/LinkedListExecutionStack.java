package model.adts;

import exceptions.MyException;
import model.statements.StatementInterface;

import java.util.Stack;

public class LinkedListExecutionStack implements ExecutionStackInterface {
    Stack<StatementInterface> stack;

    @Override
    public StatementInterface pop() throws MyException {
        if (isEmpty()) throw new MyException("The stack is already empty!");
        return stack.pop();
    }

    @Override
    public void push(StatementInterface v) {
        stack.push(v);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
