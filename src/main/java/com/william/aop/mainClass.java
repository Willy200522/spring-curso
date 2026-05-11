package com.william.aop;

import com.william.aop.services.MeasurementService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class mainClass {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        MeasurementService service = context.getBean("measurementService", MeasurementService.class);

        System.out.println("Main: call services method");

        System.out.println("Main: return data: " + service.getService());
        System.out.println("Main: return data six seconds: " + service.getServiceSixSeconds());
        System.out.println("Main: return data seven seconds: " + service.getServiceSevenSeconds());

        context.close();

    }
}
