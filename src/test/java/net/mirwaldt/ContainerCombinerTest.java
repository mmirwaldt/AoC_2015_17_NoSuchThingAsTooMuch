package net.mirwaldt;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerCombinerTest {
    private static Stream<Arguments> containerCombiner() {
        return Stream.of(Arguments.of(new DefaultContainerCombiner()));
    }

    @ParameterizedTest
    @MethodSource("containerCombiner")
    void test_combine(ContainerCombiner containerCombiner) {
        assertEquals(4, containerCombiner.combineContainers(Arrays.asList(20, 15, 10, 5 ,5), 25));
    }
}
