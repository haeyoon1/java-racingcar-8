package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final String PARSER = ",";

    public static List<String> splitCarNames(String cars) {
        return Arrays.asList(cars.split(PARSER));
    }
}
