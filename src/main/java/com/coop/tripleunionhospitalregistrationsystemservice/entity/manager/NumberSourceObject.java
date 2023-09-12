package com.coop.tripleunionhospitalregistrationsystemservice.entity.manager;

public class NumberSourceObject {

  private int departmentId;
  private String departmentName;
  private String consultingRoomType;
  private String numberSourceDate;
  private Double numberSourceFee;
  private String numberSourceNumber;

  public NumberSourceObject(){}

  public NumberSourceObject(int departmentId,String departmentName, String consultingRoomType, String numberSourceDate, Double numberSourceFee, String numberSourceNumber) {
    this.departmentId = departmentId;
    this.departmentName = departmentName;
    this.consultingRoomType = consultingRoomType;
    this.numberSourceDate = numberSourceDate;
    this.numberSourceFee = numberSourceFee;
    this.numberSourceNumber = numberSourceNumber;
  }

  public int getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getConsultingRoomType() {
    return consultingRoomType;
  }

  public void setConsultingRoomType(String consultingRoomType) {
    this.consultingRoomType = consultingRoomType;
  }

  public String getNumberSourceDate() {
    return numberSourceDate;
  }

  public void setNumberSourceDate(String numberSourceDate) {
    this.numberSourceDate = numberSourceDate;
  }

  public Double getNumberSourceFee() {
    return numberSourceFee;
  }

  public void setNumberSourceFee(Double numberSourceFee) {
    this.numberSourceFee = numberSourceFee;
  }

  public String getNumberSourceNumber() {
    return numberSourceNumber;
  }

  public void setNumberSourceNumber(String numberSourceNumber) {
    this.numberSourceNumber = numberSourceNumber;
  }
}
