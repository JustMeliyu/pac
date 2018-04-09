package com.yto.pac.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yto.pac.dao.IPacDao;
import com.yto.pac.pojo.Line;
import com.yto.pac.pojo.OrderData;
import com.yto.pac.pojo.Trace;
import com.yto.pac.pojo.TransportDepartureArrivalRecord;
import com.yto.pac.pojo.TransportProtocol;
import com.yto.pac.service.IPacService;
@Service
public class PacServiceImpl implements IPacService {

	//1 全量业务字段
	private final String DATATYPE_1="1";
	@Autowired
	private IPacDao dao;
	@Override
	public OrderData getOrderData(String transNumber) {
		OrderData data = null;
		
		TransportProtocol protocol = dao.selectProtocol(transNumber);
		//运单主表数据
		if(protocol == null)
			return data;
		data = new OrderData();
		data.setVehicleNo(transNumber);
		data.setUniqueCode(UUID.randomUUID().toString());
		data.setDataType(DATATYPE_1);
		data.setCreateTime(protocol.getCreateTime());
		data.setTruckNo(protocol.getPlate());
		data.setLineNo(protocol.getLineNo());
		data.setRunMode(protocol.getRunMode() == null ? null :protocol.getRunMode().toString());
		data.setTruckType(protocol.getVehicleType());
		data.setPredictDepartTime(protocol.getStartTime());
		data.setPredictArrivalTime(protocol.getEndTime());
		data.setStatus(protocol.getStatus()==null?null:protocol.getStatus().toString());

		//车辆cp编号
		data.setTruckCpNo(dao.selectTruck(protocol.getFkTruckId()));
		//车签号
		List<String> cqs = dao.selectCq(transNumber);
		if(cqs != null && cqs.size()>0)
			data.setTruckLabelId(cqs.get(0));
		//手签
		data.setProtocolLabelId(dao.selectNoteCqNumber(transNumber));
		//线路表
		List<Line> lines = dao.selectLine(data.getLineNo());
		if(lines != null && lines.size()>0)
		{			
			Line line = lines.get(0);
			data.setLineProperty(line.getLineProperty());
			data.setFrequencyNo(line.getLineFrequencyNo());
		}
		
		//实际线路
		List<String> lineNos = dao.selectLineNote(transNumber);
		if(lineNos != null && lineNos.size()>0)
		{
			String lineNo = lineNos.get(0);
			lines = dao.selectLine(lineNo);
			if(lines != null && lines.size()>0)
			{
				Line line = lines.get(0);
				data.setRealLineNo(lineNo);
				data.setRealLineProperty(line.getLineProperty());
			}
			
		}
		List<String> remarks = dao.selectRemark(transNumber);
		if(remarks != null && remarks.size()>0)
		{
			StringBuffer sbRemarks = new StringBuffer();
			for(String item : remarks)
			{
				sbRemarks.append(item+";");
			}
			data.setRemark(sbRemarks.substring(0, sbRemarks.length()-1));
		}
		
		List<TransportDepartureArrivalRecord> lists = dao.selectTDAR(transNumber);
		if(lists != null)
		{
			List<Trace> traces = new ArrayList<Trace>();
			for(TransportDepartureArrivalRecord record : lists)
			{
				Trace trace = new Trace();
				trace.setOrgCode(record.getFkLocationCode());
				trace.setOpTime(record.getStatusTime());
				trace.setOpType(record.getType()==null ? null : record.getType().toString());
				trace.setSourceType(record.getSourceType()==null?null :record.getSourceType().toString());
				traces.add(trace);
			}
			data.setTraces(traces);
		}
		return data;
	}

}
