package com.example.assignment.model;

import com.example.assignment.entity.CategoryFood;

import java.util.List;

public interface CategoryFoodModel {
    boolean create(CategoryFood obj);

    boolean update(int id, CategoryFood obj);

    boolean delete(int id);

    CategoryFood findById(int id);

    CategoryFood findByCode(String slug);

    List<CategoryFood> findAll();

}
