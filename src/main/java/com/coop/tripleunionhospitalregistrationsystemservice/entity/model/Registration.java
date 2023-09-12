/**
 * @ClassName RegistrationMapper
 * @Author 24
 * @Date 2023/6/9 18:52
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.model;

public class Registration {
    private int registrationId;
    private String recordsId;
    private int numberSourceDetailId;
    private String registrationState;
    private String registrationTime;

    public Registration() {
    }

    public Registration(int registrationId, String recordsId, int numberSourceDetailId,
                        String registrationState, String registrationTime) {
        this.registrationId = registrationId;
        this.recordsId = recordsId;
        this.numberSourceDetailId = numberSourceDetailId;
        this.registrationState = registrationState;
        this.registrationTime = registrationTime;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public String getRecordsId() {
        return recordsId;
    }

    public void setRecordsId(String recordsId) {
        this.recordsId = recordsId;
    }

    public int getNumberSourceDetailId() {
        return numberSourceDetailId;
    }

    public void setNumberSourceDetailId(int numberSourceDetailId) {
        this.numberSourceDetailId = numberSourceDetailId;
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
        return "RegistrationMapper{" +
                "registrationId=" + registrationId +
                ", recordsId='" + recordsId + '\'' +
                ", numberSourceDetailId=" + numberSourceDetailId +
                ", registrationState='" + registrationState + '\'' +
                ", registrationTime='" + registrationTime + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   RegistrationMapper
//    Created by 24 on 2023/6/9.
