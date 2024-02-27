package com.example.restaurant.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.wishlist.dto.WishListDto;
import com.example.restaurant.wishlist.service.WishListService;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class ApiController {

    private final WishListService wishListService;

    @GetMapping("/search")
    public WishListDto search(@RequestParam(name = "query") String query) {
        return wishListService.search(query);
    }

    @PostMapping("/")
    public WishListDto add(@RequestBody WishListDto wishListDto) {

        System.out.println("wishListDto ::: " + wishListDto);
        wishListDto.setCategory("fwef");

        // return ResponseEntity.ok(wishListService.add(wishListDto));

        return wishListService.add(wishListDto);
    }

    @GetMapping("/all")
    public List<WishListDto> findAll() {
        return wishListService.findAll();
    }
}
