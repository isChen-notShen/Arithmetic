package ind.chen.adt;

/**
 * @author Mr.Chen
 **/
public abstract class PriorityQueue<Key> {

    public PriorityQueue(Boolean isMaxPQ){}

    public abstract void insert(Key v);

    public abstract Key pop();

    public abstract Key get();

    public abstract boolean isEmpty();

    public abstract int size();
}
