/**
 * @ClassName Blocklist
 * @Author 24
 * @Date 2023/6/9 18:56
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.tripleunionhospitalregistrationsystemservice.entity.model;

public class Blocklist {

    private int blocklistId;
    private String recordsId;
    private String createTime;
    private String removeTime;
    
    public Blocklist() {
    }
    
    public Blocklist(int blocklistId, String recordsId, String createTime, String removeTime) {
        this.blocklistId = blocklistId;
        this.recordsId = recordsId;
        this.createTime = createTime;
        this.removeTime = removeTime;
    }
    
    public int getBlocklistId() {
        return blocklistId;
    }
    
    public void setBlocklistId(int blocklistId) {
        this.blocklistId = blocklistId;
    }
    
    public String getRecordsId() {
        return recordsId;
    }
    
    public void setRecordsId(String recordsId) {
        this.recordsId = recordsId;
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
    
    @Override
    public String toString() {
        return "Blocklist{" +
                "blocklistId=" + blocklistId +
                ", recordsId='" + recordsId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", removeTime='" + removeTime + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   Blocklist
//    Created by 24 on 2023/6/9.
