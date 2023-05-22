import java.util.EmptyStackException;

public class MyStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private T[] stack;

    public MyStack() {
        stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        if (size == stack.length) {
            increaseCapacity();
        }
        stack[size] = value;
        size++;
    }

    public int size() {
       return size;
}

    public Object remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Object removedElement = stack[index];

        for (int i = index; i < size; i++) {
            stack[i] = stack[i + 1];
        }
        stack[size] = null;
        size--;
        return removedElement;
    }

    public void clear() {
        stack = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public T peek() {
        checkSize();
        return stack[size - 1];
    }

    public T pop() {
        checkSize();
        T elementToRemove = stack[size - 1];
        stack[size - 1] = null;
        size--;
        return elementToRemove;
    }

    private void checkSize() {
        if(size == null) {
            throw new EmptyStackException();
        }
    }

    private void increaseCapacity() {
        int newCapacity = stack.length + (stack.length >> 1);
        T[] newData = (T[]) new Object[newCapacity];
        System.arraycopy(stack, 0, newData, 0, size);
        stack = newData;
    }


    private static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
