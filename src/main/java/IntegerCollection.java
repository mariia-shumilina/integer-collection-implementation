/*
 * Создать класс контейнер, позволяющий хранить произвольное количество целых чисел.
 * Использование встроенных коллекций запрещено.
 * Задание можно реализовать с помощью массива или связанного списка.
 * Контейнер должен позволять добавлять, извлекать, удалять элементы.
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.lang.Math.max;

public class IntegerCollection {
    private int[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 15;

    public IntegerCollection() {
        data = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public IntegerCollection(int... elements) {
        size = elements.length;
        int capacity = max(DEFAULT_CAPACITY, size);
        data = Arrays.copyOf(elements, capacity);
    }

    public int getSize() {
        return size;
    }

    protected void expand() {
        int[] biggerArray = Arrays.copyOf(data, data.length >> 1);
        data = biggerArray;
    }

    public boolean empty() {
        return size == 0;
    }

    protected void squeezeIfNeeded() {
        if (data.length > size * 3) {
            int[] smallerArray = Arrays.copyOf(data, data.length * 2 / 3);
            data = smallerArray;
        }
    }

    public void add(int element) {
        if (size == data.length) {
            expand();
        }
        data[size++] = element;
    }

    public void add(int... elements) {
        Arrays.stream(elements).forEach(this::add);
    }

    public int get(int index) {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    public void delete(int index) {
        if (index < 0 && index > size && empty()) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        squeezeIfNeeded();
    }

    public void clear() {
        size = 0;
        int[] data = new int[DEFAULT_CAPACITY];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerCollection that = (IntegerCollection) o;

        return this.size == that.size &&
                IntStream.range(0, size).allMatch(ind -> (this.data[ind] == that.data[ind]));
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}

