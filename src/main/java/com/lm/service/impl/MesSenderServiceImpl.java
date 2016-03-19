package com.lm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.lm.model.MesInfo;
import com.lm.service.MesSenderService;

@Service("mesSender")
public class MesSenderServiceImpl implements MesSenderService{

	@Autowired
	private JmsTemplate jmsTemplateQueue;
	@Autowired
	private JmsTemplate jmsTemplateTopic;

	public void sendQueue(MesInfo mi) {

		jmsTemplateQueue.convertAndSend(mi);
	}

	public void sendTopic(MesInfo mi) {

		jmsTemplateTopic.convertAndSend(mi);
	}
}
