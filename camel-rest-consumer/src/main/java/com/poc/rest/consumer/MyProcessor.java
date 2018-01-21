package com.poc.rest.consumer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {

		System.out.println("Process started...");
		
		// Extracting information from the request
		String incomingText = exchange.getIn().getBody(String.class);
		if (null == incomingText) {
			System.out.println("Not able to Processed successfully, as incoming text is empty.");
			return;
		}
		
		System.out.println("Request Text :: " + incomingText);
		System.out.println("Processed successfully");
	}
}
