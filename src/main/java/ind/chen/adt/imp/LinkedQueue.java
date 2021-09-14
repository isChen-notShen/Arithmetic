package ind.chen.adt.imp;

import ind.chen.adt.Queue;

import java.util.Iterator;

public class LinkedQueue<Item> extends Queue<Item> {
    private Node oldest;
    private Node latest;
    private int size;

    public LinkedQueue() {
        oldest = null;
        latest = null;
        size = 0;
    }


    @Override
    public void enqueue(Item item) {
        if (item == null) return;
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            oldest = node;
            latest = node;
        } else {
            latest.next = node;
            latest = node;
        }
        size++;
    }

    @Override
    public Item dequeue() {
        if (isEmpty()) return null;
        Item item = oldest.item;
        oldest = oldest.next;
        size--;
        if (isEmpty()) latest = null;
        return item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedQueueIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class LinkedQueueIterator implements Iterator<Item> {
        private Node current = oldest;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
