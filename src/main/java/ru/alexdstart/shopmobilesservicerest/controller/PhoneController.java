package ru.alexdstart.shopmobilesservicerest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexdstart.shopmobilesservicerest.entity.Phone;
import ru.alexdstart.shopmobilesservicerest.service.PhoneService;

import java.util.List;

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
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePhone(@PathVariable Long id) {
        phoneService.deletePhone(id);
        return ResponseEntity.ok().body("Phone with id " + id + " has been deleted successfully.");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Phone> getPhoneById(@PathVariable Long id) {
        Phone phone = phoneService.getPhoneById(id);
        return ResponseEntity.ok(phone);
    }



    @PatchMapping
    public ResponseEntity<Phone> updatePhone(@RequestBody Phone phone) {
        return ResponseEntity.ok().body(phoneService.updatePhone(phone));
    }

    @GetMapping()
    public ResponseEntity<List<Phone>> getPhonesByShopId(@RequestParam Long id_shop) {
        List<Phone> phones = phoneService.getPhonesByShopId(id_shop);
        return ResponseEntity.ok(phones);
    }
}
