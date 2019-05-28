package com.lxisoft.inventory.client.inventory.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.lxisoft.inventory.client.inventory.ClientConfiguration;

@FeignClient(name="${inventory.name:inventory}", url="${inventory.url:localhost:8080/}", configuration = ClientConfiguration.class)
public interface UserJwtControllerApiClient extends UserJwtControllerApi {
}