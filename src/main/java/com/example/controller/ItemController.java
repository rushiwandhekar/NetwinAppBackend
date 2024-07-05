package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Item;
import com.example.service.ItemService;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/createItem")
    public Item createItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }
}