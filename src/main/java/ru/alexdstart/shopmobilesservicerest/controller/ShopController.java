package ru.alexdstart.shopmobilesservicerest.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.alexdstart.shopmobilesservicerest.entity.Shop;
import ru.alexdstart.shopmobilesservicerest.service.ShopService;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/new")
    public ResponseEntity<Shop> newShop(@RequestBody Shop shop) {
        Shop addedShop = shopService.addShop(shop);
        return ResponseEntity.ok(addedShop);
    }
    @GetMapping
    public ResponseEntity<List<Shop>> getAllShops() {
        List<Shop> shops = shopService.getAllShops();
        return ResponseEntity.ok(shops);
    }

}
