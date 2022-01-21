package net.mirwaldt.aoc.year2015.day17;

import java.util.List;
import java.util.function.BiFunction;

public class MinContainerNumberResultCountingContainerCombinerRecursion
        extends ContainerCombinerRecursion<int[]> {
    private final int minContainerNumber;

    public MinContainerNumberResultCountingContainerCombinerRecursion(
            int minContainerNumber,
            BiFunction<List<Integer>, Integer, List<Integer>> optimizeNewRemainingContainersFunction) {
        super(optimizeNewRemainingContainersFunction);
        this.minContainerNumber = minContainerNumber;
    }

    @Override
    protected void consumeIntermediateResult(List<Integer> combination, int[] count) {
        if(minContainerNumber == combination.size()) {
            count[0]++;
        }
    }

    @Override
    protected List<Integer> createNewCombination(List<Integer> combination, Integer capacity) {
        return ContainerCombinerUtils.extendCombination(combination, capacity);
    }

    @Override
    protected boolean accept(List<Integer> combination, int[] combinations) {
        return combination.size() < minContainerNumber;
    }
}
