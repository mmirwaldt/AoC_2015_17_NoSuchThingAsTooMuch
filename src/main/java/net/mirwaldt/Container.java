package net.mirwaldt;

import java.util.Objects;

public class Container {
    private final int number;
    private final int capacity;

    public Container(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return number == container.number && capacity == container.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, capacity);
    }

    @Override
    public String toString() {
        return "Container{" +
                "number=" + number +
                ", capacity=" + capacity +
                '}';
    }
}
