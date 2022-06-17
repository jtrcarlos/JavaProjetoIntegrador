package org.proj.algorithms;

import java.util.Arrays;

public class BruteForce {
    public static BruteForceResult findMaxSubsequence(int[] sequence) {
        long benchmarkStart = System.nanoTime();

        int max = 0, start = 0, end = 0;
        for (int i = 0; i < sequence.length; i++) {
            int sum = 0;

            for (int j = i; j < sequence.length; j++) {
                sum += sequence[j];
                if (sum > max) {
                    max = sum;
                    start = i;
                    end = j;
                }
            }
        }

        System.out.println("Run time: " + (System.nanoTime() - benchmarkStart) + "ms\n");

        return new BruteForceResult(Arrays.copyOfRange(sequence, start, end + 1), max, start, end + 1);
    }
}
