package com.javainuse;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        //from("file:D:/tmp/inputFolder?noop=true").to("file:D:/tmp/outputFolder");
        

    	onException(Exception.class).process(new Processor() {

    		public void process(Exchange exchange) throws Exception {
				System.out.println("handling exception.");
			}
		}).log("Received body ${body}").handled(true);
    	
        from("file:D:/tmp/inputFolder/catalog")
	        .process(new Processor() {
				
				public void process(Exchange exchange) throws Exception {
					System.out.println("Inside Processor.");
				}
			})
			.setHeader("To", simple("rbangal@sapient.com")).setHeader("From", simple("no-reply@elasticpath.com"))
			.setHeader("Subject", simple("Camel Import Exception")).setBody(simple("The Camel Import failed while processing file"))
			//.process(fileAttachmentProcessor)
		.to("smtp://" + "localhost:25");
    }

}