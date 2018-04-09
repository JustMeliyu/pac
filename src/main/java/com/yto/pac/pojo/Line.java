package com.yto.pac.pojo;

import java.util.Date;

public class Line {
    private Integer id;

    private String lineNo;

    private String lineName;

    private String startOrgCode;

    private String startOrgName;

    private String transferCenterSet;

    private String endOrgCode;

    private String endOrgName;

    private String lineFrequencyNo;

    private String lineFrequencyName;

    private String startTime;

    private String endTime;

    private Integer status;

    private Integer daySpan;

    private String fullTakeTime;

    private String fullDistance;

    private String lineProperty;

    private String transType;

    private Integer lineStatus;

    private String freStatus;

    private Date createTime;

    private Date updateTime;

    private Integer lineType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLineNo() {
        return lineNo;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo == null ? null : lineNo.trim();
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName == null ? null : lineName.trim();
    }

    public String getStartOrgCode() {
        return startOrgCode;
    }

    public void setStartOrgCode(String startOrgCode) {
        this.startOrgCode = startOrgCode == null ? null : startOrgCode.trim();
    }

    public String getStartOrgName() {
        return startOrgName;
    }

    public void setStartOrgName(String startOrgName) {
        this.startOrgName = startOrgName == null ? null : startOrgName.trim();
    }

    public String getTransferCenterSet() {
        return transferCenterSet;
    }

    public void setTransferCenterSet(String transferCenterSet) {
        this.transferCenterSet = transferCenterSet == null ? null : transferCenterSet.trim();
    }

    public String getEndOrgCode() {
        return endOrgCode;
    }

    public void setEndOrgCode(String endOrgCode) {
        this.endOrgCode = endOrgCode == null ? null : endOrgCode.trim();
    }

    public String getEndOrgName() {
        return endOrgName;
    }

    public void setEndOrgName(String endOrgName) {
        this.endOrgName = endOrgName == null ? null : endOrgName.trim();
    }

    public String getLineFrequencyNo() {
        return lineFrequencyNo;
    }

    public void setLineFrequencyNo(String lineFrequencyNo) {
        this.lineFrequencyNo = lineFrequencyNo == null ? null : lineFrequencyNo.trim();
    }

    public String getLineFrequencyName() {
        return lineFrequencyName;
    }

    public void setLineFrequencyName(String lineFrequencyName) {
        this.lineFrequencyName = lineFrequencyName == null ? null : lineFrequencyName.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDaySpan() {
        return daySpan;
    }

    public void setDaySpan(Integer daySpan) {
        this.daySpan = daySpan;
    }

    public String getFullTakeTime() {
        return fullTakeTime;
    }

    public void setFullTakeTime(String fullTakeTime) {
        this.fullTakeTime = fullTakeTime == null ? null : fullTakeTime.trim();
    }

    public String getFullDistance() {
        return fullDistance;
    }

    public void setFullDistance(String fullDistance) {
        this.fullDistance = fullDistance == null ? null : fullDistance.trim();
    }

    public String getLineProperty() {
        return lineProperty;
    }

    public void setLineProperty(String lineProperty) {
        this.lineProperty = lineProperty == null ? null : lineProperty.trim();
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    public Integer getLineStatus() {
        return lineStatus;
    }

    public void setLineStatus(Integer lineStatus) {
        this.lineStatus = lineStatus;
    }

    public String getFreStatus() {
        return freStatus;
    }

    public void setFreStatus(String freStatus) {
        this.freStatus = freStatus == null ? null : freStatus.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getLineType() {
        return lineType;
    }

    public void setLineType(Integer lineType) {
        this.lineType = lineType;
    }
}