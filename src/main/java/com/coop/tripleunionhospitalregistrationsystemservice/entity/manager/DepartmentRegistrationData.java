package com.coop.tripleunionhospitalregistrationsystemservice.entity.manager;

public class DepartmentRegistrationData {
  private String departmentName;
  private String weekType;
  private int date;
  private int count;

  public DepartmentRegistrationData() {
  }

  public DepartmentRegistrationData(String departmentName, String weekType, int date, int count) {
    this.departmentName = departmentName;
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
