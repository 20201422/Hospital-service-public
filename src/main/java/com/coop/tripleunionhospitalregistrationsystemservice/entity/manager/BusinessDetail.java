package com.coop.tripleunionhospitalregistrationsystemservice.entity.manager;

public class BusinessDetail {
  private String departmentName;
  private String timeFrameBeginTime;
  private String timeFrameEndTime;
  private String consultingRoom;
  private int numberSourceNumber;

  public BusinessDetail(String departmentName, String timeFrameBeginTime, String timeFrameEndTime, String consultingRoom, int numberSourceNumber) {
    this.departmentName = departmentName;
    this.timeFrameBeginTime = timeFrameBeginTime;
    this.timeFrameEndTime = timeFrameEndTime;
    this.consultingRoom = consultingRoom;
    this.numberSourceNumber = numberSourceNumber;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
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

  public String getConsultingRoom() {
    return consultingRoom;
  }

  public void setConsultingRoom(String consultingRoom) {
    this.consultingRoom = consultingRoom;
  }

  public int getNumberSourceNumber() {
    return numberSourceNumber;
  }

  public void setNumberSourceNumber(int numberSourceNumber) {
    this.numberSourceNumber = numberSourceNumber;
  }
}
