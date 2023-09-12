/**
 * @ClassName PatientShowRegistration
 * @Author 24
 * @Date 2023/6/16 17:04
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.patient;

public class PatientShowRegistration {

    private String registrationId;
    private String recordsId;
    private String recordsName;
    private String recordsPatientSex;
    private String doctorId;
    private String doctorName;
    private String departmentId;
    private String departmentName;
    private String consultingRoomType;
    private String numberSourceDate;
    private String aMOrPm;
    private String consultationPeriod;
    private String numberSourceFee;
    private String registrationState;
    private String registrationTime;

    public PatientShowRegistration() {
    }

    public PatientShowRegistration(String registrationId, String recordsId, String recordsName, String recordsPatientSex,
                                   String doctorId, String doctorName, String departmentId, String departmentName,
                                   String consultingRoomType, String numberSourceDate, String aMOrPm,
                                   String consultationPeriod, String numberSourceFee, String registrationState,
                                   String registrationTime) {
        this.registrationId = registrationId;
        this.recordsId = recordsId;
        this.recordsName = recordsName;
        this.recordsPatientSex = recordsPatientSex;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.consultingRoomType = consultingRoomType;
        this.numberSourceDate = numberSourceDate;
        this.aMOrPm = aMOrPm;
        this.consultationPeriod = consultationPeriod;
        this.numberSourceFee = numberSourceFee;
        this.registrationState = registrationState;
        this.registrationTime = registrationTime;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getRecordsId() {
        return recordsId;
    }

    public void setRecordsId(String recordsId) {
        this.recordsId = recordsId;
    }

    public String getRecordsName() {
        return recordsName;
    }

    public void setRecordsName(String recordsName) {
        this.recordsName = recordsName;
    }

    public String getRecordsPatientSex() {
        return recordsPatientSex;
    }

    public void setRecordsPatientSex(String recordsPatientSex) {
        this.recordsPatientSex = recordsPatientSex;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getConsultingRoomType() {
        return consultingRoomType;
    }

    public void setConsultingRoomType(String consultingRoomType) {
        this.consultingRoomType = consultingRoomType;
    }

    public String getNumberSourceDate() {
        return numberSourceDate;
    }

    public void setNumberSourceDate(String numberSourceDate) {
        this.numberSourceDate = numberSourceDate;
    }

    public String getaMOrPm() {
        return aMOrPm;
    }

    public void setaMOrPm(String aMOrPm) {
        this.aMOrPm = aMOrPm;
    }

    public String getConsultationPeriod() {
        return consultationPeriod;
    }

    public void setConsultationPeriod(String consultationPeriod) {
        this.consultationPeriod = consultationPeriod;
    }

    public String getNumberSourceFee() {
        return numberSourceFee;
    }

    public void setNumberSourceFee(String numberSourceFee) {
        this.numberSourceFee = numberSourceFee;
    }

    public String getRegistrationState() {
        return registrationState;
    }

    public void setRegistrationState(String registrationState) {
        this.registrationState = registrationState;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    @Override
    public String toString() {
        return "PatientShowRegistration{" +
                "recordsId='" + recordsId + '\'' +
                ", recordsName='" + recordsName + '\'' +
                ", patientSex='" + recordsPatientSex + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", numberSourceDate='" + numberSourceDate + '\'' +
                ", aMOrPm='" + aMOrPm + '\'' +
                ", consultationPeriod='" + consultationPeriod + '\'' +
                ", registrationState='" + registrationState + '\'' +
                ", registrationTime='" + registrationTime + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   PatientShowRegistration
//    Created by 24 on 2023/6/16.
