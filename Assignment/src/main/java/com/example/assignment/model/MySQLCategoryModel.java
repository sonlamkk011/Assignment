package com.example.assignment.model;

import com.example.assignment.SQLContans.MySQLContans;
import com.example.assignment.entity.Category;
import com.example.assignment.entity.entityEnum.CategoryStatus;
import com.example.assignment.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoryModel implements CategoryModel {
    public MySQLCategoryModel() {
        super();
    }

    @Override
    public boolean create(Category category) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MySQLContans.CATEGORY_INSERT);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2, category.getParentId());
            preparedStatement.setString(3, category.getCreatedAt().toString());
            preparedStatement.setString(4, category.getUpdatedAt().toString());
            preparedStatement.setInt(5, category.getCreatedBy());
            preparedStatement.setInt(6, category.getUpdatedBy());
            preparedStatement.setInt(7, category.getStatus().getValue());
            preparedStatement.setString(8, category.getSlug());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Category category) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MySQLContans.CATEGORY_UPDATE);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2, category.getParentId());
            preparedStatement.setString(3, category.getCreatedAt().toString());
            preparedStatement.setString(4, category.getUpdatedAt().toString());
            if (category.getDeletedAt() != null) {
                preparedStatement.setString(5, category.getDeletedAt().toString());
            } else {
                preparedStatement.setString(5, null);
            }
            preparedStatement.setInt(6, category.getCreatedBy());
            preparedStatement.setInt(7, category.getUpdatedBy());
            preparedStatement.setInt(8, category.getDeletedBy());
            preparedStatement.setInt(9, category.getStatus().getValue());
            preparedStatement.setString(10, category.getSlug());
            preparedStatement.setInt(11, id);
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
            PreparedStatement preparedStatement = connection.prepareStatement(MySQLContans.CATEGORY_DELETE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public Category findById(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MySQLContans.CATEGORY_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, CategoryStatus.ACTIVE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category findBySlug(String slug) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MySQLContans.CATEGORY_FIND_BY_SLUG);
            preparedStatement.setInt(1, CategoryStatus.ACTIVE.getValue());
            preparedStatement.setString(2, slug);
            ResultSet rs = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MySQLContans.CATEGORY_FIND_ALL);
            preparedStatement.setInt(1, CategoryStatus.ACTIVE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
