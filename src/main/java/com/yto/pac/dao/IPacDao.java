package com.yto.pac.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yto.pac.pojo.Line;
import com.yto.pac.pojo.TransportDepartureArrivalRecord;
import com.yto.pac.pojo.TransportProtocol;

public interface IPacDao {
	public TransportProtocol selectProtocol(@Param("transNumber") String transNumber);
	
	public List<Line> selectLine(@Param("lineNo") String lineNo);
	
	public List<TransportDepartureArrivalRecord> selectTDAR(@Param("transNumber") String transNumber);
	
	public String selectTruck(@Param("id") Integer id);
	
	public List<String> selectLineNote(@Param("transNumber") String transNumber);
	//获取车签（电子）
	public List<String> selectCq(@Param("transNumber") String transNumber);
	//备注信息
	public List<String> selectRemark(@Param("transNumber") String transNumber);
	/**
	 * 获取车签（手签）
	 * @param transNumber
	 * @return
	 */
	public String selectNoteCqNumber(@Param("transNumber") String transNumber);
}
