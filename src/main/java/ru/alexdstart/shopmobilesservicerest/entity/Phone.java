package ru.alexdstart.shopmobilesservicerest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long id;
    private String model;
    private Integer price;

    @Column(unique = true)
    private String serialNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_order")
    private Order order;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_shop")
    @JsonIgnore
    private Shop shop;


}
