package net.mirwaldt;

import java.util.*;

public class DefaultContainerCombiner implements ContainerCombiner {
    @Override
    public int combineContainers(List<Integer> capacities, int amount) {
        final List<Integer> sortedContainers = new ArrayList<>(capacities);
        Collections.sort(sortedContainers);
        final int[] counter = new int[] { 0 };
        combineRecursively(sortedContainers, amount, counter);
        return counter[0];
//        final List<List<Integer>> combinations = new ArrayList<>();
//        combineRecursively(sortedContainers, amount, Collections.emptyList(), combinations);
//        return combinations.size();
    }

//    private void combineRecursively(List<Integer> remainingSortedContainers, int remainingAmount,
//                                    List<Integer> containers, List<List<Integer>> combinations) {
//        if (remainingAmount == 0) {
//            Collections.sort(containers);
//            combinations.add(containers);
//        } else {
//            for (int i = 0; i < remainingSortedContainers.size(); i++) {
//                int containerCapacity = remainingSortedContainers.get(i);
//                if (containerCapacity <= remainingAmount) {
//                    final int newRemainingAmount = remainingAmount - containerCapacity;
//                    final List<Integer> newRemainingSortedContainers = new ArrayList<>(
//                            remainingSortedContainers.subList(i + 1, remainingSortedContainers.size()));
//                    int maxIndex = Collections.binarySearch(newRemainingSortedContainers, newRemainingAmount);
//                    if (maxIndex < 0) {
//                        maxIndex = -(maxIndex + 1);
//                    } else {
//                        maxIndex++; // include last element
//                    }
//
//                    final List<Integer> newContainers = new ArrayList<>(containers);
//                    newContainers.add(containerCapacity);
//                    final List<Integer> remainingSortedContainersSubList =
//                            newRemainingSortedContainers.subList(0, maxIndex);
//                    combineRecursively(remainingSortedContainersSubList, newRemainingAmount, newContainers, combinations);
//                }
//            }
//        }
//    }

    private void combineRecursively(List<Integer> remainingSortedContainers, int remainingAmount, int[] counter) {
        if (remainingAmount == 0) {
            counter[0]++;
        } else {
            for (int i = 0; i < remainingSortedContainers.size(); i++) {
                int containerCapacity = remainingSortedContainers.get(i);
                if (containerCapacity <= remainingAmount) {
                    final int newRemainingAmount = remainingAmount - containerCapacity;
                    final List<Integer> newRemainingSortedContainers = new ArrayList<>(
                            remainingSortedContainers.subList(i + 1, remainingSortedContainers.size()));
//                    int maxIndex = Collections.binarySearch(newRemainingSortedContainers, newRemainingAmount);
//                    if (maxIndex < 0) {
//                        maxIndex = -(maxIndex + 1);
//                    } else {
//                        maxIndex++; // include last element
//                    }

//                    final List<Integer> remainingSortedContainersSubList =
//                            newRemainingSortedContainers.subList(0, maxIndex);
                    combineRecursively(newRemainingSortedContainers, newRemainingAmount, counter);
                } else {
                    break;
                }
            }
        }
    }
}
