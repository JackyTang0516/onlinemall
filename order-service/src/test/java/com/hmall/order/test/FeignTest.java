package com.hmall.order.test;

import com.hmall.common.client.UserClient;
import com.hmall.common.dto.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeignTest {
    @Autowired
    private UserClient userClient;

    @Test
    public void testFindAddress() {
        Address address = userClient.findAddressById(59L);

        System.out.println("address = " + address);
    }
}
