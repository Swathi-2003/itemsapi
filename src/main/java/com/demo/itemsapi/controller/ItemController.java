package com.demo.itemsapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // In-memory storage
    private List<Item> items = new ArrayList<>();

    // ----------------------------
    // ADD NEW ITEM
    // POST /items
    // ----------------------------
    @PostMapping
    public ResponseEntity<String> addItem(@RequestBody Item item) {

        if (item.getId() <= 0) {
            return new ResponseEntity<>("Item id must be greater than 0", HttpStatus.BAD_REQUEST);
        }

        if (item.getName() == null || item.getName().trim().isEmpty()) {
            return new ResponseEntity<>("Item name is required", HttpStatus.BAD_REQUEST);
        }

        if (item.getDescription() == null || item.getDescription().trim().isEmpty()) {
            return new ResponseEntity<>("Item description is required", HttpStatus.BAD_REQUEST);
        }

        items.add(item);
        return new ResponseEntity<>("Item added successfully", HttpStatus.CREATED);
    }

    // ----------------------------
    // GET ITEM BY ID
    // GET /items/{id}
    // ----------------------------
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable int id) {

        for (Item item : items) {
            if (item.getId() == id) {
                return new ResponseEntity<>(item, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
