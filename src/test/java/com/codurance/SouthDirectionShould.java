package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SouthDirectionShould {

    @Test
    void change_to_west_when_asked_to_move_right() {
        SouthDirection south = new SouthDirection();
        assertThat(south.moveRight()).isEqualTo(new WestDirection());
    }

    @Test
    void change_to_east_when_asked_to_move_left() {
        SouthDirection south = new SouthDirection();
        assertThat(south.moveLeft()).isEqualTo(new EastDirection());
    }

    @Test
    void decrement_y_coordinate_when_asked_to_move_forward() {
        Coordinate coordinate = new Coordinate(2, 2);
        SouthDirection south = new SouthDirection();

        Coordinate expected = new Coordinate(2, 1);
        assertThat(south.moveForward(coordinate)).isEqualTo(expected);
    }
}
