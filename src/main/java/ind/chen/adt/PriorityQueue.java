package ind.chen.adt;

import java.util.Comparator;

/**
 * @author Mr.Chen
 **/
public abstract class PriorityQueue<Key> {

    protected boolean isMaxPQ = true;

    protected Comparator<? super Key> comparator;

    public PriorityQueue(Boolean isMaxPQ) {
        this.isMaxPQ = isMaxPQ;
    }

    public PriorityQueue(Boolean isMaxPQ, Comparator<? super Key> comparator) {
        this(isMaxPQ);
        this.comparator = comparator;
    }

    public void setComparator(Comparator<? super Key> comparator) {
        this.comparator = comparator;
    }

    public abstract void insert(Key v);

    public abstract Key pop();

    public abstract Key get();

    public abstract boolean isEmpty();

    public abstract int size();

    protected boolean less(Key a, Key b) throws ClassCastException {
        if (a instanceof Comparable && b instanceof Comparable) {
            return ((Comparable<? super Key>) a).compareTo(b) < 0;
        }

        return comparator.compare(a, b) < 0;
    }
}
