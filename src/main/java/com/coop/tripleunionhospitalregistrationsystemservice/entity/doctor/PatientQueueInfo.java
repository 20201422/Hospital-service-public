package com.coop.tripleunionhospitalregistrationsystemservice.entity.doctor;

public class PatientQueueInfo {
    private String patientName;
    private String recordsName;
    private String numberSourceDate;
    private String amOrPm;
    private String consultationPeriod;
    private String recordsPatientSex;
    private String recordsPatientAddress;

    public PatientQueueInfo(String patientName, String recordsName, String numberSourceDate, String amOrPm, String consultationPeriod, String recordsPatientSex, String recordsPatientAddress) {
        this.patientName = patientName;
        this.recordsName = recordsName;
        this.numberSourceDate = numberSourceDate;
        this.amOrPm = amOrPm;
        this.consultationPeriod = consultationPeriod;
        this.recordsPatientSex = recordsPatientSex;
        this.recordsPatientAddress = recordsPatientAddress;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getRecordsName() {
        return recordsName;
    }

    public void setRecordsName(String recordsName) {
        this.recordsName = recordsName;
    }

    public String getNumberSourceDate() {
        return numberSourceDate;
    }

    public void setNumberSourceDate(String numberSourceDate) {
        this.numberSourceDate = numberSourceDate;
    }

    public String getAmOrPm() {
        return amOrPm;
    }

    public void setAmOrPm(String amOrPm) {
        this.amOrPm = amOrPm;
    }

    public String getConsultationPeriod() {
        return consultationPeriod;
    }

    public void setConsultationPeriod(String consultationPeriod) {
        this.consultationPeriod = consultationPeriod;
    }

    public String getRecordsPatientSex() {
        return recordsPatientSex;
    }

    public void setRecordsPatientSex(String recordsPatientSex) {
        this.recordsPatientSex = recordsPatientSex;
    }

    public String getRecordsPatientAddress() {
        return recordsPatientAddress;
    }

    public void setRecordsPatientAddress(String recordsPatientAddress) {
        this.recordsPatientAddress = recordsPatientAddress;
    }
}
