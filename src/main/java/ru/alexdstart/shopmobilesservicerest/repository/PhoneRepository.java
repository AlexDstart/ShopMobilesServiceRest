package ru.alexdstart.shopmobilesservicerest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.alexdstart.shopmobilesservicerest.entity.Phone;

import java.util.List;


@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    Phone save(Phone phone);

    @Query(value = "SELECT * FROM phones WHERE id_shop = :id_shop",nativeQuery = true)
    List<Phone> findByShop(@Param("id_shop") Long id_shop);



}
