package net.mirwaldt.aoc.year2015.day17;

import java.util.List;

public class OptimizedContainerCombiner extends AbstractContainerCombiner {
    @Override
    protected List<Integer> optimizeNewRemainingContainers(
            List<Integer> newRemainingContainers, int newRemainingAmount) {
        return ContainerCombinerUtils.optimize(newRemainingContainers, newRemainingAmount);
    }
}
