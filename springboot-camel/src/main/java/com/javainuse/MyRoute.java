package com.javainuse;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:D:/tmp/inputFolder?noop=true").to("file:D:/tmp/outputFolder");
	}
}