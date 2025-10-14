package model;


import model.adts.MyIDictionary;
import model.adts.MyIList;
import model.adts.MyIStack;
import model.statements.Istmt;
import model.values.Value;

// TODO classes for execution stack, symbol table and out

public class PrgState{
    MyIStack<Istmt> exeStack;
    MyIDictionary<String, Value> symTable;
    MyIList<Value> out;
    Istmt originalProgram; //optional field, but good to have
    PrgState(MyIStack<Istmt> stk, MyIDictionary<String,Value> symtbl, MyIList<Value>
            ot, Istmt prg){
        exeStack=stk;
        symTable=symtbl;
        out = ot;
        //originalProgram = prg.hashCode(); TODO fix this maybe later (*optional)
        stk.push(prg);
    }

    public MyIStack<Istmt> getStk(){
        return exeStack;
    }

    MyIDictionary<String, Value> getSymtbl(){
        return symTable;
    }

    MyIList<Value> getOut(){
        return out;
    }

    public MyIDictionary<String, Value> getSymTable() {
        return  symTable;
    }

    // get variable type ? see on teams

    // TODO THIS MAY NEED TO BE PUT IN A CONTROLLER
//    PrgState oneStep(PrgState state) throws MyException {
//        MyIStack<Istmt> stk=state.getStk();
//        if(stk.isEmpty()) throw new MyException("prgstate stack is empty");
//        Istmt crtStmt = stk.pop();
//        return crtStmt.execute(state);
//    }

//TODO this also implemented in controller

//    void allStep(){
//        PrgState prg = repo.getCrtPrg(); // repo is the controller field of type MyRepoInterface
//        //here you can display the prg state
//        while (!prg.getStk().isEmpty()){
//            oneStep(prg);
//            //here you can display the prg state
//        }
//    }
}

