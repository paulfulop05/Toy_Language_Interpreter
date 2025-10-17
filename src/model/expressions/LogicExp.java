package model.expressions;

import exceptions.MyException;
import model.adts.MyIDictionary;
import model.types.BoolType;
import model.types.IntType;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.Value;

public class LogicExp implements Exp {
    private final Exp e1;
    private final Exp e2;
    private final int op; //1-and, 2-or (possibly more in the future)

    public LogicExp(Exp e1, Exp e2, int op) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }

    public Value eval(MyIDictionary<String,Value> tbl) throws MyException {
        Value v1,v2;
        v1 = e1.eval(tbl);
        v2 = e2.eval(tbl);

        if (!v1.getType().equals(BoolType.INSTANCE) || !v2.getType().equals(BoolType.INSTANCE)) {
            throw new MyException("LogicExp: invalid operation");
        }

        BoolValue b1 = (BoolValue) v1;
        BoolValue b2 = (BoolValue) v2;
        boolean n1, n2;
        n1 = b1.getVal();
        n2 = b2.getVal();

        switch (op) {
            case 1 -> { return new BoolValue(n1 && n2); }
            case 2 -> { return new BoolValue(n1 || n2); }
            default -> throw new MyException("LogicExp: invalid operation");
        }
    }
}

