package ind.chen.adt.imp;

import ind.chen.adt.Stack;

import java.util.Iterator;

public class LinkedStack<Item> extends Stack<Item> {
    private Node first;
    private int size;

    //预留一个空Node对象，代表链表头
    LinkedStack() {
        first = null;
        size = 0;
    }

    @Override
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    @Override
    public Item pop() {
        if (size > 0) {
            Item item = first.item;
            first = first.next;
            size--;
            return item;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new IteratorOfLinkedStack();
    }

    private class IteratorOfLinkedStack implements Iterator<Item> {
        private Node f = first;

        @Override
        public boolean hasNext() {
            return f != null;
        }

        @Override
        public Item next() {
            Item item = f.item;
            f = f.next;
            return item;
        }
    }

    private class Node {
        Item item;
        Node next;
    }
}
