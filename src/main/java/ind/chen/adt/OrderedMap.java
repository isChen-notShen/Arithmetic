package ind.chen.adt;

public abstract class OrderedMap<K extends Comparable<K>, V> extends Map<K, V> {

    public abstract K max();

    public abstract K min();

    public abstract K floor(K key);

    public abstract K ceiling(K key);

    public abstract int rank(K key);

    public abstract K select(int k);

    public abstract void deleteMax();

    public abstract void deleteMin();

    public abstract int size(K lo, K hi);

    public abstract Iterable<K> keys(K lo, K hi);
}
