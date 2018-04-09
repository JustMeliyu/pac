package com.yto.pac.pojo;

import java.util.Date;

public class TransportProtocol {
    private Integer id;

    private String transNumber;

    private Date startTime;

    private Date endTime;

    private String settlementMode;

    private Float driverFreight;

    private String plate;

    private Date createDate;

    private Date createTime;

    private Integer fkDriverId;

    private String fkToLocationCode;

    private String fkAtLocationCode;

    private Integer fkOperatorId;

    private Integer status;

    private Date statusTime;

    private Date updateTime;

    private Integer relayStatus;

    private Integer isOnway;

    private Integer isTempTruck;

    private Integer isOvertime;

    private String lineNo;

    private String carrierName;

    private Integer isLink;

    private String link;

    private String vehicleType;

    private Integer runMode;

    private String voucher;

    private Integer fkTruckId;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransNumber() {
        return transNumber;
    }

    public void setTransNumber(String transNumber) {
        this.transNumber = transNumber == null ? null : transNumber.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime ;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime ;
    }

    public String getSettlementMode() {
        return settlementMode;
    }

    public void setSettlementMode(String settlementMode) {
        this.settlementMode = settlementMode == null ? null : settlementMode.trim();
    }

    public Float getDriverFreight() {
        return driverFreight;
    }

    public void setDriverFreight(Float driverFreight) {
        this.driverFreight = driverFreight;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate == null ? null : plate.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getFkDriverId() {
        return fkDriverId;
    }

    public void setFkDriverId(Integer fkDriverId) {
        this.fkDriverId = fkDriverId;
    }

    public String getFkToLocationCode() {
        return fkToLocationCode;
    }

    public void setFkToLocationCode(String fkToLocationCode) {
        this.fkToLocationCode = fkToLocationCode == null ? null : fkToLocationCode.trim();
    }

    public String getFkAtLocationCode() {
        return fkAtLocationCode;
    }

    public void setFkAtLocationCode(String fkAtLocationCode) {
        this.fkAtLocationCode = fkAtLocationCode == null ? null : fkAtLocationCode.trim();
    }

    public Integer getFkOperatorId() {
        return fkOperatorId;
    }

    public void setFkOperatorId(Integer fkOperatorId) {
        this.fkOperatorId = fkOperatorId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(Date statusTime) {
        this.statusTime = statusTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getRelayStatus() {
        return relayStatus;
    }

    public void setRelayStatus(Integer relayStatus) {
        this.relayStatus = relayStatus;
    }

    public Integer getIsOnway() {
        return isOnway;
    }

    public void setIsOnway(Integer isOnway) {
        this.isOnway = isOnway;
    }

    public Integer getIsTempTruck() {
        return isTempTruck;
    }

    public void setIsTempTruck(Integer isTempTruck) {
        this.isTempTruck = isTempTruck;
    }

    public Integer getIsOvertime() {
        return isOvertime;
    }

    public void setIsOvertime(Integer isOvertime) {
        this.isOvertime = isOvertime;
    }

    public String getLineNo() {
        return lineNo;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo == null ? null : lineNo.trim();
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName == null ? null : carrierName.trim();
    }

    public Integer getIsLink() {
        return isLink;
    }

    public void setIsLink(Integer isLink) {
        this.isLink = isLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType == null ? null : vehicleType.trim();
    }

    public Integer getRunMode() {
        return runMode;
    }

    public void setRunMode(Integer runMode) {
        this.runMode = runMode;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher == null ? null : voucher.trim();
    }

    public Integer getFkTruckId() {
        return fkTruckId;
    }

    public void setFkTruckId(Integer fkTruckId) {
        this.fkTruckId = fkTruckId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}