package net.mirwaldt;

import java.util.List;
import java.util.function.BiFunction;

import static net.mirwaldt.ContainerCombinerUtils.extendCombination;

public class ResultCollectingContainerCombinerRecursion
        extends ContainerCombinerRecursion<List<List<Integer>>> {
    public ResultCollectingContainerCombinerRecursion(
            BiFunction<List<Integer>, Integer, List<Integer>> optimizeNewRemainingContainersFunction) {
        super(optimizeNewRemainingContainersFunction);
    }

    @Override
    protected void consumeIntermediateResult(List<Integer> combination, List<List<Integer>> combinations) {
        addIntermediateResult(combination, combinations);
    }

    @Override
    protected List<Integer> createCombination(List<Integer> combination, Integer capacity) {
        return extendCombination(combination, capacity);
    }

    @Override
    protected boolean accept(List<Integer> combination, List<List<Integer>> combinations) {
        return true;
    }

    private void addIntermediateResult(List<Integer> combination, List<List<Integer>> combinations) {
        combinations.add(combination);
    }
}
