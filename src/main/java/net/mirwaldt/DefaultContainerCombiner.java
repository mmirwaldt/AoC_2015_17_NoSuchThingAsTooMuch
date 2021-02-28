package net.mirwaldt;

import java.util.List;

import static net.mirwaldt.ContainerCombinerUtils.dontOptimize;

public class DefaultContainerCombiner extends AbstractContainerCombiner {
    @Override
    protected List<Integer> optimizeNewRemainingContainers(
            List<Integer> newRemainingSortedContainers, int newRemainingAmount) {
        return dontOptimize(newRemainingSortedContainers, newRemainingAmount);
    }
}
