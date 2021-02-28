package net.mirwaldt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class ContainerCombinerRecursion<IntermediateResultType, FinalResultType> {
    private final BiFunction<List<Integer>, Integer, List<Integer>> optimizeNewRemainingContainersFunction;
    private final BiConsumer<IntermediateResultType, FinalResultType> intermediateResultConsumer;
    private final BiFunction<IntermediateResultType, Integer, IntermediateResultType> intermediateResultOperator;

    public ContainerCombinerRecursion(
            BiFunction<List<Integer>, Integer, List<Integer>> optimizeNewRemainingContainersFunction,
            BiConsumer<IntermediateResultType, FinalResultType> intermediateResultConsumer,
            BiFunction<IntermediateResultType, Integer, IntermediateResultType> intermediateResultOperator) {
        this.optimizeNewRemainingContainersFunction = optimizeNewRemainingContainersFunction;
        this.intermediateResultConsumer = intermediateResultConsumer;
        this.intermediateResultOperator = intermediateResultOperator;
    }

    protected void combineRecursively(List<Integer> remainingContainers, int remainingAmount,
                                      IntermediateResultType intermediateResult, FinalResultType finalResult) {
        if (remainingAmount == 0) {
            intermediateResultConsumer.accept(intermediateResult, finalResult);
        } else {
            for (int i = 0; i < remainingContainers.size(); i++) {
                int containerCapacity = remainingContainers.get(i);
                if (containerCapacity <= remainingAmount) {
                    final int newRemainingAmount = remainingAmount - containerCapacity;
                    List<Integer> newRemainingContainers = new ArrayList<>(
                            remainingContainers.subList(i + 1, remainingContainers.size()));
                    newRemainingContainers =
                            optimizeNewRemainingContainersFunction.apply(newRemainingContainers, newRemainingAmount);

                    IntermediateResultType newIntermediateResult =
                            intermediateResultOperator.apply(intermediateResult, containerCapacity);
                    combineRecursively(newRemainingContainers, newRemainingAmount, newIntermediateResult, finalResult);
                }
            }
        }
    }
}
