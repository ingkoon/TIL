package com.example.payment.common.bootpay;
import kr.co.bootpay.Bootpay;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class BootpayConfiguration {

    @Value("${boot-pay.rest-api-key}")
    private String restApiKey;

    private Bootpay bootpay =
            new Bootpay(restApiKey, "rm6EYECr6aroQVG2ntW0A6LpWnkTgP4uQ3H18sDDUYw=");

    @Bean
    public void connectBootpay(){
        try {
            HashMap res = bootpay.getAccessToken();
            if(res.get("error_code") == null) { //success
                System.out.println("goGetToken success: " + res);
            } else {
                System.out.println("goGetToken false: " + res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
