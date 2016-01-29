package com.lm.mapping2;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lm.model.Transfer;

@Component
public interface TranMapper2 {
	
	List<Transfer> tranFlow();
	
	void transfer(Transfer tf);
}
