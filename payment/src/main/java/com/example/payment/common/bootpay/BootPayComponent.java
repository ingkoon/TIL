package com.example.payment.common.bootpay;
import kr.co.bootpay.Bootpay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.util.Base64;
import java.util.HashMap;

@Slf4j
@Component
public class BootPayComponent {
    @Value("${boot-pay.rest-api-key}")
    private String restApiKey;
    @Value("${boot-pay.private-key}")
    private String privateKey;

    @Bean
    public HashMap<String, Object> connectBootpay() throws Exception{
//        Bootpay bootpay = new Bootpay(
//                Base64.getEncoder().encodeToString(restApiKey.getBytes()),
//                Base64.getEncoder().encodeToString(privateKey.getBytes()));
        Bootpay bootpay = new Bootpay(restApiKey, privateKey);

        log.info("입력시작접");
        HashMap<String, Object> res = bootpay.getAccessToken();
        if(res.get("error_code") == null) { //success
            log.info("goGetToken success: " + res);
            return res;
        }
//        return null;
        throw new Exception();
    }
}
