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
        WishListEntity wishListEntity = createWishList();
        wishListRepository.save(wishListEntity);

        var expected = wishListRepository.findById(1);

        Assertions.assertEquals(true, expected.isPresent());
        Assertions.assertEquals(1, expected.get().getIndex());
    }

    @Test
    public void updateTest() {
        WishListEntity wishListEntity = createWishList();
        WishListEntity expected = wishListRepository.save(wishListEntity);

        expected.setTitle("update test");
        WishListEntity savEntity = wishListRepository.save(expected);

        Assertions.assertEquals("update test", savEntity.getTitle());
        Assertions.assertEquals(1, wishListRepository.listAll().size());
    }

    @Test
    public void deleteTest() {
        WishListEntity wishListEntity = createWishList();
        wishListRepository.save(wishListEntity);

        wishListRepository.deleteById(1);

        int count = wishListRepository.listAll().size();

        Assertions.assertEquals(0, count);
    }
    
    @Test
    public void listAllTest() {
        WishListEntity wishListEntity1 = createWishList();
        wishListRepository.save(wishListEntity1);
        WishListEntity wishListEntity2 = createWishList();
        wishListRepository.save(wishListEntity2);

        int count = wishListRepository.listAll().size();

        Assertions.assertEquals(2, count);

    }
}
