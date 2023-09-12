/**
 * @ClassName MedicalRecordsMapper
 * @Author 24
 * @Date 2023/6/9 18:50
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.model;

public class MedicalRecords {
    
    private String recordsId;
    private String recordsName;
    private String recordsPatientPhoneNumber;
    private String recordsPatientAddress;
    private String recordsPatientSex;
    private String recordsPatientType;
    private String recordsCredit;
    private int patientId;
    
    public MedicalRecords() {
    }
    
    public MedicalRecords(String recordsId, String recordsName, String recordsPatientPhoneNumber,
                          String recordsPatientAddress, String recordsPatientSex, String recordsPatientType,
                          String recordsCredit, int patientId) {
        this.recordsId = recordsId;
        this.recordsName = recordsName;
        this.recordsPatientPhoneNumber = recordsPatientPhoneNumber;
        this.recordsPatientAddress = recordsPatientAddress;
        this.recordsPatientSex = recordsPatientSex;
        this.recordsPatientType = recordsPatientType;
        this.recordsCredit = recordsCredit;
        this.patientId = patientId;
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
    
    public String getRecordsPatientPhoneNumber() {
        return recordsPatientPhoneNumber;
    }
    
    public void setRecordsPatientPhoneNumber(String recordsPatientPhoneNumber) {
        this.recordsPatientPhoneNumber = recordsPatientPhoneNumber;
    }
    
    public String getRecordsPatientAddress() {
        return recordsPatientAddress;
    }
    
    public void setRecordsPatientAddress(String recordsPatientAddress) {
        this.recordsPatientAddress = recordsPatientAddress;
    }
    
    public String getRecordsPatientSex() {
        return recordsPatientSex;
    }
    
    public void setRecordsPatientSex(String recordsPatientSex) {
        this.recordsPatientSex = recordsPatientSex;
    }
    
    public String getRecordsPatientType() {
        return recordsPatientType;
    }
    
    public void setRecordsPatientType(String recordsPatientType) {
        this.recordsPatientType = recordsPatientType;
    }
    
    public String getRecordsCredit() {
        return recordsCredit;
    }
    
    public void setRecordsCredit(String recordsCredit) {
        this.recordsCredit = recordsCredit;
    }
    
    public int getPatientId() {
        return patientId;
    }
    
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    
    @Override
    public String toString() {
        return "MedicalRecords{" +
                "recordsId='" + recordsId + '\'' +
                ", recordsName='" + recordsName + '\'' +
                ", recordsPatientPhoneNumber='" + recordsPatientPhoneNumber + '\'' +
                ", recordsPatientAddress='" + recordsPatientAddress + '\'' +
                ", recordsPatientSex='" + recordsPatientSex + '\'' +
                ", recordsPatientType='" + recordsPatientType + '\'' +
                ", recordsCredit='" + recordsCredit + '\'' +
                ", patientId=" + patientId +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   MedicalRecordsMapper
//    Created by 24 on 2023/6/9.
