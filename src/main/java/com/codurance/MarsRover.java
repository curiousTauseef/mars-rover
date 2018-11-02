package com.codurance;

public class MarsRover {
    private World world;
    private Coordinate coordinate;
    private Direction direction;

    public MarsRover(World world, Coordinate coordinate, Direction direction) {
        this.world = world;
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public void move(String moveCommand) {
        if (moveCommand.equals("L")) {
            moveLeft();
        } else if (moveCommand.equals("R")) {
            moveRight();
        } else {
            moveForward();
            wrapPosition();
        }
    }

    private void wrapPosition() {
        if (!world.IsInsideYourXUpperLimit(coordinate.xCoordinate))
            this.coordinate.xCoordinate = World.LOWER_LIMIT;
        if (!world.IsInsideYourXLowerLimit(coordinate.xCoordinate))
            this.coordinate.xCoordinate = world.xUpperLimit();
        if (!world.IsInsideYourYUpperLimit(coordinate.yCoordinate))
            this.coordinate.yCoordinate = World.LOWER_LIMIT;
        if (!world.IsInsideYourYLowerLimit(coordinate.yCoordinate))
            this.coordinate.yCoordinate = world.yUpperLimit();
    }

    private void moveLeft() {
        LeftCommand command = new LeftCommand(direction);
        direction = command.execute();
    }

    private void moveRight() {
        direction = direction.moveRight();
    }

    private void moveForward() {
        if (direction == Direction.WEST)
            this.coordinate.xCoordinate -= 1;
        else if (direction == Direction.EAST)
            this.coordinate.xCoordinate += 1;
        else if (direction == Direction.NORTH)
            this.coordinate.yCoordinate += 1;
        else
            this.coordinate.yCoordinate -= 1;
    }

    public boolean isDirection(Direction direction) {
        return this.direction.equals(direction);
    }

    public boolean isPosition(int xPosition , int yPosition) {
        return coordinate.xCoordinate == xPosition && coordinate.yCoordinate == yPosition;
    }
}
