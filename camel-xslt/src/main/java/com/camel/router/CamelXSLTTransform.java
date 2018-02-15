package com.camel.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;


public class CamelXSLTTransform {
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Initializing the camel context...");
		CamelContext camelContext = new DefaultCamelContext();
		System.out.println("Implementing Routes......");
		
		camelContext.addRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {

				//from("xslt:http://www.exampledemo.com/test/mytransform.xsl")
				from("file:src/main/resources/inputs/")
				//.to("xslt:file:src/main/resources/transformers/catalog.xsl")
				.to("xslt:file:src/main/resources/transformers/mytransform.xslt")
				.to("file:src/main/resources/outputs/");
			}
		});
		
		System.out.println("Starting Camel Context......");
		camelContext.start();
		Thread.sleep(5 * 60 * 1000);
		camelContext.stop();
	}
}