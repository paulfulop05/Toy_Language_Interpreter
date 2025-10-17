package model.adts;

import exceptions.MyException;

public interface MyIDictionary<K, V>{
    V lookup(K key) throws MyException;
    boolean isDefined(K key);
    void add(K key, V value) throws MyException;
    V remove(K key) throws MyException;
}