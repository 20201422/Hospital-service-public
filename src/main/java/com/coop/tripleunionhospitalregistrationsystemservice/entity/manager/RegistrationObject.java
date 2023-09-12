package com.coop.tripleunionhospitalregistrationsystemservice.entity.manager;

public class RegistrationObject {
  private String recordsId;
  private int num;

  public RegistrationObject() {
  }

  public RegistrationObject(String recordsId, int num) {
    this.recordsId = recordsId;
    this.num = num;
  }

  public String getRecordsId() {
    return recordsId;
  }

  public void setRecordsId(String recordsId) {
    this.recordsId = recordsId;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }
}
