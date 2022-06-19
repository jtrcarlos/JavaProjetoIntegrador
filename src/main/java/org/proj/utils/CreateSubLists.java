package org.proj.utils;

import org.proj.models.CreateSubListsResult;
import org.proj.models.VaccinationData;

import java.time.LocalDateTime;
import java.util.List;

public class CreateSubLists {
    public CreateSubListsResult getLists(List<VaccinationData> vaccinationDataArriving,
                                         List<VaccinationData> vaccinationDataLeaving,
                                         int interval) {
        // init values
        int listLength = Constants.MAX_LIST_LENGTH / interval;
        int[] differences = new int[listLength];
        LocalDateTime[] timeIntervals = new LocalDateTime[listLength];
        StringBuilder sb = new StringBuilder();
        int arrived = 0;
        int left = 0;

        // calculate init dates
        LocalDateTime date = vaccinationDataArriving.get(0).getArrivalDateTime();
        sb.append(date.getMonthValue()).append("/").append(date.getDayOfMonth()).append("/").append(date.getYear())
                .append(" 8:00");

        LocalDateTime dateFrom = LocalDateTime.parse(sb.toString(), Constants.FORMATTER);
        LocalDateTime dateTo = dateFrom.plusMinutes(interval);

        // count arrived and left and assign to list
        for (int i = 0; i < listLength; i++) {
            for (VaccinationData v : vaccinationDataArriving) {
                if (checkDateFromTo(v.getArrivalDateTime(), dateFrom, dateTo)) {
                    arrived++;
                }
            }

            for (VaccinationData v : vaccinationDataLeaving) {
                if (checkDateFromTo(v.getLeavingDateTime(), dateFrom, dateTo)) {
                    left++;
                }
            }

            // calculate difference and save it
            int difference = arrived - left;
            differences[i] = difference;
            timeIntervals[i] = dateFrom;

            // reset variables, new dates
            arrived = 0;
            left = 0;
            dateFrom = dateFrom.plusMinutes(interval);
            dateTo = dateTo.plusMinutes(interval);
        }


        // return differences;
        return new CreateSubListsResult(differences, timeIntervals);
    }

    private boolean checkDateFromTo(LocalDateTime date, LocalDateTime dateFrom, LocalDateTime dateTo) {
        return (date.isEqual(dateFrom) || date.isAfter(dateFrom)) && date.isBefore(dateTo);
    }
}
