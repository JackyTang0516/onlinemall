package com.hmall.search.service;

import com.hmall.common.dto.PageDTO;
import com.hmall.search.pojo.ItemDoc;
import com.hmall.search.pojo.RequestParams;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface ISearchService {
    List<String> getSuggestion(String prefix);

    Map<String, List<String>> getFilters(RequestParams params);

    PageDTO<ItemDoc> search(RequestParams params);

    void deleteItemById(Long id);

    void saveItemById(Long id);
}
