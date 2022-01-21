package net.mirwaldt.aoc.year2015.day17;

import java.util.List;
import java.util.function.BiFunction;

import static java.lang.Math.min;

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
        return ContainerCombinerUtils.extendCombination(combination, capacity);
    }

    @Override
    protected boolean accept(List<Integer> combination, int[] minContainerNumber) {
        return combination.size() < minContainerNumber[0];
    }
}
