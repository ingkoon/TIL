package com.example.payment.common.bootpay;
import com.example.payment.common.bootpay.exception.NoTokenException;
import kr.co.bootpay.Bootpay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class BootPayComponent {
    @Value("${boot-pay.rest-api-key}")
    private String restApiKey;
    @Value("${boot-pay.private-key}")
    private String privateKey;

    @Bean
    public HashMap<String, Object> connectBootpay() throws Exception{
        Bootpay bootpay = new Bootpay(restApiKey, privateKey);

        HashMap<String, Object> res = bootpay.getAccessToken();

        if(res.get("error_code") == null) { //success
            log.info("goGetToken success: " + res);
            return res;
        }
        throw new NoTokenException();
    }
}
