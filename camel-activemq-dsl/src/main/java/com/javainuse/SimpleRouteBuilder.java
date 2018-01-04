package com.javainuse;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {
	//configure route for jms component
    @Override
    public void configure() throws Exception {
        from("file:D:/tmp/inputFolder").split().tokenize("\n").to("jms:queue:javainuse");
    }

}