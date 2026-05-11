package com.william.aop.services;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MeasurementService {

    public String getService(){
        System.out.println("(MeasurmenteService): --- EXECUTED TASK ---");
        try{
            TimeUnit.SECONDS.sleep(4);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Services ended";
    }

    public String getServiceSixSeconds(){
        System.out.println("(MeasurmenteService): --- EXECUTED TASK ---");
        try{
            TimeUnit.SECONDS.sleep(9);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Services ended";
    }

    public String getServiceSevenSeconds(){
        System.out.println("(MeasurmenteService): --- EXECUTED TASK ---");
        try{
            TimeUnit.SECONDS.sleep(7);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Services ended";
    }
}
