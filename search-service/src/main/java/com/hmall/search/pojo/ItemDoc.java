package com.hmall.search.pojo;

import com.hmall.common.dto.Item;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ItemDoc {
    private Long id;
    private String name;
    private Long price;
    private String image;
    private String category;
    private String brand;
    private Integer sold;
    private Integer commentCount;
    private Boolean isAD;
    private List<String> suggestion = new ArrayList<>(2);

    public ItemDoc(Item item) {
        // 属性拷贝
        BeanUtils.copyProperties(item, this);
        // 补全
        suggestion.add(item.getBrand());
        suggestion.add(item.getCategory());
    }
}
