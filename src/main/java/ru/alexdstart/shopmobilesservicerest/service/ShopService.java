package ru.alexdstart.shopmobilesservicerest.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alexdstart.shopmobilesservicerest.entity.Shop;
import ru.alexdstart.shopmobilesservicerest.repository.ShopRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ShopService {

     ShopRepository shopRepository;

    public Shop addShop(Shop shop) {
        return shopRepository.save(shop);
    }
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }
}
