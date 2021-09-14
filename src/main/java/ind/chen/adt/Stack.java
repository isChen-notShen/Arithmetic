package ind.chen.adt;

public abstract class Stack<Item> implements Iterable<Item> {

    public abstract void push(Item item);

    public abstract Item pop();

    public abstract int size();

    public boolean isEmpty(){
        return size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Stack: { ");
        for (Item i : this) {
            buffer.append(i).append(" ");
        }
        buffer.append("}");
        return buffer.toString();
    }
}
