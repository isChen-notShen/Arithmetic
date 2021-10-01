package ind.chen.adt.imp;

import ind.chen.adt.PriorityQueue;

import java.util.Comparator;

/**
 * @author Mr.Chen
 **/
public class HeapPriorityQueue<Key> extends PriorityQueue<Key> {

    private static final int INITIAL_CAPACITY = 8;

    private Object[] heap;

    private int size;

    public HeapPriorityQueue() {
        super(false);
        init(INITIAL_CAPACITY);
    }

    public HeapPriorityQueue(boolean isMaxPQ) {
        super(isMaxPQ);
        init(INITIAL_CAPACITY);
    }

    public HeapPriorityQueue(boolean isMaxPQ, int initialCapacity) {
        super(isMaxPQ);
        init(initialCapacity);
    }

    public HeapPriorityQueue(boolean isMaxPQ, Comparator<? super Key> comparator) {
        super(isMaxPQ, comparator);
        init(INITIAL_CAPACITY);
    }

    private void init(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("队列初始容量不能小于1");
        }
        heap = new Object[capacity + 1];
        this.size = 0;
    }

    @Override
    public void insert(Key v) {
        if (++size >= heap.length)
            resize();
        heap[size] = v;
        swim(size);
    }

    @Override
    public Key pop() {
        Key key = (Key) heap[1];
        heap[1] = heap[size];
        heap[size] = null;
        size--;
        sink(1);
        return key;
    }

    @Override
    public Key get() {
        return (Key) heap[1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void exchange(int i, int j) {
        Object temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && (isMaxPQ == less((Key) heap[k / 2], (Key) heap[k]))) {
            exchange(k, k / 2);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && (isMaxPQ == less((Key) heap[j], (Key) heap[j + 1])))
                j++;
            if (isMaxPQ == less((Key) heap[j], (Key) heap[k]))
                break;
            exchange(k, j);
            k = j;
        }
    }

    private void resize() {
        Object[] newHeap = new Object[heap.length * 2 + 1];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
    }

}
