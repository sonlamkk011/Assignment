package com.example.assignment.model;

import com.example.assignment.entity.Category;

import java.util.List;

public interface CategoryModel {
    boolean create(Category obj);
    boolean update(int id, Category obj);
    boolean delete(int id);
    Category findById(int id);
    Category findBySlug(String slug);
    List<Category> findAll();
}
