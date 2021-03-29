package com.ponto.payment.services;

import com.ponto.payment.UserFeignClient;
import com.ponto.payment.dto.UserDTO;
import com.ponto.payment.entities.Payment;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Component
public class PaymentService {

    private static final String host = "localhost:8001/";

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPaymentWithRestTemplate(Long userId, int days){
        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("id", String.valueOf(userId));

        UserDTO user = restTemplate.getForObject(host + "/users/{id}", UserDTO.class, uriVariables);
        return new Payment(user.getCargo(), user.getDailyInCome(), days);
    }

    public Payment getPaymentWithFeign(Long userId, int days){
        UserDTO userDTO = userFeignClient.findById(userId).getBody();
        return new Payment(userDTO.getCargo(), userDTO.getDailyInCome(), days);
    }

}
