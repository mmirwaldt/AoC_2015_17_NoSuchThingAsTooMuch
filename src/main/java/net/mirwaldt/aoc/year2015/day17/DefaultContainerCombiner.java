package net.mirwaldt.aoc.year2015.day17;

import java.util.List;

import static net.mirwaldt.aoc.year2015.day17.ContainerCombinerUtils.dontOptimize;

public class DefaultContainerCombiner extends AbstractContainerCombiner {
    @Override
    protected List<Integer> optimizeNewRemainingContainers(
            List<Integer> newRemainingSortedContainers, int newRemainingAmount) {
        return dontOptimize(newRemainingSortedContainers, newRemainingAmount);
    }
}
