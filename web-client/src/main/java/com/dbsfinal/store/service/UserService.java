package com.dbsfinal.store.service;

import com.dbsfinal.store.dto.UserDTO;
import com.dbsfinal.store.entity.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private RestService restTemplateService;

    @Value("${api.url}")
    private String url;

    @Value("${prefix.user}")
    private String preUrl;


    public UserDTO getUsertById(Integer id) {
        return restTemplateService.execute(
                new StringBuilder(url).append("user/").append(id).toString(),
                HttpMethod.GET,
                null,
                null,
                new ParameterizedTypeReference<APIResponse<UserDTO>>() {
                }).getData();
    }
}
