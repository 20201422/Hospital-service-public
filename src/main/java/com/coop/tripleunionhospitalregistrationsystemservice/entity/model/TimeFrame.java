/**
 * @ClassName TimeFrame
 * @Author 24
 * @Date 2023/6/16 17:33
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.model;

public class TimeFrame {
    private int timeFrameId;
    private String timeFrameBeginTime;
    private String timeFrameEndTime;
    
    public TimeFrame() {
    }
    
    public TimeFrame(int timeFrameId, String timeFrameBeginTime, String timeFrameEndTime) {
        this.timeFrameId = timeFrameId;
        this.timeFrameBeginTime = timeFrameBeginTime;
        this.timeFrameEndTime = timeFrameEndTime;
    }
    
    public int getTimeFrameId() {
        return timeFrameId;
    }
    
    public void setTimeFrameId(int timeFrameId) {
        this.timeFrameId = timeFrameId;
    }
    
    public String getTimeFrameBeginTime() {
        return timeFrameBeginTime;
    }
    
    public void setTimeFrameBeginTime(String timeFrameBeginTime) {
        this.timeFrameBeginTime = timeFrameBeginTime;
    }
    
    public String getTimeFrameEndTime() {
        return timeFrameEndTime;
    }
    
    public void setTimeFrameEndTime(String timeFrameEndTime) {
        this.timeFrameEndTime = timeFrameEndTime;
    }
    
    @Override
    public String toString() {
        return "TimeFrame{" +
                "timeFrameId=" + timeFrameId +
                ", timeFrameBeginTime='" + timeFrameBeginTime + '\'' +
                ", timeFrameEndTime='" + timeFrameEndTime + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   TimeFrame
//    Created by 24 on 2023/6/16.
