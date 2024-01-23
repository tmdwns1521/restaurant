package com.example.restaurant.wishlist.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.restaurant.RestaurantApplication;
import com.example.restaurant.wishlist.entity.WishListEntity;

@SpringBootTest(classes = RestaurantApplication.class)
public class WishListRepositoryTest {

    @Autowired
    private WishListRepository wishListRepository;

    private WishListEntity createWishList() {
        var wishList = new WishListEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("address");
        wishList.setRoadAddress("roadAddress");
        wishList.setHomePageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitDate(null);

        return wishList;
    }

    @Test
    public void saveTest() {
        WishListEntity wishListEntity = createWishList();
        WishListEntity savedEntity = wishListRepository.save(wishListEntity);

        Assertions.assertNotNull(savedEntity);
        Assertions.assertEquals(1, savedEntity.getIndex());
    }

    @Test
    public void findByIdTest() {

    }

    @Test
    public void deleteTest() {

    }
    
    @Test
    public void listAllTest() {

    }
}
