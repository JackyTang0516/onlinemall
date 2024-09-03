package com.hmall.search.pojo;

import lombok.Data;

@Data
public class RequestParams {
    private String key;
    private Integer page = 1;
    private Integer size = 5;
    private String sortBy;
    private String brand;
    private String category;
    private Long minPrice;
    private Long maxPrice;
}
