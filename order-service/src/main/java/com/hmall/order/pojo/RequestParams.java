package com.hmall.order.pojo;

import lombok.Data;

@Data
public class RequestParams {
    private Integer num;
    private Long itemId;
    private Long addressId;
    private Integer paymentType;
}
