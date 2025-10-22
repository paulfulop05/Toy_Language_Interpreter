package controller;

import exceptions.MyException;
import model.adts.ProgramState;
import model.adts.ExecutionStackInterface;
import model.adts.LinkedListExecutionStack;
import model.adts.ArrayListOut;
import model.adts.MapSymbolTable;
import model.statements.StatementInterface;
import repo.ArrayListRepository;
import repo.Repository;

public class Controller {
    private final Repository repo = new ArrayListRepository();

    public void addNewProgram(ProgramState program) throws MyException {
        var executionStack = new LinkedListExecutionStack();
        repo.addProgramState(new ProgramState(
                executionStack,
                new MapSymbolTable(),
                new ArrayListOut()));
    }

    public ProgramState executeOneStep(ProgramState state) throws MyException {
        ExecutionStackInterface executionStack = state.exeStack();
        if(executionStack.isEmpty()) throw new MyException("state stack is empty");

        StatementInterface nextStatement = executionStack.pop();
        return nextStatement.execute(state);
    }

    public void allStep() throws MyException {
        var programState = repo.getCurrentState();
        while (!programState.exeStack().isEmpty()){
            executeOneStep(programState);
            displayCurrentState();
        }
    }

    public void displayCurrentState(){
        IO.print(repo.getCurrentState());
    }
}
