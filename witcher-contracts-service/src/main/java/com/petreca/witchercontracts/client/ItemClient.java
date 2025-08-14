package com.petreca.witchercontracts.client;

import com.petreca.witchercontracts.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bestiary-and-armory-app", configuration = FeignConfig.class)
public interface ItemClient {

    @GetMapping("/api/items/{id}")
    ItemDTO findItemById(@PathVariable("id") Long id);
}
