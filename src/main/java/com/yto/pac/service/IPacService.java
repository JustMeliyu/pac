package com.yto.pac.service;

import com.yto.pac.pojo.OrderData;

public interface IPacService {
	
	OrderData getOrderData(String transNumber);
}
