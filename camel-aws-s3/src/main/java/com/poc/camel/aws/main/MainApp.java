package com.poc.camel.aws.main;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import com.poc.camel.aws.route.AwsS3Route;

public class MainApp {

    public static void main(String[] args) {
        //SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();
        AwsS3Route awsS3Route = new AwsS3Route();
        CamelContext context = new DefaultCamelContext();
        try {
            //context.addRoutes(routeBuilder);
            context.addRoutes(awsS3Route);
            System.out.println("Starting Camel Context..");
            context.start();
            System.out.println("Camel Context started.");
            Thread.sleep(5 * 60 * 1000);
            context.stop();
            System.out.println("Camel Context stopped.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }
}