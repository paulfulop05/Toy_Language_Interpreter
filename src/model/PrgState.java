package model;


import model.adts.MyIDictionary;
import model.adts.MyIList;
import model.adts.MyIStack;
import model.statements.Istmt;
import model.values.Value;

public class PrgState {
    private final MyIStack<Istmt> exeStack;
    private final MyIDictionary<String, Value> symTable;
    private final MyIList<Value> out;
    //Istmt originalProgram; //optional field, but good to have

    PrgState(MyIStack<Istmt> exeStack, MyIDictionary<String,Value> symTable, MyIList<Value> out, Istmt prg) {
        this.exeStack = exeStack;
        this.symTable = symTable;
        this.out = out;
        //originalProgram = prg.hashCode(); TODO look at this maybe later (*optional)
        exeStack.push(prg);
    }

    public MyIStack<Istmt> getExeStack(){
        return exeStack;
    }

    public MyIDictionary<String, Value> getSymTable(){
        return symTable;
    }

    public MyIList<Value> getOut(){
        return out;
    }
}

