package net.mirwaldt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class ResultCollectingContainerCombinerRecursion
        extends ContainerCombinerRecursion<List<List<Integer>>> {
    public ResultCollectingContainerCombinerRecursion(
            BiFunction<List<Integer>, Integer, List<Integer>> optimizeNewRemainingContainersFunction) {
        super(optimizeNewRemainingContainersFunction,
                (combination, finalResult) -> false,
                ResultCollectingContainerCombinerRecursion::addIntermediateResult,
                ResultCollectingContainerCombinerRecursion::extendCombination);
    }

    private static void addIntermediateResult(List<Integer> combination, List<List<Integer>> combinations) {
        combinations.add(combination);
    }

    public static List<Integer> extendCombination(List<Integer> combination, Integer capacity) {
        final List<Integer> newCombination = new ArrayList<>(combination);
        newCombination.add(capacity);
        return newCombination;
    }
}