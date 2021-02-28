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
        combineRecursively(sortedContainers, amount, counter);
        return counter[0];
    }

    @Override
    public List<List<Integer>> findCombinations(List<Integer> capacities, int amount) {
        final List<Integer> sortedContainers = new ArrayList<>(capacities);
        Collections.sort(sortedContainers);
        final List<List<Integer>> combinations = new ArrayList<>();
        combineRecursively(sortedContainers, amount, Collections.emptyList(), combinations);
        return combinations;
    }

    protected void combineRecursively(List<Integer> remainingContainers, int remainingAmount,
                                    List<Integer> containers, List<List<Integer>> combinations) {
        if (remainingAmount == 0) {
            combinations.add(containers);
        } else {
            for (int i = 0; i < remainingContainers.size(); i++) {
                int containerCapacity = remainingContainers.get(i);
                if (containerCapacity <= remainingAmount) {
                    final int newRemainingAmount = remainingAmount - containerCapacity;
                    List<Integer> newRemainingContainers = new ArrayList<>(
                            remainingContainers.subList(i + 1, remainingContainers.size()));
                    newRemainingContainers =
                            optimizeNewRemainingContainers(newRemainingContainers, newRemainingAmount);
                    final List<Integer> newContainers = new ArrayList<>(containers);
                    newContainers.add(containerCapacity);
                    combineRecursively(newRemainingContainers, newRemainingAmount, newContainers, combinations);
                }
            }
        }
    }

    protected void combineRecursively(List<Integer> remainingContainers, int remainingAmount, int[] counter) {
        if (remainingAmount == 0) {
            counter[0]++;
        } else {
            for (int i = 0; i < remainingContainers.size(); i++) {
                int containerCapacity = remainingContainers.get(i);
                if (containerCapacity <= remainingAmount) {
                    final int newRemainingAmount = remainingAmount - containerCapacity;
                    List<Integer> newRemainingContainers = new ArrayList<>(
                            remainingContainers.subList(i + 1, remainingContainers.size()));
                    newRemainingContainers =
                            optimizeNewRemainingContainers(newRemainingContainers, newRemainingAmount);
                    combineRecursively(newRemainingContainers, newRemainingAmount, counter);
                }
            }
        }
    }

    protected abstract List<Integer> optimizeNewRemainingContainers(
            List<Integer> newRemainingSortedContainers, int newRemainingAmount);
}
