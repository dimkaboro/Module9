import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T> {
    public int size;
    private Node<T> head;
    private Node<T> tail;

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if(head == null) {
            head = node;
        }
        if(tail != null) {
            tail.next = node;
        }
        tail = node;
        size++;
    }
    public T poll() {
        if(head == null) {
            return null;
        }
        T value = head.value;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        size--;
        return value;
    }
    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public T peek() {
        return head.value;
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
