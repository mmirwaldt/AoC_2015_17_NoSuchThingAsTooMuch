package net.mirwaldt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ContainerCombinerRecursion<FinalResultType> {
    private final BiFunction<List<Integer>, Integer, List<Integer>> optimizeNewRemainingContainersFunction;
    private final BiPredicate<List<Integer>, FinalResultType> stopPredicate;
    private final BiConsumer<List<Integer>, FinalResultType> intermediateResultConsumer;
    private final BiFunction<List<Integer>, Integer, List<Integer>> intermediateResultOperator;

    public ContainerCombinerRecursion(
            BiFunction<List<Integer>, Integer, List<Integer>> optimizeNewRemainingContainersFunction,
            BiPredicate<List<Integer>, FinalResultType> stopPredicate,
            BiConsumer<List<Integer>, FinalResultType> intermediateResultConsumer,
            BiFunction<List<Integer>, Integer, List<Integer>> intermediateResultOperator) {
        this.optimizeNewRemainingContainersFunction = optimizeNewRemainingContainersFunction;
        this.stopPredicate = stopPredicate;
        this.intermediateResultConsumer = intermediateResultConsumer;
        this.intermediateResultOperator = intermediateResultOperator;
    }

    protected void combineRecursively(List<Integer> remainingContainers, int remainingAmount,
                                      List<Integer> combination, FinalResultType finalResult) {
        if (remainingAmount == 0) {
            intermediateResultConsumer.accept(combination, finalResult);
        } else if(!stopPredicate.test(remainingContainers, finalResult)) {
            for (int i = 0; i < remainingContainers.size(); i++) {
                int containerCapacity = remainingContainers.get(i);
                if (containerCapacity <= remainingAmount) {
                    final int newRemainingAmount = remainingAmount - containerCapacity;
                    List<Integer> newRemainingContainers = new ArrayList<>(
                            remainingContainers.subList(i + 1, remainingContainers.size()));
                    newRemainingContainers =
                            optimizeNewRemainingContainersFunction.apply(newRemainingContainers, newRemainingAmount);

                    List<Integer> newCombination =
                            intermediateResultOperator.apply(combination, containerCapacity);
                    combineRecursively(newRemainingContainers, newRemainingAmount, newCombination, finalResult);
                }
            }
        }
    }
}
