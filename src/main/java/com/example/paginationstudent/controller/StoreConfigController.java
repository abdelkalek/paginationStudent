package com.example.paginationstudent.controller;

import com.example.paginationstudent.models.CongifStoreParam;
import com.example.paginationstudent.service.StoreService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Abdelkhalek Guedri
 * @since 11/07/2023
 */
@RestController
@RequestMapping("/storeconfig")
public class StoreConfigController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/getSoreObjectById/{idStore}")
    public ResponseEntity<?> getStoreObjectById(@PathVariable("idStore") UUID idStore) {


        Map<String, String> storeAttributsMap = new HashMap<>();
        Optional<CongifStoreParam> congifStoreParam = storeService.getById(idStore);
        String storeName = congifStoreParam.get().getName();
        congifStoreParam.get().getCongifStoreProperties().stream().forEach(element -> {
            storeAttributsMap.put(element.getKey(), element.getValue());
        });
        String url = "https://dummyjson.com/products";

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final Object pojo = mapper.convertValue(storeAttributsMap, Object.class);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(result);
    }

}
