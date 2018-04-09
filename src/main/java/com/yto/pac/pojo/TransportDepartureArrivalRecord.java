package com.yto.pac.pojo;

import java.util.Date;

public class TransportDepartureArrivalRecord {
    private Integer id;

    private String transNumber;

    private String plate;

    private Date createAt;

    private Date statusTime;

    private Integer type;

    private Integer lon;

    private Integer lat;

    private Integer fkDriverId;

    private String fkLocationCode;

    private Integer fkOperatorId;

    private Integer sourceType;

    private Integer jgTriggerTime;

    private String address;

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

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate == null ? null : plate.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(Date statusTime) {
        this.statusTime = statusTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLon() {
        return lon;
    }

    public void setLon(Integer lon) {
        this.lon = lon;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getFkDriverId() {
        return fkDriverId;
    }

    public void setFkDriverId(Integer fkDriverId) {
        this.fkDriverId = fkDriverId;
    }

    public String getFkLocationCode() {
        return fkLocationCode;
    }

    public void setFkLocationCode(String fkLocationCode) {
        this.fkLocationCode = fkLocationCode == null ? null : fkLocationCode.trim();
    }

    public Integer getFkOperatorId() {
        return fkOperatorId;
    }

    public void setFkOperatorId(Integer fkOperatorId) {
        this.fkOperatorId = fkOperatorId;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getJgTriggerTime() {
        return jgTriggerTime;
    }

    public void setJgTriggerTime(Integer jgTriggerTime) {
        this.jgTriggerTime = jgTriggerTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}