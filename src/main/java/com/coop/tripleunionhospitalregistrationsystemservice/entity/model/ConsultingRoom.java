/**
 * @ClassName ConsultingRoom
 * @Author 24
 * @Date 2023/6/9 18:42
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.model;

public class ConsultingRoom {
    
    private String consultingRoomId;
    private String consultingRoomName;
    private String departmentId;
    
    public ConsultingRoom() {
    }
    
    public ConsultingRoom(String consultingRoomId, String consultingRoomName, String departmentId) {
        this.consultingRoomId = consultingRoomId;
        this.consultingRoomName = consultingRoomName;
        this.departmentId = departmentId;
    }
    
    public String getConsultingRoomId() {
        return consultingRoomId;
    }
    
    public void setConsultingRoomId(String consultingRoomId) {
        this.consultingRoomId = consultingRoomId;
    }
    
    public String getConsultingRoomName() {
        return consultingRoomName;
    }
    
    public void setConsultingRoomName(String consultingRoomName) {
        this.consultingRoomName = consultingRoomName;
    }
    
    public String getDepartmentId() {
        return departmentId;
    }
    
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    
    @Override
    public String toString() {
        return "ConsultingRoom{" +
                "consultingRoomId='" + consultingRoomId + '\'' +
                ", consultingRoomName='" + consultingRoomName + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   ConsultingRoom
//    Created by 24 on 2023/6/9.
