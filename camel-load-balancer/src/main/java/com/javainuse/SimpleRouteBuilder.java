package com.javainuse;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:D:/tmp/inbox?noop=true")
			.split().tokenize("\n")
			.loadBalance().roundRobin()
			.to("jms:queue:javainuse1")
			.to("jms:queue:javainuse2")
			.to("jms:queue:javainuse3");
	}
}