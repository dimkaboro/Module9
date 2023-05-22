import java.util.LinkedList;
import java.util.List;

public class MyLinkedList<T> {
    private int size;
    private Node<T> head;

    private Node<T> tail;

    public MyLinkedList() {
    }

    public void add(T value) {
        Node<T> lastElement = tail;
        final Node<T> newNode = new Node<>(lastElement, value, null);
        lastElement = newNode;

        if (lastElement == null) {
            head = newNode;
        } else {
            lastElement.next = newNode;
        }
        size++;
    }


    public T remove(int index) {
        Node<T> nodeToRemove = findByIndex(index);
        unlink(nodeToRemove);
        return nodeToRemove.value;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return findByIndex(index).value;
    }



// Вложенный класс Node для удобства реализации MyLinkedList.
    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(Node<T> previous, T value, Node<T> next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new RuntimeException(
                    String.format("Index %d out of bounds. Size of list: %d", index, size)
            );
        }
    }

    private Node<T> findByIndex(int index) {
        checkIndex(index);
        Node<T> currentNode;
        if (index < (size >> 1)) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.previous;
            }
        }
        return currentNode;
    }

    private void unlink(Node<T> node) {
        Node<T> next = node.next;
        Node<T> previous = node.previous;
        if (previous == null) {
            head = next;
        } else {
            previous.next = next;
        }
        if (next == null) {
            tail = previous;
        } else {
            next.previous = previous;
        }
        size--;
    }
}

