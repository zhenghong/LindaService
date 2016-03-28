package com.lm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lm.model.MesInfo;
import com.lm.service.MesSenderService;

@Service("mesSender")
public class MesSenderServiceImpl implements MesSenderService{

	@Autowired
	private JmsTemplate jmsTemplateQueue;
	@Autowired
	private JmsTemplate jmsTemplateTopic;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void sendQueue(MesInfo mi) {

		jmsTemplateQueue.convertAndSend("100");
		
		//int i = 1/0;
		
		jmsTemplateQueue.convertAndSend("200");
	}

	public void sendTopic(MesInfo mi) {

		jmsTemplateTopic.convertAndSend(mi);
	}
	
}
