package ind.chen.adt;

public abstract class Queue<Item> implements Iterable<Item> {

    public abstract void enqueue(Item item);

    public abstract Item dequeue();

    public abstract int size();

    public boolean isEmpty(){
        return size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Queue: { ");
        for (Item i : this) {
            buffer.append(i).append(" ");
        }
        buffer.append("}");
        return buffer.toString();
    }
}
