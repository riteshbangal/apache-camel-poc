package com.javainuse.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import com.javainuse.exception.CamelCustomException;

public class MyProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		if (exchange.getProperty("CamelFileLockFileName").toString().contains("Jellyfish")) {
			System.out.println("Exception Thrown");
			throw new CamelCustomException();
		}
	}
}
