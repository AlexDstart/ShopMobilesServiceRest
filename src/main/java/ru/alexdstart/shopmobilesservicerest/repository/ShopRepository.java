package ru.alexdstart.shopmobilesservicerest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexdstart.shopmobilesservicerest.entity.Shop;
@Repository
public interface ShopRepository extends JpaRepository<Shop,Long> {
}
