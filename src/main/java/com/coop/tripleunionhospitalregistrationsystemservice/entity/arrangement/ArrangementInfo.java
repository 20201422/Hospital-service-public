package com.coop.tripleunionhospitalregistrationsystemservice.entity.arrangement;

public class ArrangementInfo {
    private int arrangementInfoId;
    private String doctorName;
    private String doctorId;
    private String consultingRoomName;
    private String consultingRoomId;
    private String numberSourceDate;
    private String amOrPm;
    private int number;

    public ArrangementInfo() {
    }

    public ArrangementInfo(int arrangementInfoId, String doctorName, String doctorId, String consultingRoomName, String consultingRoomId, String numberSourceDate, String amOrPm, int number) {
        this.arrangementInfoId = arrangementInfoId;
        this.doctorName = doctorName;
        this.doctorId = doctorId;
        this.consultingRoomName = consultingRoomName;
        this.consultingRoomId = consultingRoomId;
        this.numberSourceDate = numberSourceDate;
        this.amOrPm = amOrPm;
        this.number = number;
    }

    public int getArrangementInfoId() {
        return arrangementInfoId;
    }

    public void setArrangementInfoId(int arrangementInfoId) {
        this.arrangementInfoId = arrangementInfoId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getConsultingRoomName() {
        return consultingRoomName;
    }

    public void setConsultingRoomName(String consultingRoomName) {
        this.consultingRoomName = consultingRoomName;
    }

    public String getConsultingRoomId() {
        return consultingRoomId;
    }

    public void setConsultingRoomId(String consultingRoomId) {
        this.consultingRoomId = consultingRoomId;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
