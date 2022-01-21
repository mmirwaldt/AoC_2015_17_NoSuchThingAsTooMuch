package net.mirwaldt.aoc.year2015.day17;

import java.util.List;
import java.util.function.BiFunction;

public class MinContainerNumberResultCollectingContainerCombinerRecursion
        extends ContainerCombinerRecursion<List<List<Integer>>> {
    private final int minContainerNumber;

    public MinContainerNumberResultCollectingContainerCombinerRecursion(
            int minContainerNumber,
            BiFunction<List<Integer>, Integer, List<Integer>> optimizeNewRemainingContainersFunction) {
        super(optimizeNewRemainingContainersFunction);
        this.minContainerNumber = minContainerNumber;
    }

    @Override
    protected void consumeIntermediateResult(List<Integer> combination, List<List<Integer>> combinations) {
        if(minContainerNumber == combination.size()) {
            addIntermediateResult(combination, combinations);
        }
    }

    @Override
    protected List<Integer> createNewCombination(List<Integer> combination, Integer capacity) {
        return ContainerCombinerUtils.extendCombination(combination, capacity);
    }

    @Override
    protected boolean accept(List<Integer> combination, List<List<Integer>> combinations) {
        return combination.size() < minContainerNumber;
    }

    private void addIntermediateResult(List<Integer> combination, List<List<Integer>> combinations) {
        combinations.add(combination);
    }
}
