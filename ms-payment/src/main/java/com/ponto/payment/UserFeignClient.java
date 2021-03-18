package com.ponto.payment;

import com.ponto.payment.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "ms-users", path = "/users")
public interface UserFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<UserDTO> findById(@PathVariable Long id);
}
