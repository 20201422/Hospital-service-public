package com.coop.tripleunionhospitalregistrationsystemservice.entity.manager;

public class NumberSourceDetailObject {
  private int numberSourceId;
  private String departmentName;
  private String consultingRoomType;
  private String doctorId;
  private String doctorName;
  private String doctorLevel;
  private String numberSourceDate;
  private String amOrPm;
  private String consultationPeriod;
  private Double numberSourceFee;
  private String State;
  private int number;


  public NumberSourceDetailObject() {
  }

  public int getNumberSourceId() {
    return numberSourceId;
  }

  public void setNumberSourceId(int numberSourceId) {
    this.numberSourceId = numberSourceId;
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

  public String getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(String doctorId) {
    this.doctorId = doctorId;
  }

  public String getDoctorName() {
    return doctorName;
  }

  public void setDoctorName(String doctorName) {
    this.doctorName = doctorName;
  }

  public String getDoctorLevel() {
    return doctorLevel;
  }

  public void setDoctorLevel(String doctorLevel) {
    this.doctorLevel = doctorLevel;
  }

  public String getNumberSourceDate() {
    return numberSourceDate;
  }

  public void setNumberSourceDate(String numberSourceDate) {
    this.numberSourceDate = numberSourceDate;
  }

  public String getAmOrPm() {
    return amOrPm;
  }

  public void setAmOrPm(String amOrPm) {
    this.amOrPm = amOrPm;
  }

  public String getConsultationPeriod() {
    return consultationPeriod;
  }

  public void setConsultationPeriod(String consultationPeriod) {
    this.consultationPeriod = consultationPeriod;
  }

  public Double getNumberSourceFee() {
    return numberSourceFee;
  }

  public void setNumberSourceFee(Double numberSourceFee) {
    this.numberSourceFee = numberSourceFee;
  }

  public String getState() {
    return State;
  }

  public void setState(String state) {
    State = state;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }
}
