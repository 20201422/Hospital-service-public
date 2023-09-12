/**
 * @ClassName Business
 * @Author 24
 * @Date 2023/6/16 17:20
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.model;

public class Business {
    private int businessId;
    private int timeFrameId;
    private String departmentId;
    private String consultingRoomType;
    private int numberSourceNumber;
    
    public Business() {
    }
    
    public Business(int businessId, int timeFrameId, String departmentId, String consultingRoomType,
                    int numberSourceNumber) {
        this.businessId = businessId;
        this.timeFrameId = timeFrameId;
        this.departmentId = departmentId;
        this.consultingRoomType = consultingRoomType;
        this.numberSourceNumber = numberSourceNumber;
    }
    
    public int getBusinessId() {
        return businessId;
    }
    
    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }
    
    public int getTimeFrameId() {
        return timeFrameId;
    }
    
    public void setTimeFrameId(int timeFrameId) {
        this.timeFrameId = timeFrameId;
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
    
    public int getNumberSourceNumber() {
        return numberSourceNumber;
    }
    
    public void setNumberSourceNumber(int numberSourceNumber) {
        this.numberSourceNumber = numberSourceNumber;
    }
    
    @Override
    public String toString() {
        return "Business{" +
                "businessId=" + businessId +
                ", timeFrameId=" + timeFrameId +
                ", departmentId='" + departmentId + '\'' +
                ", consultingRoomType='" + consultingRoomType + '\'' +
                ", numberSourceNumber=" + numberSourceNumber +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   Business
//    Created by 24 on 2023/6/16.
