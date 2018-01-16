package com.poc.rest.consumer;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

	public void configure() {

		from("file:D:/tmp/inputFolder/catalog")
		.process(new MyProcessor())
		.to("file:D:/tmp/outputFolder/catalog");
	}
}
