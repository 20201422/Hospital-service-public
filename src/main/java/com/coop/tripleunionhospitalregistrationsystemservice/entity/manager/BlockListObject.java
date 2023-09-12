package com.coop.tripleunionhospitalregistrationsystemservice.entity.manager;

public class BlockListObject {
  private String recordsName;
  private String recordsPatientPhoneNumber;
  private String recordsPatientSex;
  private String createTime;
  private String removeTime;

  public BlockListObject() {
  }

  public BlockListObject(String recordsName, String recordsPatientPhoneNumber, String recordsPatientSex, String createTime, String removeTime) {
    this.recordsName = recordsName;
    this.recordsPatientPhoneNumber = recordsPatientPhoneNumber;
    this.recordsPatientSex = recordsPatientSex;
    this.createTime = createTime;
    this.removeTime = removeTime;
  }

  public String getRecordsName() {
    return recordsName;
  }

  public void setRecordsName(String recordsName) {
    this.recordsName = recordsName;
  }

  public String getRecordsPatientPhoneNumber() {
    return recordsPatientPhoneNumber;
  }

  public void setRecordsPatientPhoneNumber(String recordsPatientPhoneNumber) {
    this.recordsPatientPhoneNumber = recordsPatientPhoneNumber;
  }

  public String getRecordsPatientSex() {
    return recordsPatientSex;
  }

  public void setRecordsPatientSex(String recordsPatientSex) {
    this.recordsPatientSex = recordsPatientSex;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getRemoveTime() {
    return removeTime;
  }

  public void setRemoveTime(String removeTime) {
    this.removeTime = removeTime;
  }
}
