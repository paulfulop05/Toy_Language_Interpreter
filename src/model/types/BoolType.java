package model.types;

public class BoolType implements Type {

    public static final BoolType INSTANCE = new BoolType();
    private BoolType() {}

    @Override
    public boolean equals(Object another){
        return another instanceof BoolType;
    }

    @Override
    public String toString() { return "bool";}
}

