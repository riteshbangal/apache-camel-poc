package com.poc.rest.consumer;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

	public void configure() {

		//restConfiguration().component("http").host("localhost").port(9000);
		
		/*rest("/service/topics")
        .get().consumes("application/json")
		//.process(new MyProcessor())
		.to("file:D:/tmp/outputFolder/catalog");*/
		
		from("timer:service/topics?period=2000")
		//from("quartz2://httpFetch?cron=* * * * * ? *")
		//from("direct:start")
		//.process(new MyProcessor())
		
		.setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http4.HttpMethods.POST))
		//.setHeader(Exchange.CONTENT_TYPE, constant("application/xml"))
		//.to("http4://localhost:9000/service/topics?throwExceptionOnFailure=false").streamCaching()
		.to("http4://localhost:9000/service/topics/100?throwExceptionOnFailure=false&authUsername=admin&authPassword=admin").streamCaching()
		
		.process(new MyProcessor())
		.to("file:D:/tmp/outputFolder/catalog");
		
		
		/*from("http:localhost:9000/service/topics")
		.setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http4.HttpMethods.GET))
		.process(new MyProcessor())
		.to("file:D:/tmp/outputFolder/catalog");*/
		
		//from("direct:getRestExternalService") 
		/*from("direct:start")
		.setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http4.HttpMethods.GET))
			.process(new MyProcessor())
			.to("http4://localhost:9000/service/topics")
			.process(new MyProcessor())
			.to("file:D:/tmp/outputFolder/catalog");*/
		
		 /*from("http4:localhost:9000/service/topics")
		 	.process(new MyProcessor())
		 	.to("file:D:/tmp/outputFolder/catalog");
         	//.to("direct:getTopics");*/
	}
}
