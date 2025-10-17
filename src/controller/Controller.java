package controller;

import exceptions.MyException;
import model.PrgState;
import model.adts.MyIStack;
import model.statements.Istmt;
import repo.MemoryRepository;
import repo.Repository;

public class Controller {
    private final Repository repo = new MemoryRepository(); // TODO probably not good like this but works for now

    public PrgState oneStep(PrgState state) throws MyException {
        MyIStack<Istmt> stk= state.getExeStack();
        if(stk.isEmpty()) throw new MyException("prgstate stack is empty");
        Istmt crtStmt = stk.pop();
        return crtStmt.execute(state);
    }

    public void allStep() throws MyException {
        PrgState prg = repo.getCurrentPrg(); // repo is the controller field of type MyRepoInterface
        //here you can display the prg state
        while (!prg.getExeStack().isEmpty()){
            oneStep(prg);
            //here you can display the prg state
        }
    }
}
