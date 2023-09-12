/**
 * @ClassName Manager
 * @Author 24
 * @Date 2023/6/9 18:55
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.model;

public class Manager {

    private String managerId;
    private String managerName;
    private String managerEmail;
    private String managerPhoneNumber;
    private String managerPassword;
    private String managerType;

    public Manager() {
    }

    public Manager(String managerId, String managerName, String managerEmail, String managerPhoneNumber,
                   String managerPassword, String managerType) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerEmail = managerEmail;
        this.managerPhoneNumber = managerPhoneNumber;
        this.managerPassword = managerPassword;
        this.managerType = managerType;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public void setManagerPhoneNumber(String managerPhoneNumber) {
        this.managerPhoneNumber = managerPhoneNumber;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerType() {
        return managerType;
    }

    public void setManagerType(String managerType) {
        this.managerType = managerType;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mangerId='" + managerId + '\'' +
                ", mangerName='" + managerName + '\'' +
                ", manger_email='" + managerEmail + '\'' +
                ", mangerPhoneNumber='" + managerPhoneNumber + '\'' +
                ", mangerPassword='" + managerPassword + '\'' +
                ", mangerType='" + managerType + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   Manager
//    Created by 24 on 2023/6/9.
