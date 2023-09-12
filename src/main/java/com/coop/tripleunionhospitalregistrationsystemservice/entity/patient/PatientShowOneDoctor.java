/**
 * @ClassName PatientShowOneDoctor
 * @Author 24
 * @Date 2023/6/16 17:03
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.patient;

public class PatientShowOneDoctor {
    
    private String doctorName;
    private String doctorSex;
    private String doctorPhoto;
    private String doctorIntroduction;
    private String doctorMajor;
    private String doctorLevel;
    
    public PatientShowOneDoctor() {
    }
    
    public PatientShowOneDoctor(String doctorName, String doctorSex, String doctorPhoto,
                                String doctorIntroduction, String doctorMajor, String doctorLevel) {
        this.doctorName = doctorName;
        this.doctorSex = doctorSex;
        this.doctorPhoto = doctorPhoto;
        this.doctorIntroduction = doctorIntroduction;
        this.doctorMajor = doctorMajor;
        this.doctorLevel = doctorLevel;
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
    
    public String getDoctorIntroduction() {
        return doctorIntroduction;
    }
    
    public void setDoctorIntroduction(String doctorIntroduction) {
        this.doctorIntroduction = doctorIntroduction;
    }
    
    public String getDoctorMajor() {
        return doctorMajor;
    }
    
    public void setDoctorMajor(String doctorMajor) {
        this.doctorMajor = doctorMajor;
    }
    
    public String getDoctorLevel() {
        return doctorLevel;
    }
    
    public void setDoctorLevel(String doctorLevel) {
        this.doctorLevel = doctorLevel;
    }
    
    @Override
    public String toString() {
        return "PatientShowOneDoctor{" +
                "doctorName='" + doctorName + '\'' +
                ", doctorSex='" + doctorSex + '\'' +
                ", doctorPhoto='" + doctorPhoto + '\'' +
                ", doctorIntroduction='" + doctorIntroduction + '\'' +
                ", doctorMajor='" + doctorMajor + '\'' +
                ", doctorLevel='" + doctorLevel + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   PatientShowOneDoctor
//    Created by 24 on 2023/6/16.
