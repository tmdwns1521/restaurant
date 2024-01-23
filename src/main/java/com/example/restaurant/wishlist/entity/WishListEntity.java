package com.example.restaurant.wishlist.entity;

import java.time.LocalDateTime;

import com.example.restaurant.db.MemoryDbEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class WishListEntity extends MemoryDbEntity {
    
    private String title;
    private String category;
    private String address;
    private String roadAddress;
    private String homePageLink;
    private boolean isVisit;
    private int visitCount;
    private LocalDateTime lastVisitDate;
}
