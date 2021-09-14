package ind.chen.adt.imp;

import ind.chen.adt.Stack;

import java.util.Iterator;

public class ResizingArrayStack<Item> extends Stack<Item> {
    private Item[] ints;
    private int size = 0;

    ResizingArrayStack() {
        ints = (Item[]) new Object[0];
    }

    ResizingArrayStack(int cap) {
        if (cap < 0)
            throw new IllegalArgumentException("Capacity cannot be negative.");
        ints = (Item[]) new Object[cap];
    }

    public void push(Item item) {
        if (size == ints.length) {
            if (size == 0)
                resize(1);
            else
                resize(2 * ints.length);
        }
        ints[size++] = item;
    }

    public Item pop() {
        if (size <= 0) return null;
        Item item = ints[--size];
        ints[size] = null;     //避免对象游离
        if (size > 0 && size == ints.length / 4) resize(ints.length / 2);
        return item;
    }

    public int getCapacity(){
        return ints.length;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = ints[i];
        }
        ints = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return ints[--i];
        }

    }
}
