package model.states;

import exceptions.DefinedIdException;
import exceptions.UndefinedIdException;
import exceptions.ValueNotFoundException;
import model.values.Value;

// not good, i need to change this
public interface FileTableInterface {
    Value lookup(String key) throws UndefinedIdException, ValueNotFoundException;
    boolean isDefined(String key);
    void add(String key, Value value) throws DefinedIdException;
    Value remove(String key) throws UndefinedIdException;
    void update(String name, Value val) throws UndefinedIdException;
}
