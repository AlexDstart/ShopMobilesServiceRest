package ru.alexdstart.shopmobilesservicerest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexdstart.shopmobilesservicerest.entity.Phone;

import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    Phone save(Phone phone);


}
