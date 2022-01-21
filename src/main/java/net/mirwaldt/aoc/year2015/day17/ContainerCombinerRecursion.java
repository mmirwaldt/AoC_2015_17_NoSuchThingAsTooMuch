package net.mirwaldt.aoc.year2015.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public abstract class ContainerCombinerRecursion<FinalResultType> {
    private final BiFunction<List<Integer>, Integer, List<Integer>> optimizeNewRemainingContainersFunction;

    public ContainerCombinerRecursion(
            BiFunction<List<Integer>, Integer, List<Integer>> optimizeNewRemainingContainersFunction) {
        this.optimizeNewRemainingContainersFunction = optimizeNewRemainingContainersFunction;
    }

    protected void combineRecursively(List<Integer> remainingContainers, int remainingAmount,
                                      List<Integer> combination, FinalResultType finalResult) {
        if (remainingAmount == 0) {
            consumeIntermediateResult(combination, finalResult);
        } else if(accept(combination, finalResult)) {
            for (int i = 0; i < remainingContainers.size(); i++) {
                int containerCapacity = remainingContainers.get(i);
                if (containerCapacity <= remainingAmount) {
                    final int newRemainingAmount = remainingAmount - containerCapacity;
                    List<Integer> newRemainingContainers = new ArrayList<>(
                            remainingContainers.subList(i + 1, remainingContainers.size()));
                    newRemainingContainers =
                            optimizeNewRemainingContainersFunction.apply(newRemainingContainers, newRemainingAmount);

                    final List<Integer> newCombination = createNewCombination(combination, containerCapacity);
                    combineRecursively(newRemainingContainers, newRemainingAmount, newCombination, finalResult);
                }
            }
        }
    }

    protected abstract void consumeIntermediateResult(List<Integer> combination, FinalResultType combinations);
    protected abstract List<Integer> createNewCombination(List<Integer> combination, Integer capacity);
    protected abstract boolean accept(List<Integer> combination, FinalResultType combinations);
}
