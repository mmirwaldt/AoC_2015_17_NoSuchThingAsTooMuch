package net.mirwaldt;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
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

//        final List<List<Integer>> expectedCombinations =
//                expectedContainerCombiner.findCombinations(capacities, 150);
//        final List<List<Integer>> actualCombinations =
//                actualContainerCombiner.findCombinations(capacities, 150);
//        System.out.println(expectedCombinations.size());
//        System.out.println(actualCombinations.size());

//        final List<List<Integer>> diff1Combinations = new ArrayList<>(expectedCombinations);
//        diff1Combinations.removeAll(actualCombinations);
//        System.out.println(diff1Combinations);

//        final List<List<Integer>> diff2Combinations = new ArrayList<>(actualCombinations);
//        diff2Combinations.removeAll(expectedCombinations);
//        System.out.println(diff2Combinations);

        final int expectedCombinationsCount = expectedContainerCombiner.countCombinations(capacities, 150);
        final int actualCombinationsCount = actualContainerCombiner.countCombinations(capacities, 150);
        assertEquals(expectedCombinationsCount, actualCombinationsCount);
//        System.out.println(actualCombinationsCount);
    }
}
