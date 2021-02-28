package net.mirwaldt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractContainerCombiner implements ContainerCombiner {
    @Override
    public int countCombinations(List<Integer> capacities, int amount) {
        final List<Integer> sortedContainers = new ArrayList<>(capacities);
        Collections.sort(sortedContainers);
        final int[] counter = new int[] { 0 };
        final ResultCountingContainerCombinerRecursion containerCombinerRecursion =
                new ResultCountingContainerCombinerRecursion(this::optimizeNewRemainingContainers);
        containerCombinerRecursion.combineRecursively(sortedContainers, amount, null, counter);
        return counter[0];
    }

    @Override
    public List<List<Integer>> findCombinations(List<Integer> capacities, int amount) {
        final List<Integer> sortedContainers = new ArrayList<>(capacities);
        Collections.sort(sortedContainers);
        final  ResultCollectingContainerCombinerRecursion containerCombinerRecursion =
                new ResultCollectingContainerCombinerRecursion(this::optimizeNewRemainingContainers);
        final List<List<Integer>> combinations = new ArrayList<>();
        containerCombinerRecursion.combineRecursively(sortedContainers, amount, Collections.emptyList(), combinations);
        return combinations;
    }

    protected abstract List<Integer> optimizeNewRemainingContainers(
            List<Integer> newRemainingSortedContainers, int newRemainingAmount);
}
