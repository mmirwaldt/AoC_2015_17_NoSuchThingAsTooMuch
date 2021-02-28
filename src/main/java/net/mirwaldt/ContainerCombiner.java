package net.mirwaldt;

import java.util.List;

public interface ContainerCombiner {
    int countCombinations(List<Integer> capacities, int amount);
    List<List<Integer>> findCombinations(List<Integer> capacities, int amount);
}
