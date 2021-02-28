package net.mirwaldt;

import java.util.Collections;
import java.util.List;

public class ContainerCombinerUtils {
    public static List<Integer> optimize(
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

    public static List<Integer> dontOptimize(List<Integer> newRemainingContainers, int newRemainingAmount) {
        return newRemainingContainers;
    }
}
