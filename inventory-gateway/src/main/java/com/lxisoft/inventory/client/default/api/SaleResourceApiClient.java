package com.lxisoft.inventory.client.default.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.lxisoft.inventory.client.default.ClientConfiguration;

@FeignClient(name="${default.name:default}", url="${default.url:}", configuration = ClientConfiguration.class)
public interface SaleResourceApiClient extends SaleResourceApi {
}