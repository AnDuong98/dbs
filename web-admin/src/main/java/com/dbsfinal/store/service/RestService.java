package com.dbsfinal.store.service;

import com.dbsfinal.store.entity.APIResponse;
import com.dbsfinal.store.entity.LoginRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.Map;

public interface RestService {

	<T> APIResponse<T> execute(
			String url, HttpMethod method, HttpHeaders headers, Object body,
			ParameterizedTypeReference<APIResponse<T>> type, Map<String, Object> values);
	
	<T> APIResponse<T> execute(
			String url, HttpMethod method, HttpHeaders headers, Object body,
			ParameterizedTypeReference<APIResponse<T>> type);

	APIResponse<String> getToken(String urlPrefix,  HttpMethod method,
			LoginRequest loginRequest);

}
