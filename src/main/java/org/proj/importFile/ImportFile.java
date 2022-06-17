package org.proj.importFile;

import org.proj.models.VaccinationData;
import org.proj.models.VaccinationDataIndex;
import org.proj.utils.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportFile {

    public static List<VaccinationData> readExcel(String filename) {
        List<VaccinationData> vaccinationDataList = new ArrayList<>();
        try {
            Scanner reader = new Scanner(new File(filename));

            // skip header line
            reader.nextLine();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                VaccinationData vaccinationData = createVaccinationData(line);

                vaccinationDataList.add(vaccinationData);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return vaccinationDataList;
    }

    private static VaccinationData createVaccinationData(String line) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
        String[] data = line.split(";");

        String snsNumber = data[VaccinationDataIndex.SNS_NUMBER.ordinal()];
        String vaccineName = data[VaccinationDataIndex.VACCINE_NAME.ordinal()];
        String dose = data[VaccinationDataIndex.DOSE.ordinal()];
        String lotNumber = data[VaccinationDataIndex.LOT_NUMBER.ordinal()];
        LocalDateTime scheduleDateTime = LocalDateTime.parse(data[VaccinationDataIndex.SCHEDULE_DATE_TIME.ordinal()], formatter);
        LocalDateTime arrivalDate = LocalDateTime.parse(data[VaccinationDataIndex.ARRIVAL_DATE_TIME.ordinal()], formatter);
        LocalDateTime nurseAdministrationDateTime = LocalDateTime.parse(data[VaccinationDataIndex.NURSE_ADMINISTRATION_DATE_TIME.ordinal()], formatter);
        LocalDateTime leavingDateTime = LocalDateTime.parse(data[VaccinationDataIndex.LEAVING_DATE_TIME.ordinal()], formatter);

        return new VaccinationData(snsNumber, vaccineName, dose, lotNumber, scheduleDateTime, arrivalDate, nurseAdministrationDateTime, leavingDateTime);
    }
}
