package model.statements;

import model.PrgState;
import model.expressions.Exp;
import exceptions.MyException;
import model.values.Value;
import model.adt.MyIDictionary;
import model.adt.MyIStack;
import model.types.Type;

public class AssignStmt implements Istmt {
    String id;
    Exp exp;

    //....
    @Override
    public String toString() {
        return id + "=" + exp.toString();
    }


    public PrgState execute(PrgState state) throws MyException {
        MyIStack<Istmt> stk = state.getStk();

        MyIDictionary<String, Value> symTbl = state.getSymTable();

        if (symTbl.isDefined(id)) {
            Value val = exp.eval(symTbl);
            Type typId = (symTbl.lookup(id)).getType();
            if (val.getType().equals(typId))
                symTbl.update(id, val);
            else
                throw new MyException("declared type of variable" + id + " and type of the assigned expression do not match");
        } else throw new MyException("the used variable" + id + " was not declared before");
        return state;
        //...
    }
}
