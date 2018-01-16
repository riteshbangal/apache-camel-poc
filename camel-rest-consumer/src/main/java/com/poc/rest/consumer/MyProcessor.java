package com.poc.rest.consumer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		System.out.println("Processed successfully");
	}
}
