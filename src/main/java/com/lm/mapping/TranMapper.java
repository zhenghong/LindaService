package com.lm.mapping;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lm.model.Transfer;

@Component
public interface TranMapper {
	
	List<Transfer> tranFlow();
	
	void transfer(Transfer tf);
}
