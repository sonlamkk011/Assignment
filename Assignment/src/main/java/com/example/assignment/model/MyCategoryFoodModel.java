package com.example.assignment.model;

import com.example.assignment.SQLContans.MySQLContans;
import com.example.assignment.entity.CategoryFood;
import com.example.assignment.entity.entityEnum.CategoryFoodStatus;
import com.example.assignment.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyCategoryFoodModel implements CategoryFoodModel {

    public MyCategoryFoodModel() {
        super();
    }

    @Override
    public boolean create(CategoryFood categoryFood) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MySQLContans.FOOD_INSERT);
            preparedStatement.setString(1, categoryFood.getName());
            preparedStatement.setString(2, categoryFood.getCode());
            preparedStatement.setDouble(3, categoryFood.getPrice());
            preparedStatement.setString(4, categoryFood.getThumbnail());
            preparedStatement.setString(5, categoryFood.getDescription());
            preparedStatement.setInt(6, categoryFood.getCategoryId());
            preparedStatement.setString(7, categoryFood.getCreatedAt().toString());
            preparedStatement.setString(8, categoryFood.getUpdatedAt().toString());
            preparedStatement.setInt(9, categoryFood.getCreatedBy());
            preparedStatement.setInt(10, categoryFood.getUpdatedBy());
            preparedStatement.setInt(11, categoryFood.getStatus().getValue());
            preparedStatement.setString(12, categoryFood.getSaleAt() != null ? categoryFood.getSaleAt().toString() : null);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean update(int id, CategoryFood categoryFood) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MySQLContans.FOOD_UPDATE);
            preparedStatement.setString(1, categoryFood.getName());
            preparedStatement.setString(2, categoryFood.getCode());
            preparedStatement.setDouble(3, categoryFood.getPrice());
            preparedStatement.setString(4, categoryFood.getThumbnail());
            preparedStatement.setString(5, categoryFood.getDescription());
            preparedStatement.setInt(6, categoryFood.getCategoryId());
            preparedStatement.setString(7, categoryFood.getCreatedAt().toString());
            preparedStatement.setString(8, categoryFood.getUpdatedAt().toString());
            if (categoryFood.getDeletedAt() != null) {
                preparedStatement.setString(9, categoryFood.getDeletedAt().toString());
            } else {
                preparedStatement.setString(9, null);
            }
            preparedStatement.setInt(10, categoryFood.getCreatedBy());
            preparedStatement.setInt(11, categoryFood.getUpdatedBy());
            preparedStatement.setInt(12, categoryFood.getDeletedBy());
            preparedStatement.setInt(13, categoryFood.getStatus().getValue());
            preparedStatement.setString(14, categoryFood.getSaleAt() != null ? categoryFood.getSaleAt().toString() : null);
            preparedStatement.setInt(15, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MySQLContans.FOOD_DELETE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public CategoryFood findById(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MySQLContans.FOOD_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CategoryFood findByCode(String slug) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MySQLContans.FOOD_FIND_BY_CODE);
            preparedStatement.setString(1, slug);
            ResultSet rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CategoryFood> findAll() {
        List<CategoryFood> categoryFoods = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MySQLContans.FOOD_FIND_ALL);
            preparedStatement.setInt(1, CategoryFoodStatus.ON_SALE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryFoods;
    }
}
