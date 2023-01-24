package ind.chen.adt;

/**
 * key-value结构
 * 这里的定义类似于Java中Map的定义。允许value为null，但不允许key为null
 * 
 * @author shili.shen
 */
public abstract class Map<K, V> implements Iterable<K> {

    public abstract void put(K key, V value);

    public abstract V get(K key);

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public abstract void delete(K key);

    public abstract int size();

    public abstract Iterable<K> keys();

}
