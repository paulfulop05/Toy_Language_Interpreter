package model.states;

import exceptions.DefinedIdException;
import exceptions.UndefinedIdException;
import exceptions.ValueNotFoundException;
import model.types.Type;

import java.util.Map;

public interface TypeTableInterface {
    Type lookup(String key) throws UndefinedIdException, ValueNotFoundException;
    boolean isDefined(String key);
    void add(String key, Type value) throws DefinedIdException;
    Type remove(String key) throws UndefinedIdException;
    void update(String name, Type val) throws UndefinedIdException;
    Map<String, Type> getMap();
}
