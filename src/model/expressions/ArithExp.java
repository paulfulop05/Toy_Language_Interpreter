package model.expressions;

import exceptions.MyException;
import model.types.IntType;
import model.values.IntValue;
import model.adts.MyIDictionary;
import model.values.Value;

// TODO make it look better + add some other functions if needed
public class ArithExp implements Exp {
    Exp e1;
    Exp e2;
    int op; //1-plus, 2-minus, 3-star, 4-divide
 //....

    public Value eval(MyIDictionary<String, Value> tbl) throws MyException {
        Value v1,v2;
        v1= e1.eval(tbl);
        if (v1.getType().equals(IntType.INSTANCE)) {
            v2 = e2.eval(tbl);
            if (v2.getType().equals(IntType.INSTANCE)) {
                IntValue i1 = (IntValue)v1;
                IntValue i2 = (IntValue)v2;
                int n1,n2;
                n1= i1.getVal();
                n2 = i2.getVal();
                if (op==1) return new IntValue(n1+n2);
                if (op ==2) return new IntValue(n1-n2);
                if(op==3) return new IntValue(n1*n2);
                if(op==4)
                    if(n2==0) throw new MyException("division by zero");
                    else return new IntValue(n1/n2);
            }else
                throw new MyException("second operand is not an integer");
        }else
            throw new MyException("first operand is not an integer");

        //possibly not correct, to be revised
        return v1;
    }
}
