package com.haniyemollaei.mosallas.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.haniyemollaei.mosallas.domain.Shop;
import com.haniyemollaei.mosallas.domain.User;
import com.haniyemollaei.mosallas.repository.ShopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "shop-info")
public class ShopController {
    private final ShopRepository shopRepository;
    public ShopController(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public boolean checkIfMobileNoExists(Long userId)
    {
        if(!shopRepository.findByUserId(userId).isEmpty())
        {
            return true;
        }
        return false;
    }

    public String registerUserService(Shop shop)
    {
        try
        {
            shopRepository.save(shop);
        }
        catch (Exception e)
        {
            return  "An error occurred Shop info not saved!";
        }

        return "Shop info saved";
    }


    @PostMapping("/add-shop-info")
    public ResponseEntity<?> registerShop(@RequestBody Shop shop) throws Exception
    {
        HashMap<String, String> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        //Objects.requireNonNull(user);
        System.out.println(shop.getUserId());
        if(checkIfMobileNoExists(shop.getUserId()))
        {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User with this mobile number exists");
        }

        String result = registerUserService(shop);

        if (result.equals("User saved"))
        {
            map.put("id", shop.getId().toString());
            return ResponseEntity.ok(objectMapper.writeValueAsString(map));

        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while saving user");
    }


    @GetMapping("/find-by-id")
    @ResponseBody
    public ResponseEntity<Shop> getShop(@RequestParam("id") Long id) {
        List<Shop> shopList = shopRepository.findAll();
        Shop shop = null;
        for (int i = 0 ; i < shopList.size() ; i++) {
            if(shopList.get(i).getId()==id){
                shop = shopList.get(i);
            }
        }
        return ResponseEntity.ok(shop);
    }

    @GetMapping("/find-by-user-id")
    @ResponseBody
    public ResponseEntity<Shop> getShopInfoByUserId(@RequestParam("userId") Long userId) {
        List<Shop> shopList = shopRepository.findByUserId(userId);
        return ResponseEntity.ok(shopList.get(0));
    }

}
