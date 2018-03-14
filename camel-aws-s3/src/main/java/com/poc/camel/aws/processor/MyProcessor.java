package com.poc.camel.aws.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.poc.camel.aws.exception.CamelCustomException;

public class MyProcessor implements Processor {
	
	public void process(Exchange exchange) throws Exception {
		
		if (null != exchange.getProperty("CamelFileExchangeFile") 
				&& exchange.getProperty("CamelFileExchangeFile").toString().contains("Jellyfish")) {
			
			System.out.println("Exception Thrown");
			throw new CamelCustomException();
		} else if (null != exchange.getProperty("CamelFileExchangeFile")) {
			String fileName = (String) exchange.getProperty("CamelFileExchangeFile").toString();
			System.out.println(fileName);
		} else {
			System.out.println("Undefined!");
		}
	}
}
