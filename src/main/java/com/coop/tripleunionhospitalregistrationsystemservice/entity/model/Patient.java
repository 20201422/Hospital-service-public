/**
 * @ClassName Patient
 * @Author 24
 * @Date 2023/6/9 18:35
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.model;

public class Patient {
    
    private int patientId;
    private String patientName;
    private String patientEmail;
    private String patientPhoneNumber;
    private String patientPassword;
    
    public Patient() {
    }
    
    public Patient(int patientId, String patientName, String patientEmail,
                   String patientPhoneNumber, String patientPassword) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientEmail = patientEmail;
        this.patientPhoneNumber = patientPhoneNumber;
        this.patientPassword = patientPassword;
    }
    
    public int getPatientId() {
        return patientId;
    }
    
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    
    public String getPatientName() {
        return patientName;
    }
    
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    
    public String getPatientEmail() {
        return patientEmail;
    }
    
    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }
    
    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }
    
    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }
    
    public String getPatientPassword() {
        return patientPassword;
    }
    
    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }
    
    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientEmail='" + patientEmail + '\'' +
                ", patientPhoneNumber='" + patientPhoneNumber + '\'' +
                ", patientPassword='" + patientPassword + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   Patient
//    Created by 24 on 2023/6/9.
