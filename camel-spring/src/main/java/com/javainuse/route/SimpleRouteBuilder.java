package com.javainuse.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.javainuse.exception.CamelCustomException;
import com.javainuse.processor.MyProcessor;

/**
 * @reference http://javainuse.com/camel/camel_EIP
 */
public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
		/*
		 * Simple - No exception handling
		 * from("file:D:/tmp/inputFolder?noop=true").process(new MyProcessor()).to("file:D:/tmp/outputFolder");
		 */
    	
    	
    	/*
    	 * #### Using Do Try block ####
    	 * This approach is similar to the Java try catch block. 
    	 * So the thrown exception will be immediately caught and the message wont keep on retrying.
    	 */
    	/*
    	from("file:D:/tmp/inputFolder?noop=true").doTry().process(new MyProcessor()).to("file:D:/tmp/outputFolder")
	    	.doCatch(CamelCustomException.class).process(new Processor() {
	
	    		public void process(Exchange exchange) throws Exception {
	    			System.out.println("handling ex");
	    		}
	    	}).log("Received body ${body}");
	    */
    	
    	/*
    	 * #### Using OnException block ####
    	 * The OnException block is written as a separate block from the routes.
    	 */
        onException(CamelCustomException.class).process(new Processor() {

            public void process(Exchange exchange) throws Exception {
                System.out.println("handling ex");
            }
        }).log("Received body ${body}").handled(true);

        from("file:D:/tmp/inputFolder?noop=true").process(new MyProcessor()).to("file:D:/tmp/outputFolder");
        //from("file:D:/tmp/inbox?noop=true").split().tokenize("\n").process(new MyProcessor()).to("file:D:/tmp/outputFolder");
        
        // Content Based routing- Route the message based on the token it contains.
        from("file:D:/tmp/inbox?noop=true")
        	.split().tokenize("\n")
        	.choice()
        	.when(body().contains("1")).to("file:D:/tmp/outputFolder/1")
        	//.when(body().contains("2")).to("file:D:/tmp/outputFolder/2")
        	.when(body().contains("3")).to("file:D:/tmp/outputFolder/3")
        	.otherwise().to("file:D:/tmp/outputFolder/otherwise");
 
    }
}