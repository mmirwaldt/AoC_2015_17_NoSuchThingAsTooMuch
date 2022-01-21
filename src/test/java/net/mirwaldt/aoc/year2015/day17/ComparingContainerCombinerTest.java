package net.mirwaldt.aoc.year2015.day17;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparingContainerCombinerTest {
    @Test
    void test_compareCombinations() throws IOException {
        final List<String> lines = Files.readAllLines(Path.of("input.txt"), StandardCharsets.US_ASCII);
        final List<Integer> capacities = lines.stream().map(Integer::parseInt).collect(Collectors.toList());
        final ContainerCombiner expectedContainerCombiner = new DefaultContainerCombiner();
        final ContainerCombiner actualContainerCombiner = new OptimizedContainerCombiner();

        final int expectedCombinationsCount = expectedContainerCombiner.countCombinations(capacities, 150);
        final int actualCombinationsCount = actualContainerCombiner.countCombinations(capacities, 150);
        assertEquals(expectedCombinationsCount, actualCombinationsCount);
    }
}
