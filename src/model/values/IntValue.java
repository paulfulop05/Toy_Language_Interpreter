package model.values;

import model.types.IntType;
import model.types.Type;

public class IntValue implements Value{
    int val;
    IntValue(int v){val=v;}

    int getVal() {return val;}

    @Override
    public String toString() {
        //TODO implement this
        return "";
    }

    public Type getType() { return new IntType();}
}

