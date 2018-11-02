package com.codurance;

import java.util.Objects;

public abstract class Direction {

    private String direction;

    public abstract Direction moveRight();

    public abstract Direction moveLeft();

    public abstract Coordinate moveForward(Coordinate coordinate, World world);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction1 = (Direction) o;
        return Objects.equals(direction, direction1.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "direction='" + direction + '\'' +
                '}';
    }
}
