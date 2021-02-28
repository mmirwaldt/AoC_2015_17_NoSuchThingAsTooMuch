package net.mirwaldt;

import java.util.Collections;
import java.util.List;

public class OptimizedContainerCombiner extends AbstractContainerCombiner {
    @Override
    protected List<Integer> optimizeNewRemainingContainers(
            List<Integer> newRemainingContainers, int newRemainingAmount) {
        int maxIndex = Collections.binarySearch(newRemainingContainers, newRemainingAmount);
        if (maxIndex < 0) {
            maxIndex = -(maxIndex + 1);
        } else {
            // we must include the last duplicate if it exists as well!
            maxIndex = newRemainingContainers.lastIndexOf(newRemainingContainers.get(maxIndex)) + 1;
        }
        return newRemainingContainers.subList(0, maxIndex);
    }
}
