package model.expressions;

import exceptions.MyException;
import model.types.IntType;
import model.values.IntValue;
import model.adts.MyIDictionary;
import model.values.Value;

public class ArithExp implements Exp {
    private final Exp e1;
    private final Exp e2;
    private final int op; //1-plus, 2-minus, 3-star, 4-divide

    public ArithExp(Exp e1, Exp e2, int op) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }

    public Value eval(MyIDictionary<String, Value> tbl) throws MyException {
        Value v1,v2;
        v1 = e1.eval(tbl);
        v2 = e2.eval(tbl);

        if (!v1.getType().equals(IntType.INSTANCE) || !v2.getType().equals(IntType.INSTANCE)) {
            throw new MyException("ArithExp: invalid operation");
        }

        IntValue i1 = (IntValue)v1;
        IntValue i2 = (IntValue)v2;
        int n1,n2;
        n1= i1.getVal();
        n2 = i2.getVal();

        switch (op) {
            case 1 -> { return new IntValue(n1 + n2); }
            case 2 -> { return new IntValue(n1 - n2); }
            case 3 -> { return new IntValue(n1 * n2); }
            case 4 -> {
                if(n2 == 0) throw new MyException("division by zero");
                return new IntValue(n1 / n2);
            }
            default -> throw new MyException("ArithExp: invalid operation");
        }
    }
}
