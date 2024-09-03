package com.hmall.search.web;

import com.hmall.common.dto.PageDTO;
import com.hmall.search.pojo.ItemDoc;
import com.hmall.search.pojo.RequestParams;
import com.hmall.search.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    private ISearchService searchService;

    @GetMapping("hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("suggestion")
    public List<String> getSuggestion(@RequestParam("key") String prefix) {
        return searchService.getSuggestion(prefix);
    }

    @PostMapping("filters")
    public Map<String,List<String>> getFilters(@RequestBody RequestParams params){
        return searchService.getFilters(params);
    }
    @PostMapping("list")
    public PageDTO<ItemDoc> search(@RequestBody RequestParams params){
        return searchService.search(params);
    }
}
