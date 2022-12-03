package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Shop {

    public Shop() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min=2, max = 500, message = "Адрес не может быть короче двух и длиннее пятисот символов.")
    private String adress;
    @ManyToMany
    @JoinTable (name="shop_product",
            joinColumns=@JoinColumn (name="shop_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
