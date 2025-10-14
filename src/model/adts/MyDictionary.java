package model.adts;

class MyDictionary<K, V> implements MyIDictionary<K, V> {
    @Override
    public V lookup(K id) {
        return null;
    }

    @Override
    public boolean isDefined(K id) {
        return false;
    }

    @Override
    public void update(K id, V val) {

    }
    //Dictionary<K, V> stack; //a field whose type CollectionType is an appropriate generic java library collection

    //TODO implment the dict as follows
}
