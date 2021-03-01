package net.mirwaldt;

import java.util.List;
import java.util.function.BiFunction;

import static java.lang.Math.min;
import static net.mirwaldt.ContainerCombinerUtils.extendCombination;

public class MinContainerNumberCombinerRecursion extends ContainerCombinerRecursion<int[]>{
    public MinContainerNumberCombinerRecursion(
            BiFunction<List<Integer>, Integer, List<Integer>> optimizeNewRemainingContainersFunction) {
        super(optimizeNewRemainingContainersFunction);
    }

    @Override
    protected void consumeIntermediateResult(List<Integer> combination, int[] minContainerNumber) {
        minContainerNumber[0] = min(minContainerNumber[0], combination.size());
    }

    @Override
    protected List<Integer> createNewCombination(List<Integer> combination, Integer capacity) {
        return extendCombination(combination, capacity);
    }

    @Override
    protected boolean accept(List<Integer> combination, int[] minContainerNumber) {
        return combination.size() < minContainerNumber[0];
    }
}
