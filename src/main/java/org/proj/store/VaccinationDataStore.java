package org.proj.store;

import org.proj.models.VaccinationData;

import java.util.ArrayList;
import java.util.List;

public class VaccinationDataStore {

    private List<VaccinationData> vaccinationDataList;

    public VaccinationDataStore() {
        this.vaccinationDataList = new ArrayList<>();
    }

    public List<VaccinationData> getVaccinationDataList() {
        return new ArrayList<>(vaccinationDataList);
    }

    public void addToList(List<VaccinationData> vaccinationData) {
        vaccinationDataList = new ArrayList<>(vaccinationData);
    }

//    public List<List<VaccinationData>> getVaccinationListsByInterval(int interval) {
//
//    }
}
