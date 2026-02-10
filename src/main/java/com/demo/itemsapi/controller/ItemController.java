package com.demo.itemsapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.itemsapi.model.Item;

@RestController
@RequestMapping("/items")
public class ItemController {

    private List<Item> items = new ArrayList<>();

    // Add new item
    @PostMapping
    public String addItem(@RequestBody Item item) {

        if (item.getName() == null || item.getName().trim().isEmpty()) {
            return "Error: Item name is required";
        }

        if (item.getDescription() == null || item.getDescription().trim().isEmpty()) {
            return "Error: Item description is required";
        }

        items.add(item);
        return "Item added successfully";
    }

    // Get item by ID
    @GetMapping("/{id}")
    public Item getItem(@PathVariable int id) {

        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
