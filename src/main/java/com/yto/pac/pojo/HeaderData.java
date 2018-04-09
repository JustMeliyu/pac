package com.yto.pac.pojo;

public class HeaderData {
	private  String msg_type;
	private  String logistic_provider_id;
	private  String data_digest;
	private  String to_code;
	private  String logistics_interface;
	public String getMsg_type() {
		return msg_type;
	}
	public void setMsg_type(String msg_type) {
		this.msg_type = msg_type;
	}
	public String getLogistic_provider_id() {
		return logistic_provider_id;
	}
	public void setLogistic_provider_id(String logistic_provider_id) {
		this.logistic_provider_id = logistic_provider_id;
	}
	public String getData_digest() {
		return data_digest;
	}
	public void setData_digest(String data_digest) {
		this.data_digest = data_digest;
	}
	public String getTo_code() {
		return to_code;
	}
	public void setTo_code(String to_code) {
		this.to_code = to_code;
	}
	public String getLogistics_interface() {
		return logistics_interface;
	}
	public void setLogistics_interface(String logistics_interface) {
		this.logistics_interface = logistics_interface;
	}
	public HeaderData() {}
	public HeaderData(String msg_type, String logistic_provider_id, String data_digest, String to_code,
			String logistics_interface) {
		super();
		this.msg_type = msg_type;
		this.logistic_provider_id = logistic_provider_id;
		this.data_digest = data_digest;
		this.to_code = to_code;
		this.logistics_interface = logistics_interface;
	}
	@Override
	public String toString() {
		return "HeaderData [msg_type=" + msg_type + ", logistic_provider_id=" + logistic_provider_id + ", data_digest="
				+ data_digest + ", to_code=" + to_code + ", logistics_interface=" + logistics_interface + "]";
	}
		
}
