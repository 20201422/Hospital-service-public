/**
 * @ClassName NumberSourceInformation
 * @Author 24
 * @Date 2023/6/16 15:44
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.patient;

public class NumberSourceInformation {

    private String doctorId;
    private String doctorName;
    private String doctorSex;
    private String doctorPhoto;
    private String departmentId;
    private String consultingRoomType;
    private String numberSourceDate;
    private int amCounts;
    private int pmCounts;
    private double numberSourceFee;
    
    public NumberSourceInformation() {
    }
    
    public NumberSourceInformation(String doctorId, String doctorName, String doctorSex, String doctorPhoto,
                                   String departmentId, String consultingRoomType, String numberSourceDate,
                                   int amCounts, int pmCounts, double numberSourceFee) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorSex = doctorSex;
        this.doctorPhoto = doctorPhoto;
        this.departmentId = departmentId;
        this.consultingRoomType = consultingRoomType;
        this.numberSourceDate = numberSourceDate;
        this.amCounts = amCounts;
        this.pmCounts = pmCounts;
        this.numberSourceFee = numberSourceFee;
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
    
    public String getDoctorSex() {
        return doctorSex;
    }
    
    public void setDoctorSex(String doctorSex) {
        this.doctorSex = doctorSex;
    }
    
    public String getDoctorPhoto() {
        return doctorPhoto;
    }
    
    public void setDoctorPhoto(String doctorPhoto) {
        this.doctorPhoto = doctorPhoto;
    }
    
    public String getDepartmentId() {
        return departmentId;
    }
    
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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
    
    public int getAmCounts() {
        return amCounts;
    }
    
    public void setAmCounts(int amCounts) {
        this.amCounts = amCounts;
    }
    
    public int getPmCounts() {
        return pmCounts;
    }
    
    public void setPmCounts(int pmCounts) {
        this.pmCounts = pmCounts;
    }
    
    public double getNumberSourceFee() {
        return numberSourceFee;
    }
    
    public void setNumberSourceFee(double numberSourceFee) {
        this.numberSourceFee = numberSourceFee;
    }
    
    @Override
    public String toString() {
        return "NumberSourceInformation{" +
                "doctor_id='" + doctorId + '\'' +
                ", doctor_name='" + doctorName + '\'' +
                ", doctor_sex='" + doctorSex + '\'' +
                ", doctor_photo='" + doctorPhoto + '\'' +
                ", department_id='" + departmentId + '\'' +
                ", consulting_room_type='" + consultingRoomType + '\'' +
                ", number_source_date='" + numberSourceDate + '\'' +
                ", am_counts=" + amCounts +
                ", pm_counts=" + pmCounts +
                ", number_source_fee=" + numberSourceFee +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   NumberSourceInformation
//    Created by 24 on 2023/6/16.
