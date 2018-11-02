package com.codurance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LeftCommandShould {

    @ParameterizedTest
    @CsvSource({
            "N, W",
            "W, S",
            "S, E",
            "E, N",
    })
    void return_rotated_direction_to_the_left(String initialDirection, String finalDirection) {
        Direction direction = new Direction(initialDirection);
        LeftCommand command = new LeftCommand(direction);

        Direction actual = command.execute();

        Direction expected = new Direction(finalDirection);
        assertThat(actual).isEqualTo(expected);
    }
}
