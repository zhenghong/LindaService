package com.lm.mes;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

import com.lm.model.MesInfo;

@Service("consumerMessageListener")
public class ConsumerMessageListener implements MessageListener {

	public void onMessage(Message message) {

		if (message instanceof ObjectMessage) {

			ObjectMessage objMsg = (ObjectMessage) message;
			try {

				MesInfo mes = (MesInfo) objMsg.getObject();
				System.out.println(mes.getBeanName());

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} else {

			TextMessage textMsg = (TextMessage) message;
			try {

				System.out.println(textMsg.getText());
			} catch (JMSException ex) {
				ex.printStackTrace();
			}
		}
	}
}