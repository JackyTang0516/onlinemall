package com.hmall.item.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmall.common.dto.PageDTO;
import com.hmall.item.pojo.Item;
import com.hmall.item.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private IItemService itemService;

    @GetMapping("hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("/list")
    public PageDTO<Item> queryItemByPage(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        // 分页查询
        Page<Item> result = itemService.page(new Page<>(page, size));
        // 封装并返回
        return new PageDTO<>(result.getTotal(), result.getRecords());
    }

    @GetMapping("{id}")
    public Item queryItemById(@PathVariable("id") Long id) {
        return itemService.getById(id);
    }

    /**
     * 在mybatis-plus中，查询只需要以下几个方法：
     *  - 根据id查询一个 getById(id)
     *  - 根据id查询多个 listByIds(List<Id>)
     *  - 根据复杂条件查询一个、多个、分页
     *      - 1个：query().eq().ge().or().le().one();
     *      - 多个：query().eq().ge().or().le().list();
     *      - 分页：query().eq().ge().or().le().page(new Page(1, 3));
     *
     */
    @GetMapping("/query")
    public List<Item> queryItemById(
            @RequestParam("minPrice") Integer minPrice,
            @RequestParam("maxPrice") Integer maxPrice,
            @RequestParam("category") String category
    ) {
        return itemService.query() // where category = ? and price > ? and price < ?
                .eq("category", category)
                .ge("price", minPrice)
                .le("price", maxPrice).list();
    }

    @PostMapping
    public void saveItem(@RequestBody Item item) {
        // 基本数据
        item.setCreateTime(new Date());
        item.setUpdateTime(new Date());
        item.setStatus(2);
        // 新增
        itemService.save(item);
    }

    @PutMapping("/status/{id}/{status}")
    public void updateItemStatus(@PathVariable("id") Long id, @PathVariable("status") Integer status){
        itemService.updateStatus(id, status);
    }

    @PutMapping
    public void updateItem(@RequestBody Item item) {
        // 基本数据
        item.setUpdateTime(new Date());
        // 不允许修改商品状态，所以强制设置为null，更新时，就会忽略该字段
        item.setStatus(null);
        // 更新
        itemService.updateById(item);
    }

    @DeleteMapping("{id}")
    public void deleteItemById(@PathVariable("id") Long id) {
        itemService.removeById(id);
    }

    @PutMapping("/stock/{itemId}/{num}")
    public void updateStock(@PathVariable("itemId") Long itemId, @PathVariable("num") Integer num){
        itemService.deductStock(itemId, num);
    }
}
