package br.com.fiap.avaliacao;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class MainApp {
	public static void main(String[] args){

		SimpleRouteBuilder rb = new SimpleRouteBuilder();
		CamelContext cc = new DefaultCamelContext();
		
		ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
		cc.addComponent("jms",JmsComponent.jmsComponentAutoAcknowledge(cf));
		
		try{
			cc.addRoutes(rb);
			cc.start();
			Thread.sleep(5*60*1000);
			cc.stop();
		}catch(Exception e){
			e.printStackTrace();
		
		}

	}
}
