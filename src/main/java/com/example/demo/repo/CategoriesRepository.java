package com.example.demo.repo;

import com.example.demo.models.Categories;
import com.example.demo.models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriesRepository extends CrudRepository<Categories, Long> {



    Categories findByName(String name);

}