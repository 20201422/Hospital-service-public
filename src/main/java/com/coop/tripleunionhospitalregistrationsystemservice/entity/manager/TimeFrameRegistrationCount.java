package com.coop.tripleunionhospitalregistrationsystemservice.entity.manager;

public class TimeFrameRegistrationCount {
  private String departmentName;
  private int timeFrameId;
  private int count;

  public TimeFrameRegistrationCount() {
  }

  public TimeFrameRegistrationCount(String departmentName, int timeFrameId, int count) {
    this.departmentName = departmentName;
    this.timeFrameId = timeFrameId;
    this.count = count;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public int getTimeFrameId() {
    return timeFrameId;
  }

  public void setTimeFrameId(int timeFrameId) {
    this.timeFrameId = timeFrameId;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
