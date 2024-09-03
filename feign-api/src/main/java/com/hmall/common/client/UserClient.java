package com.hmall.common.client;

import com.hmall.common.dto.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "userservice")
public interface UserClient {
    @GetMapping("/address/{id}")
    Address findAddressById(@PathVariable("id") Long id);
}
