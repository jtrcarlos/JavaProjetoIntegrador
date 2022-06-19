package org.proj.importFile;

import java.time.LocalDateTime;
import java.util.Arrays;

public class MainResult {
    private int[] arrayInput;
    private int[] arraySubList;
    private int maxSum;
    private LocalDateTime startLocalDateTime;
    private LocalDateTime endLocalDateTime;


    public MainResult(int[] arrayInput, int[] arraySubList, int maxSum, LocalDateTime startLocalDateTime, LocalDateTime endLocalDateTime) {
        this.arrayInput = arrayInput;
        this.arraySubList = arraySubList;
        this.maxSum = maxSum;
        this.startLocalDateTime = startLocalDateTime;
        this.endLocalDateTime = endLocalDateTime;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(arrayInput)).append("\n");
        sb.append(Arrays.toString(arraySubList)).append("\n");
        sb.append("Soma: ").append(maxSum).append("\n");
        sb.append(startLocalDateTime).append(" - ").append(endLocalDateTime);

        return sb.toString();
    }
}
