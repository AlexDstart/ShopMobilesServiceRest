package ru.alexdstart.shopmobilesservicerest.service;

import org.springframework.stereotype.Service;
import ru.alexdstart.shopmobilesservicerest.entity.Phone;
import ru.alexdstart.shopmobilesservicerest.entity.Shop;
import ru.alexdstart.shopmobilesservicerest.exceptions.PhoneNotFoundException;
import ru.alexdstart.shopmobilesservicerest.repository.PhoneRepository;
import ru.alexdstart.shopmobilesservicerest.repository.ShopRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {
    private PhoneRepository phoneRepository;
    private ShopRepository shopRepository;

    public PhoneService(PhoneRepository phoneRepository, ShopRepository shopRepository) {
        this.phoneRepository = phoneRepository;
        this.shopRepository = shopRepository;
    }


    public Phone getPhoneById(Long phoneId) {
        return phoneRepository.findById(phoneId)
                .orElseThrow(() -> new PhoneNotFoundException("Phone not found with id: " + phoneId));
    }

    public Phone addPhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    public void deletePhone(Long phoneId) {
        if (!phoneRepository.existsById(phoneId)) {
            throw new PhoneNotFoundException("Phone not found with id: " + phoneId);
        }
        phoneRepository.deleteById(phoneId);
    }

    public Phone updatePhone(Phone phone) {
        Phone oldPhone = phoneRepository.findById(phone.getId())
                .orElseThrow(() -> new RuntimeException("Phone not found with id: " + phone.getId()));

        if (phone.getModel() != null) {
            oldPhone.setModel(phone.getModel());
        }

        if (phone.getPrice() != null) {
            oldPhone.setPrice(phone.getPrice());
        }

        if (phone.getSerialNumber() != null) {
            oldPhone.setSerialNumber(phone.getSerialNumber());
        }

        if (phone.getShop() != null) {
            Long shopId = phone.getShop().getId();
            if (shopId != null) {
                Shop shop = shopRepository.findById(shopId)
                        .orElseThrow(() -> new RuntimeException("Shop not found with id: " + shopId));
                oldPhone.setShop(shop);
            } else {
                throw new RuntimeException("Shop ID is null in the provided phone object");
            }
        }



        return phoneRepository.save(oldPhone);
    }

    public List<Phone> getPhonesByShopId(Long idShop) {
        return phoneRepository.findByShop(idShop);

    }
}
