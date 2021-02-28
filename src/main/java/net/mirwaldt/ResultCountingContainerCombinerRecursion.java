package net.mirwaldt;

import java.util.List;
import java.util.function.BiFunction;

public class ResultCountingContainerCombinerRecursion
        extends ContainerCombinerRecursion<Object, int[]> {
    public ResultCountingContainerCombinerRecursion(
            BiFunction<List<Integer>, Integer, List<Integer>> optimizeNewRemainingContainersFunction) {
        super(optimizeNewRemainingContainersFunction,
                ResultCountingContainerCombinerRecursion::addIntermediateResult,
                ResultCountingContainerCombinerRecursion::extendCombination);
    }

    private static void addIntermediateResult(Object combination, int[] combinationsCount) {
        combinationsCount[0]++;
    }

    private static Object extendCombination(Object combination, Integer capacity) {
        return null;
    }
}
