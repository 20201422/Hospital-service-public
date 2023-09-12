package com.coop.tripleunionhospitalregistrationsystemservice.entity.manager;

public class DoctorRegistrationData {
  private String departmentName;
  private String doctorName;
  private String weekType;
  private int date;
  private int count;

  public DoctorRegistrationData() {
  }

  public DoctorRegistrationData(String departmentName, String doctorName, String weekType, int date, int count) {
    this.departmentName = departmentName;
    this.doctorName = doctorName;
    this.weekType = weekType;
    this.date = date;
    this.count = count;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getDoctorName() {
    return doctorName;
  }

  public void setDoctorName(String doctorName) {
    this.doctorName = doctorName;
  }

  public String getWeekType() {
    return weekType;
  }

  public void setWeekType(String weekType) {
    this.weekType = weekType;
  }

  public int getDate() {
    return date;
  }

  public void setDate(int date) {
    this.date = date;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
