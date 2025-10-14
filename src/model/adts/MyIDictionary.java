package model.adts;


// TODO design this as a ADT dictionary
public interface MyIDictionary<K, V>{
    V lookup(K id);

    boolean isDefined(K id);

    void update(K id, V val);
}