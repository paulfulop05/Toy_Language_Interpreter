package model.states;

import exceptions.MyException;
import model.values.Value;

public interface SymbolTableInterface{
    Value lookup(String key) throws MyException;
    boolean isDefined(String key);
    void add(String key, Value value) throws MyException;
    Value remove(String key) throws MyException;
    void update(String name, Value val);
}