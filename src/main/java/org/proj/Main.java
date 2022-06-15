package org.proj;

import com.isep.mdis.Sum;
import org.proj.importFile.ImportFile;
import org.proj.models.VaccinationData;
import org.proj.store.VaccinationDataStore;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<VaccinationData> vaccinationDataListByArrivalDate;
        List<VaccinationData> vaccinationDataListByLeavingDate;
        Scanner scanner = new Scanner(System.in);
        VaccinationDataStore store = new VaccinationDataStore();

        System.out.println("Insert file name:");
        String fileName = scanner.nextLine();

        // read list from file
        List<VaccinationData> vaccinationDataList = ImportFile.readExcel(fileName);

        // sort by arrival date
        vaccinationDataListByArrivalDate = new ArrayList<>(vaccinationDataList);
        vaccinationDataListByArrivalDate.sort(Comparator.comparing(VaccinationData::getArrivalDateTime));

        vaccinationDataListByLeavingDate = new ArrayList<>(vaccinationDataList);
        vaccinationDataListByLeavingDate.sort(Comparator.comparing(VaccinationData::getLeavingDateTime));

        for (VaccinationData v : vaccinationDataListByLeavingDate) {
            System.out.println(v);
        }

    }

    private void testSum() {
        int[] example = new int[]{29, -32, -9, -25, 44, 12, -61, 51, -9, 44, 74, 4};
        int[] result = Sum.Max(example);

        System.out.println(Arrays.toString(result));
    }
}