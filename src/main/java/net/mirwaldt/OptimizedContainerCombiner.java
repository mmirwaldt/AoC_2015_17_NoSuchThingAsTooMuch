package net.mirwaldt;

import java.util.List;

import static net.mirwaldt.ContainerCombinerUtils.optimize;

public class OptimizedContainerCombiner extends AbstractContainerCombiner {
    @Override
    protected List<Integer> optimizeNewRemainingContainers(
            List<Integer> newRemainingContainers, int newRemainingAmount) {
        return optimize(newRemainingContainers, newRemainingAmount);
    }
}
