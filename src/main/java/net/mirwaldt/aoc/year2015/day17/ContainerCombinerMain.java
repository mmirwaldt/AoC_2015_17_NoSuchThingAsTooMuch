package net.mirwaldt.aoc.year2015.day17;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ContainerCombinerMain {
    public static void main(String[] args) throws IOException {
        final List<String> lines = Files.readAllLines(Path.of("input.txt"), StandardCharsets.US_ASCII);
        final List<Integer> capacities = lines.stream().map(Integer::parseInt).collect(Collectors.toList());

        final ContainerCombiner partOneContainerCombiner = new OptimizedContainerCombiner();
        System.out.println(partOneContainerCombiner.countCombinations(capacities, 150)); // result: 1304

        final ContainerCombiner partTwoContainerCombiner = new MinContainerNumberCombinationsContainerCombiner();
        System.out.println(partTwoContainerCombiner.countCombinations(capacities, 150)); // result: 18
    }
}
