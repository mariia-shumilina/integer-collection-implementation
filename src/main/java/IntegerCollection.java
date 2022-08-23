/* Контейнер должен позволять добавлять, извлекать, удалять элементы */

import java.util.Arrays;

import static java.lang.Math.max;

public class IntegerCollection {
    private int[] data;
    private int amountOfElements;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 15;

    public IntegerCollection() {
        capacity = DEFAULT_CAPACITY;
        amountOfElements = 0;
    }

    public IntegerCollection(int wantedCapacity) {
        capacity = wantedCapacity;
        data = new int[capacity];
        amountOfElements = 0;
    }

    public IntegerCollection(int... elements) {
        amountOfElements = elements.length;
        capacity = max(DEFAULT_CAPACITY, amountOfElements);
        data = Arrays.copyOf(elements, amountOfElements);
    }
}

