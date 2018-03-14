package com.poc.camel.aws.route;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.apache.camel.builder.RouteBuilder;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

/**
 * https://dzone.com/articles/cloud-integration-apache-camel
 */
public class AwsS3Route extends RouteBuilder {

	@Override
	public void configure() {
		
		// Transfer data from your file inbox to the AWS S3 service
		/*from("file:D:/tmp/inputFolder?noop=true")
			.process(new AwsS3Processor())
			//.setHeader(S3Constants.KEY, simple("This is a static key"))
			.to("aws-s3://camel-s3-bucket?accessKey=AKIAIGHOC2QKWSYA5M2A"
					+ "&secretKey=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&region=us-east-1");
			//.to("aws-s3:ep-cloudops-964705782699?accessKey=RAW(AKIAIQULX57YFCEKDNIQ)&secretKey=RAW(AKIAIQULX57YFCEKDNIQ)&region=us-east-2");
			
		*/
		
		// Transfer data from the AWS S3 service to your file outbox
		from("aws-s3://camel-s3-bucket?amazonS3Client=#amazonS3Client"
				+ "&delay=5000&maxMessagesPerPoll=5&region=us-east-1")
			.to("file:D:/tmp/outputFolder");
		
		
		//from("aws-s3://camel-integration-bucket-mwea-kw?amazonS3Client=#amazonS3Client&region=eu-wes")
		/*from("aws-s3://ep-cloudops-964705782699?amazonS3Client=#amazonS3Client&region=us-east-2")
			.process(new AwsS3Processor())
			.to("file:files/outbox");
		*/
	}
	
	 @Produces
     @Named("amazonS3Client")
     AmazonS3 amazonS3Client() {
         AWSCredentials credentials = new BasicAWSCredentials("AKIAIGHOC2QKWSYA5M2A", 
         		"LFKlksMgeQ7fp1QK5v0QQ6z2m0WqvyPbmRzidpJo");
         AWSCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(credentials);
         AmazonS3ClientBuilder clientBuilder = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).withCredentials(credentialsProvider);
         return clientBuilder.build();
     }

}
