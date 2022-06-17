package org.proj;

import com.isep.mdis.Sum;
import org.proj.importFile.ImportFile;
import org.proj.models.VaccinationData;
import org.proj.utils.CreateSubLists;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<VaccinationData> vaccinationDataListByArrivalDate;
        List<VaccinationData> vaccinationDataListByLeavingDate;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert file name:");
        String fileName = scanner.nextLine();

        System.out.println("Insert interval in minutes (30,20,10,5,1):");
        int interval = scanner.nextInt();

        // read list from file
        List<VaccinationData> vaccinationDataList = ImportFile.readExcel(fileName);

        // sort by arrival date
        vaccinationDataListByArrivalDate = new ArrayList<>(vaccinationDataList);
        vaccinationDataListByArrivalDate.sort(Comparator.comparing(VaccinationData::getArrivalDateTime));

        // sort by leaving date
        vaccinationDataListByLeavingDate = new ArrayList<>(vaccinationDataList);
        vaccinationDataListByLeavingDate.sort(Comparator.comparing(VaccinationData::getLeavingDateTime));

        for (VaccinationData v : vaccinationDataListByLeavingDate) {
            System.out.println(v);
        }


        new CreateSubLists().getLists(vaccinationDataListByArrivalDate, vaccinationDataListByLeavingDate, interval);

    }

    private void testSum() {
        int[] example = new int[]{29, -32, -9, -25, 44, 12, -61, 51, -9, 44, 74, 4};
        int[] result = Sum.Max(example);

        System.out.println(Arrays.toString(result));
    }
}