package com.yto.pac.pojo;

import java.util.Date;
import java.util.List;

public class OrderData {
	//车辆电子运单号
	private String vehicleNo;
	//本次请求唯一标示
	private String uniqueCode;
	//数据类型：1 全量业务字段，2 到发车记录
	private String dataType;
	//运单创建时间
	private Date createTime;
	//车辆CP号
	private String truckCpNo;
	//车牌号
	private String truckNo;
	//车辆规划运行线路
	private String lineNo;
	//线路属性
	private String lineProperty;
	//线路频次编码
	private String frequencyNo;
	//实际运行线路
	private String realLineNo;
	//实际运行线路属性
	private String realLineProperty;
	//车签号
	private String truckLabelId;
	//车辆运行方式: 0 单边 1 双边
	private String runMode;
	private String truckType;
	//预计发车时间
	private Date predictDepartTime;
	//预计到车时间
	private Date predictArrivalTime;
	//运单状态：已完成，已取消，运行中
	private String status;
	private String remark;
	private List<Trace> traces;
	//电子车签
	private String protocolLabelId;
	
	
	public String getProtocolLabelId() {
		return protocolLabelId;
	}
	public void setProtocolLabelId(String protocolLabelId) {
		this.protocolLabelId = protocolLabelId;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getUniqueCode() {
		return uniqueCode;
	}
	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getTruckCpNo() {
		return truckCpNo;
	}
	public void setTruckCpNo(String truckCpNo) {
		this.truckCpNo = truckCpNo;
	}
	public String getTruckNo() {
		return truckNo;
	}
	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
	}
	public String getLineNo() {
		return lineNo;
	}
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}
	public String getLineProperty() {
		return lineProperty;
	}
	public void setLineProperty(String lineProperty) {
		this.lineProperty = lineProperty;
	}
	public String getFrequencyNo() {
		return frequencyNo;
	}
	public void setFrequencyNo(String frequencyNo) {
		this.frequencyNo = frequencyNo;
	}
	public String getRealLineNo() {
		return realLineNo;
	}
	public void setRealLineNo(String realLineNo) {
		this.realLineNo = realLineNo;
	}
	public String getRealLineProperty() {
		return realLineProperty;
	}
	public void setRealLineProperty(String realLineProperty) {
		this.realLineProperty = realLineProperty;
	}
	public String getTruckLabelId() {
		return truckLabelId;
	}
	public void setTruckLabelId(String truckLabelId) {
		this.truckLabelId = truckLabelId;
	}
	public String getRunMode() {
		return runMode;
	}
	public void setRunMode(String runMode) {
		this.runMode = runMode;
	}
	public String getTruckType() {
		return truckType;
	}
	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}
	public Date getPredictDepartTime() {
		return predictDepartTime;
	}
	public void setPredictDepartTime(Date predictDepartTime) {
		this.predictDepartTime = predictDepartTime;
	}
	public Date getPredictArrivalTime() {
		return predictArrivalTime;
	}
	public void setPredictArrivalTime(Date predictArrivalTime) {
		this.predictArrivalTime = predictArrivalTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<Trace> getTraces() {
		return traces;
	}
	public void setTraces(List<Trace> traces) {
		this.traces = traces;
	}
	@Override
	public String toString() {
		return "OrderData [vehicleNo=" + vehicleNo + ", uniqueCode=" + uniqueCode + ", dataType=" + dataType
				+ ", createTime=" + createTime + ", truckCpNo=" + truckCpNo + ", truckNo=" + truckNo + ", lineNo="
				+ lineNo + ", lineProperty=" + lineProperty + ", frequencyNo=" + frequencyNo + ", realLineNo="
				+ realLineNo + ", realLineProperty=" + realLineProperty + ", truckLabelId=" + truckLabelId
				+ ", runMode=" + runMode + ", truckType=" + truckType + ", predictDepartTime=" + predictDepartTime
				+ ", predictArrivalTime=" + predictArrivalTime + ", status=" + status + ", remark=" + remark
				+ ", traces=" + traces + "]";
	}
	
	
}
