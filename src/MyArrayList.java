import java.util.ArrayList;
import java.util.List;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] data;
    private int size;


    public MyArrayList() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }


    public void add(T element) {
        if (size == data.length) {
            increaseCapacity();
        }
        data[size] = element;
        size++;
    }

    public void clear() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }


    public T get(int index) {
        checkIndex(index);
        return data[index];
    }


    public T remove(int index) {
        checkIndex(index);
        final T removingElement = get(index);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
        return removingElement;
    }

    private void increaseCapacity() {
        int newCapacity = data.length + (data.length >> 1);
        T[] newData = (T[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new RuntimeException(
                    String.format("Index %d out of bounds. Size of list: %d", index, size)
            );
        }
    }
}
