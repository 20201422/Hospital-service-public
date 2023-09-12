/**
 * @ClassName ChangeShift
 * @Author 24
 * @Date 2023/6/16 17:24
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.model;

public class ChangeShift {
    
    private int changeShiftId;
    private int arrangementId;
    private String changeShiftReason;
    private String changeShiftState;
    private String changeShiftTime;
    private String applicationTime;
    
    public ChangeShift() {
    }
    
    public ChangeShift(int changeShiftId, int arrangementId, String changeShiftReason, String changeShiftState,
                       String changeShiftTime, String applicationTime) {
        this.changeShiftId = changeShiftId;
        this.arrangementId = arrangementId;
        this.changeShiftReason = changeShiftReason;
        this.changeShiftState = changeShiftState;
        this.changeShiftTime = changeShiftTime;
        this.applicationTime = applicationTime;
    }
    
    public int getChangeShiftId() {
        return changeShiftId;
    }
    
    public void setChangeShiftId(int changeShiftId) {
        this.changeShiftId = changeShiftId;
    }
    
    public int getArrangementId() {
        return arrangementId;
    }
    
    public void setArrangementId(int arrangementId) {
        this.arrangementId = arrangementId;
    }
    
    public String getChangeShiftReason() {
        return changeShiftReason;
    }
    
    public void setChangeShiftReason(String changeShiftReason) {
        this.changeShiftReason = changeShiftReason;
    }
    
    public String getChangeShiftState() {
        return changeShiftState;
    }
    
    public void setChangeShiftState(String changeShiftState) {
        this.changeShiftState = changeShiftState;
    }
    
    public String getChangeShiftTime() {
        return changeShiftTime;
    }
    
    public void setChangeShiftTime(String changeShiftTime) {
        this.changeShiftTime = changeShiftTime;
    }
    
    public String getApplicationTime() {
        return applicationTime;
    }
    
    public void setApplicationTime(String applicationTime) {
        this.applicationTime = applicationTime;
    }
    
    @Override
    public String toString() {
        return "ChangeShift{" +
                "changeShiftId=" + changeShiftId +
                ", arrangementId=" + arrangementId +
                ", changeShiftReason='" + changeShiftReason + '\'' +
                ", changeShiftState='" + changeShiftState + '\'' +
                ", changeShiftTime='" + changeShiftTime + '\'' +
                ", applicationTime='" + applicationTime + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   ChangeShift
//    Created by 24 on 2023/6/16.
