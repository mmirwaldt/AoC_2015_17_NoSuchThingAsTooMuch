package net.mirwaldt;

import java.util.List;
import java.util.function.BiFunction;

public class ResultCountingContainerCombinerRecursion
        extends ContainerCombinerRecursion<int[]> {
    public ResultCountingContainerCombinerRecursion(
            BiFunction<List<Integer>, Integer, List<Integer>> optimizeNewRemainingContainersFunction) {
        super(optimizeNewRemainingContainersFunction,
                (combination, finalResult) -> false,
                ResultCountingContainerCombinerRecursion::addIntermediateResult,
                ResultCountingContainerCombinerRecursion::extendCombination);
    }

    private static void addIntermediateResult(List<Integer> combination, int[] combinationsCount) {
        combinationsCount[0]++;
    }

    private static List<Integer> extendCombination(List<Integer> combination, Integer capacity) {
        return null;
    }
}
