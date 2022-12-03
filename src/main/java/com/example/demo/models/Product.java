package com.example.demo.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
public class Product {
    public Product(String names, Date dr, Boolean online, Double cent,
                   int quantity, List<Shop> shops, Subcategories subcategories) {
        this.names = names;
        this.dr = dr;
        this.online = online;
        this.cent = cent;
        this.quantity = quantity;
        this.shops = shops;
        this.subcategories = subcategories;
    }

    public Product() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min=2, max = 200, message = "ФИО не может быть короче двух и длиннее двухсот символов.")
    private String names;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past
    private Date dr;
    @NotNull
    @Column(nullable = false)
    private Boolean online;
    @Min(value = 0, message = "Цена не может быть отрицательной")
    @NotNull(message = "Поле не может быть пустым")
    private Double cent;
    @NotNull(message = "Поле не может быть пустым")
    @Min(value = 0, message = "Количество товара не может быть отрицательным")
    private int quantity;

    @ManyToMany
    @JoinTable(name="shop_product",
            joinColumns=@JoinColumn(name="product_id"),
            inverseJoinColumns=@JoinColumn(name="shop_id"))
    private List<Shop> shops;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="subcategories_id")
    private Subcategories subcategories;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Date getDr() {
        return dr;
    }

    public void setDr(Date dr) {
        this.dr = dr;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Double getCent() {
        return cent;
    }

    public void setCent(Double cent) {
        this.cent = cent;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public Subcategories getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Subcategories subcategories) {
        this.subcategories = subcategories;
    }
}

