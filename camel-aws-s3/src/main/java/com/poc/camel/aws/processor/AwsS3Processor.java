package com.poc.camel.aws.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class AwsS3Processor implements Processor {

	public void process(Exchange exchange) throws Exception {
		System.out.println("Inside Aws S3 Processor.");
	}
}
