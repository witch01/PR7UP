package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Subcategories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Subcategories(String names, Categories categories) {
        this.names = names;
        this.categories = categories;
    }
    public Subcategories() {
    }

    private String names;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Categories categories;

    @OneToOne(optional = true, mappedBy = "subcategories")
    private Product product;

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

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
