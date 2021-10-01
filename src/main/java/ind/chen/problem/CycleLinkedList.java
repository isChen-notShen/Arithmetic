package ind.chen.problem;

/**
 * @author Mr.Chen
 **/
public abstract class CycleLinkedList {

    public static void main(String[] args) {
        Node<Integer> e = new Node<>(5, null);
        Node<Integer> d = new Node<>(4, e);
        Node<Integer> c = new Node<>(3, d);
        Node<Integer> b = new Node<>(2, c);
        Node<Integer> a = new Node<>(1, b);
        e.next = c;
        System.out.println(hasCycle(a));
    }

    public static <T> boolean hasCycle(Node<T> head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node<T> slow = head, quick = head.next;
        while (quick.next != null && quick.next.next != null) {
            if (quick == slow) {
                return true;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return false;
    }

    public static class Node<T> {
        public T value;
        public Node<T> next;

        public Node() {
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
