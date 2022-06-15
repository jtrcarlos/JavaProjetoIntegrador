package org.proj.models;

import java.time.LocalDateTime;


public class VaccinationData {
    private String snsNumber;
    private String vaccineName;
    private String dose;
    private String lotNumber;
    private LocalDateTime scheduledDateTime;
    private LocalDateTime arrivalDateTime;
    private LocalDateTime nurseAdministrationDateTime;
    private LocalDateTime leavingDateTime;

    public VaccinationData(String snsNumber, String vaccineName, String dose, String lotNumber,
                           LocalDateTime scheduledDateTime, LocalDateTime arrivalDateTime,
                           LocalDateTime nurseAdministrationDateTime, LocalDateTime leavingDateTime) {
        this.snsNumber = snsNumber;
        this.vaccineName = vaccineName;
        this.dose = dose;
        this.lotNumber = lotNumber;
        this.scheduledDateTime = scheduledDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.nurseAdministrationDateTime = nurseAdministrationDateTime;
        this.leavingDateTime = leavingDateTime;
    }


    public String getSnsNumber() {
        return snsNumber;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public String getDose() {
        return dose;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public LocalDateTime getScheduledDateTime() {
        return scheduledDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public LocalDateTime getNurseAdministrationDateTime() {
        return nurseAdministrationDateTime;
    }

    public LocalDateTime getLeavingDateTime() {
        return leavingDateTime;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(snsNumber).append(" - ");
//        sb.append(vaccineName).append(" - ");
//        sb.append(dose).append(" - ");
//        sb.append(lotNumber).append(" - ");
//        sb.append(scheduledDateTime).append(" - ");
        sb.append("Arrival: ");
        sb.append(arrivalDateTime).append(" - ");
//        sb.append(nurseAdministrationDateTime).append(" - ");
        sb.append("Leaving: ");
        sb.append(leavingDateTime);

        return sb.toString();
    }
}
