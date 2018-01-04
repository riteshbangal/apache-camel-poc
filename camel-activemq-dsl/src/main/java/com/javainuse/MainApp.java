package com.javainuse;

import javax.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class MainApp {

    public static void main(String[] args) {
        SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();
        CamelContext ctx = new DefaultCamelContext();
        
        //configure jms component        
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
        ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        
        try {
            ctx.addRoutes(routeBuilder);
            ctx.start();
            System.out.println("CamelContext started...");
            Thread.sleep(5 * 60 * 1000);
            ctx.stop();
            System.out.println("CamelContext stopped...");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}