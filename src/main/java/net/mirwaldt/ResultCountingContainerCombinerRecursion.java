package net.mirwaldt;

import java.util.List;
import java.util.function.BiFunction;

public class ResultCountingContainerCombinerRecursion
        extends ContainerCombinerRecursion<int[]> {
    public ResultCountingContainerCombinerRecursion(
            BiFunction<List<Integer>, Integer, List<Integer>> optimizeNewRemainingContainersFunction) {
        super(optimizeNewRemainingContainersFunction);
    }

    @Override
    protected void consumeIntermediateResult(List<Integer> combination, int[] count) {
        addIntermediateResult(combination, count);
    }

    @Override
    protected List<Integer> createCombination(List<Integer> combination, Integer capacity) {
        return null;
    }

    @Override
    protected boolean accept(List<Integer> combination, int[] combinations) {
        return true;
    }

    private void addIntermediateResult(List<Integer> combination, int[] combinationsCount) {
        combinationsCount[0]++;
    }
}
