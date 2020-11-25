package com.dbsfinal.store.service;

import java.util.List;

import com.dbsfinal.store.dto.CategoryDTO;
import com.dbsfinal.store.entity.APIResponse;
import com.dbsfinal.store.service.impl.RestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private RestServiceImpl restTemplateService;

    @Value("${api.url}")
    private String url;

    @Value("${prefix.categories}")
    private String preUrl;

    public List<CategoryDTO> getAllCategory() {
        return restTemplateService.execute(
                new StringBuilder(url).append("categories/categories").toString(),
                HttpMethod.GET,
                null,
                null,
                new ParameterizedTypeReference<APIResponse<List<CategoryDTO>>>() {
                }).getData();
    }

    public CategoryDTO getCategoryById(int id) {
        return restTemplateService.execute(
                new StringBuilder(url).append("categories/").append(id).toString(),
                HttpMethod.GET,
                null,
                null,
                new ParameterizedTypeReference<APIResponse<CategoryDTO>>() {
                }).getData();
    }
}