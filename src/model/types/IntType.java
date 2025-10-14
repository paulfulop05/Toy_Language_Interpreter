package model.types;

public class IntType implements Type {

    public static final IntType INSTANCE = new IntType();
    private IntType() {}

    @Override
    public boolean equals(Object another){
        return another instanceof IntType;
    }

    @Override
    public String toString() { return "int";}
}

