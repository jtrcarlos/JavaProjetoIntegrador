package org.proj.algorithms;

public class BruteForceResult {
    private int[] arraySubList;
    private int maxSum;
    private int start;
    private int end;

    public BruteForceResult(int[] arraySubList, int maxSum, int start, int end) {
        this.arraySubList = arraySubList;
        this.maxSum = maxSum;
        this.start = start;
        this.end = end;
    }

    public int[] getArraySubList() {
        return arraySubList;
    }

    public int getMaxSum() {
        return maxSum;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
