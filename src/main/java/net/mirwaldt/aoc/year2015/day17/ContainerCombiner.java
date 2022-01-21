package net.mirwaldt.aoc.year2015.day17;

import java.util.List;

public interface ContainerCombiner {
    int countCombinations(List<Integer> capacities, int amount);
    List<List<Integer>> findCombinations(List<Integer> capacities, int amount);
}
