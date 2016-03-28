package com.lm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lm.mapping.TranMapper;
import com.lm.model.Transfer;
import com.lm.service.TranService;

@Service("tsi")
public class TranServiceImpl implements TranService {

	@Autowired
	private TranMapper tranMapper;

	@Override
	public List<Transfer> tranFlow() {
		
		return tranMapper.tranFlow();
	}

	@Override
	public void transfer(Transfer tf) {

		tranMapper.transfer(tf);
	}


}
