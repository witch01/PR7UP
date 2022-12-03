package com.example.demo.repo;

import com.example.demo.models.Employee;
import com.example.demo.models.Subcategories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubcategoriesRepository extends CrudRepository<Subcategories, Long> {

    Subcategories findByNames(String names);



}