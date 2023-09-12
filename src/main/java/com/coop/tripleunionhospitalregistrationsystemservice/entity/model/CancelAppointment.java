/**
 * @ClassName CancelAppointment
 * @Author 24
 * @Date 2023/6/16 17:21
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.model;

public class CancelAppointment {
    
    private int cancelId;
    private int registrationId;
    private String appointmentTime;
    private String cancelTime;
    
    public CancelAppointment() {
    }
    
    public CancelAppointment(int cancelId, int registrationId, String appointmentTime, String cancelTime) {
        this.cancelId = cancelId;
        this.registrationId = registrationId;
        this.appointmentTime = appointmentTime;
        this.cancelTime = cancelTime;
    }
    
    public int getCancelId() {
        return cancelId;
    }
    
    public void setCancelId(int cancelId) {
        this.cancelId = cancelId;
    }
    
    public int getRegistrationId() {
        return registrationId;
    }
    
    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }
    
    public String getAppointmentTime() {
        return appointmentTime;
    }
    
    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    
    public String getCancelTime() {
        return cancelTime;
    }
    
    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime;
    }
    
    @Override
    public String toString() {
        return "CancelAppointment{" +
                "cancelId=" + cancelId +
                ", registrationId=" + registrationId +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", cancelTime='" + cancelTime + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   CancelAppointment
//    Created by 24 on 2023/6/16.
