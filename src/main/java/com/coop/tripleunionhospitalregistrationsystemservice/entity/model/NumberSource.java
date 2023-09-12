/**
 * @ClassName NumberSource
 * @Author 24
 * @Date 2023/6/9 18:49
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.model;

public class NumberSource {
    
    private int numberSourceId;
    private int businessId;
    private String numberSourceDate;
    private String AMOrPM;
    private double numberSourceFee;
    private String numberState;
    
    public NumberSource() {
    }
    
    public NumberSource(int numberSourceId, int businessId, String numberSourceDate, String AMOrPM,
                        double numberSourceFee, String numberState) {
        this.numberSourceId = numberSourceId;
        this.businessId = businessId;
        this.numberSourceDate = numberSourceDate;
        this.AMOrPM = AMOrPM;
        this.numberSourceFee = numberSourceFee;
        this.numberState = numberState;
    }
    
    public int getNumberSourceId() {
        return numberSourceId;
    }
    
    public void setNumberSourceId(int numberSourceId) {
        this.numberSourceId = numberSourceId;
    }
    
    public int getBusinessId() {
        return businessId;
    }
    
    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }
    
    public String getNumberSourceDate() {
        return numberSourceDate;
    }
    
    public void setNumberSourceDate(String numberSourceDate) {
        this.numberSourceDate = numberSourceDate;
    }
    
    public String getAMOrPM() {
        return AMOrPM;
    }
    
    public void setAMOrPM(String AMOrPM) {
        this.AMOrPM = AMOrPM;
    }
    
    public double getNumberSourceFee() {
        return numberSourceFee;
    }
    
    public void setNumberSourceFee(double numberSourceFee) {
        this.numberSourceFee = numberSourceFee;
    }
    
    public String getNumberState() {
        return numberState;
    }
    
    public void setNumberState(String numberState) {
        this.numberState = numberState;
    }
    
    @Override
    public String toString() {
        return "NumberSource{" +
                "numberSourceId=" + numberSourceId +
                ", businessId=" + businessId +
                ", numberSourceDate='" + numberSourceDate + '\'' +
                ", AMOrPM='" + AMOrPM + '\'' +
                ", numberSourceFee=" + numberSourceFee +
                ", numberState='" + numberState + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   NumberSource
//    Created by 24 on 2023/6/9.
