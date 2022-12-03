package com.example.demo.repo;

import com.example.demo.models.Product;
import com.example.demo.models.Shop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShopRepository
    extends CrudRepository<Shop, Long>

    {

        List<Shop> findByAdressContains(String adress);

        List<Shop> findByAdress(String adress);

    }

