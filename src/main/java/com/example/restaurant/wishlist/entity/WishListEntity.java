package com.example.restaurant.wishlist.entity;

import java.time.LocalDateTime;

import com.example.restaurant.db.MemoryDbEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false) // 이 줄을 추가하여 경고를 숨깁니다
public class WishListEntity extends MemoryDbEntity {

    private String title;
    private String category;
    private String address;
    private String roadAddress;
    private String imageLink;
    private String homePageLink;
    private boolean isVisit;
    private int visitCount;
    private LocalDateTime lastVisitDate;
}
