package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Categories {
    public Categories() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min=2, max = 80, message = "Слишком короткое или длинное название категории")
    private String name;
    @OneToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    private Collection<Subcategories> tenants;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Subcategories> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Subcategories> tenants) {
        this.tenants = tenants;
    }
}
