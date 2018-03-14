package com.poc.camel.aws.route;

import org.apache.camel.builder.RouteBuilder;

import com.poc.camel.aws.processor.AwsS3Processor;

/**
 * https://dzone.com/articles/cloud-integration-apache-camel
 */
public class AwsS3RouteBuilder extends RouteBuilder {

	@Override
	public void configure() {
		
		// Transfer data from the AWS S3 service to your file outbox
		from("aws-s3://camel-s3-bucket?amazonS3Client=#s3Client&region=us-east-1")
			.process(new AwsS3Processor())
			.to("file:D:/tmp/outputFolder");
		
	}
}
