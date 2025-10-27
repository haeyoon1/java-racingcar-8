package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String PARSER = ",";

    public static List<String> splitCarNames(String cars) {
        return Arrays.stream(cars.split(PARSER))
            .map(String::trim)
            .filter(name -> !name.isBlank())
            .toList();
    }
}
