package ru.alexdstart.shopmobilesservicerest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String model;
    private int price;
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "id_phone")
    private Shop shop;
}
