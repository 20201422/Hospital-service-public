package com.coop.tripleunionhospitalregistrationsystemservice.entity.arrangement;

public class ArrangementProtoType implements Cloneable{
    private String doctorId;
    private String consultingRoomId;
    private String numberSourceId;   //号源id
    private String numberSourceDate; //号源日期
    private String amOrPm;   //号源午别
    private int number; //号源数量
    private String ConsultingRoomType;  //门诊类型
    private String departmentId;

    public ArrangementProtoType(String doctorId, String consultingRoomId, String numberSourceId, String numberSourceDate,
                                String amOrPm, int number, String consultingRoomType, String departmentId) {
        this.doctorId = doctorId;
        this.consultingRoomId = consultingRoomId;
        this.numberSourceId = numberSourceId;
        this.numberSourceDate = numberSourceDate;
        this.amOrPm = amOrPm;
        this.number = number;
        ConsultingRoomType = consultingRoomType;
        this.departmentId = departmentId;
    }

    @Override
    public ArrangementProtoType clone(){
        ArrangementProtoType arrangementProtoType = null;
        try {
            arrangementProtoType = (ArrangementProtoType)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return arrangementProtoType;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getConsultingRoomId() {
        return consultingRoomId;
    }

    public void setConsultingRoomId(String consultingRoomId) {
        this.consultingRoomId = consultingRoomId;
    }

    public String getNumberSourceId() {
        return numberSourceId;
    }

    public void setNumberSourceId(String numberSourceId) {
        this.numberSourceId = numberSourceId;
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

    public String getConsultingRoomType() {
        return ConsultingRoomType;
    }

    public void setConsultingRoomType(String consultingRoomType) {
        ConsultingRoomType = consultingRoomType;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
