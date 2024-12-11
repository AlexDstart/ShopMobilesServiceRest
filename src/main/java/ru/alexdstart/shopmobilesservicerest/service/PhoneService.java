package ru.alexdstart.shopmobilesservicerest.service;

import org.springframework.stereotype.Service;
import ru.alexdstart.shopmobilesservicerest.entity.Phone;
import ru.alexdstart.shopmobilesservicerest.exceptions.PhoneNotFoundException;
import ru.alexdstart.shopmobilesservicerest.repository.PhoneRepository;

import java.util.Optional;

@Service
public class PhoneService {
    private PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;

    }

    public Phone addPhone(Phone phone) {
        return phoneRepository.save(phone);
    }
    public Phone updatePhone(Phone phone) {
        Phone oldPhone = phoneRepository.findById(phone.getId())
                .orElseThrow(()->new PhoneNotFoundException("phone not fount with id:" + phone.getId()));

        if (phone.getPrice() != null){
            oldPhone.setPrice(phone.getPrice());
        }

        if(phone.getSerialNumber() != null){
            oldPhone.setSerialNumber(phone.getSerialNumber());
        }

        if (phone.getShop() != null){
            oldPhone.setShop(phone.getShop());
        }

        return phoneRepository.save(oldPhone);
    }
}
