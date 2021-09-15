package ind.chen;

/**
 * 链表翻转问题
 *
 * @author Mr.Chen
 **/
public abstract class LinkedListInversion {

    public static <T> Node<T> recursion(Node<T> head) {
        if (head.next == null){
            return head;
        }
        Node<T> nextTo = recursion(head.next);
        head.next.next = head;
        head.next = null;   //该步骤可以将原链表的头元素的next指向null;
        return nextTo;
    }

    public static <T> Node<T> iteration(Node<T> head) {
        Node<T> prev = null, next;
        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static class Node<T> {

        public T val;

        public Node<T> next;

        public Node() {
        }


        public Node(T item, Node<T> next) {
            this.val = item;
            this.next = next;
        }
    }
}
