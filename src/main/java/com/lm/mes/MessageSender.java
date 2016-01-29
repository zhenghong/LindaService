package com.lm.mes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.lm.model.MesInfo;

@Service("messageSender")
public class MessageSender {
	
	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(MesInfo mi) {
		
		jmsTemplate.convertAndSend(mi);
	}
}
