package net.mirwaldt;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartOneContainerCombinerTest {
    private static Stream<Arguments> containerCombiner() {
        return Stream.of(Arguments.of(new DefaultContainerCombiner()),Arguments.of(new OptimizedContainerCombiner()));
    }

    @ParameterizedTest
    @MethodSource("containerCombiner")
    void test_countCombinations(ContainerCombiner containerCombiner) {
        assertEquals(4, containerCombiner.countCombinations(Arrays.asList(20, 15, 10, 5, 5), 25));
    }

    @ParameterizedTest
    @MethodSource("containerCombiner")
    void test_findCombinations(ContainerCombiner containerCombiner) {
        List<List<Integer>> expectedCombinations = Arrays.asList(
                Arrays.asList(5, 5, 15), Arrays.asList(5, 20), Arrays.asList(5, 20), Arrays.asList(10, 15));
        assertEquals(expectedCombinations, containerCombiner.findCombinations(Arrays.asList(20, 15, 10, 5, 5), 25));
    }
}
