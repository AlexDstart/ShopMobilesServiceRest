package ru.alexdstart.shopmobilesservicerest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexdstart.shopmobilesservicerest.entity.Shop;
import ru.alexdstart.shopmobilesservicerest.repository.ShopRepository;

import java.util.List;

@Service
public class ShopService {
    private ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop addShop(Shop shop) {
        return shopRepository.save(shop);

    }
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }
}
