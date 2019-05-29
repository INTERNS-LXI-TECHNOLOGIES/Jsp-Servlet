package com.lxisoft.library.client.library.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.lxisoft.library.client.library.ClientConfiguration;

@FeignClient(name="${library.name:library}", url="${library.url:localhost:8080/library}", configuration = ClientConfiguration.class)
public interface UserResourceApiClient extends UserResourceApi {
}