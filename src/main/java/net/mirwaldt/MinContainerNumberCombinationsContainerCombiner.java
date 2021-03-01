package net.mirwaldt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinContainerNumberCombinationsContainerCombiner implements ContainerCombiner {
    private int lastMinContainerNumber;

    @Override
    public int countCombinations(List<Integer> capacities, int amount) {
        final List<Integer> sortedContainers = new ArrayList<>(capacities);
        Collections.sort(sortedContainers);

        final int[] minContainerNumber = findMinContainerNumber(amount, sortedContainers);

        final int[] counter = new int[]{0};
        final MinContainerNumberResultCountingContainerCombinerRecursion containerCombinerRecursion =
                new MinContainerNumberResultCountingContainerCombinerRecursion(
                        minContainerNumber[0], ContainerCombinerUtils::dontOptimize);
        containerCombinerRecursion.combineRecursively(sortedContainers, amount, Collections.emptyList(), counter);
        return counter[0];
    }

    @Override
    public List<List<Integer>> findCombinations(List<Integer> capacities, int amount) {
        final List<Integer> sortedContainers = new ArrayList<>(capacities);
        Collections.sort(sortedContainers);

        final int[] minContainerNumber = findMinContainerNumber(amount, sortedContainers);

        final MinContainerNumberResultCollectingContainerCombinerRecursion containerCombinerRecursion =
                new MinContainerNumberResultCollectingContainerCombinerRecursion(
                        minContainerNumber[0], ContainerCombinerUtils::dontOptimize);
        final List<List<Integer>> combinations = new ArrayList<>();
        containerCombinerRecursion.combineRecursively(sortedContainers, amount, Collections.emptyList(), combinations);
        return combinations;
    }

    private int[] findMinContainerNumber(int amount, List<Integer> sortedContainers) {
        final int[] minContainerNumber = new int[]{Integer.MAX_VALUE};
        MinContainerNumberCombinerRecursion minContainerNumberCombinerRecursion =
                new MinContainerNumberCombinerRecursion(ContainerCombinerUtils::dontOptimize);
        minContainerNumberCombinerRecursion.combineRecursively(sortedContainers, amount, Collections.emptyList(), minContainerNumber);
        lastMinContainerNumber = minContainerNumber[0];
        return minContainerNumber;
    }

    public int getLastMinContainerNumber() {
        return lastMinContainerNumber;
    }
}
