package ru.alexdstart.shopmobilesservicerest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexdstart.shopmobilesservicerest.entity.Phone;
import ru.alexdstart.shopmobilesservicerest.service.PhoneService;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {
    private PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }
    @PostMapping("/new")
    public ResponseEntity<Phone> addPhone(@RequestBody Phone phone) {
       return ResponseEntity.ok().body(phoneService.addPhone(phone));
    }


    @PatchMapping
    public ResponseEntity<Phone> updatePhone(@RequestBody Phone phone) {
        return ResponseEntity.ok().body(phoneService.updatePhone(phone));
    }
}
