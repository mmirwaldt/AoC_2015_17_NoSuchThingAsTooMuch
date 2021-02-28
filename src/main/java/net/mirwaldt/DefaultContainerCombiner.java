package net.mirwaldt;

import java.util.*;

public class DefaultContainerCombiner extends AbstractContainerCombiner {
    @Override
    protected List<Integer> optimizeNewRemainingContainers(
            List<Integer> newRemainingSortedContainers, int newRemainingAmount) {
        return newRemainingSortedContainers;
    }
}
