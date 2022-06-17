package org.proj.models;

import java.time.LocalDateTime;

public class CreateSubListsResult {
    private int[] differences;
    private LocalDateTime[] timeIntervals;

    public CreateSubListsResult(int[] differences, LocalDateTime[] timeIntervals) {
        this.differences = differences;
        this.timeIntervals = timeIntervals;
    }

    public int[] getDifferences() {
        return differences;
    }

    public LocalDateTime[] getTimeIntervals() {
        return timeIntervals;
    }
}
