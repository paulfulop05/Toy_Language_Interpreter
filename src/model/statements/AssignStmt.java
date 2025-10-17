package model.statements;

import model.PrgState;
import model.expressions.Exp;
import exceptions.MyException;
import model.values.Value;
import model.adts.MyIDictionary;
import model.adts.MyIStack;
import model.types.Type;

public class AssignStmt implements Istmt {
    private final String name;
    private final Exp exp;

    public AssignStmt(String name, Exp exp) {
        this.name = name;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return name + " = " + exp.toString();
    }

    public PrgState execute(PrgState state) throws MyException {
        var symTable = state.getSymTable();

        if (symTable.isDefined(name)) {
            Value val = exp.eval(symTable);
            Type typeId = (symTable.lookup(name)).getType();
            if (val.getType().equals(typeId))
                symTable.update(name, val);
            else
                throw new MyException("declared type of variable " + name + " and type of the assigned expression do not match");
        } else throw new MyException("the used variable " + name + " was not declared before");
        return state;
    }
}
