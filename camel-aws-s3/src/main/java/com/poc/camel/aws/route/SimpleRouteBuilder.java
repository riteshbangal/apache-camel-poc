package com.poc.camel.aws.route;

import org.apache.camel.builder.RouteBuilder;

import com.poc.camel.aws.processor.MyProcessor;

public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:D:/tmp/inputFolder?noop=true")
        	.process(new MyProcessor())
        	.to("file:D:/tmp/outputFolder");
    }
}