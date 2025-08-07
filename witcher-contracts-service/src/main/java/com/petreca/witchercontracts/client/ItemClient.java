package com.petreca.witchercontracts.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bestiary-and-armory-app")
public interface ItemClient {

    @GetMapping("/items/{id}")
    ItemDTO findItemById(@PathVariable("id") Long id);
}
