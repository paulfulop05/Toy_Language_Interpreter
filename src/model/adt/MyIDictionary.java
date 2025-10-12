package model.adt;


// TODO design this as a ADT dictionary
public interface MyIDictionary<K, V>{
    V lookup(K id);
}