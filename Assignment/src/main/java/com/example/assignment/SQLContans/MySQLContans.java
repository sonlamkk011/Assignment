package com.example.assignment.SQLContans;

public class MySQLContans {
    //    food
    public static final String FOOD_INSERT = "INSERT INTO food (name, code, price, thumbnail, description, categoryId, createdAt, updatedAt, createdBy, updatedBy, status, saleAt) " + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String FOOD_UPDATE = "UPDATE food SET name = ?, code = ?, price = ?, thumbnail = ?, description = ?, categoryId = ?," + "createdAt = ?, updatedAt = ?, deletedAt = ?, createdBy = ?, updatedBy = ?, deletedBy = ?, status = ?, saleAt = ? WHERE id = ?;";
    public static final String FOOD_DELETE = "DELETE FROM food WHERE id = ?;";
    public static final String FOOD_STATUS_UPDATE = "UPDATE food SET status = ? WHERE id = ?";
    public static final String FOOD_FIND_BY_ID = "SELECT * FROM food WHERE id = ?;";
    public static final String FOOD_FIND_ALL = "SELECT * FROM food WHERE status = ? ORDER BY createdAt DESC;";
    public static final String FOOD_FIND_BY_CODE = "SELECT * FROM food WHERE code = ?;";
//    end of food

    //category
    public static final String CATEGORY_INSERT = "INSERT INTO category (name, parentId, createdAt, updatedAt, createdBy, updatedBy, status, slug) " + " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String CATEGORY_UPDATE = "UPDATE category SET name = ?, parentId = ?," +
            "createdAt = ?, updatedAt = ?, deletedAt = ?, createdBy = ?, updatedBy = ?, deletedBy = ?, status = ?, slug = ? WHERE id = ?;";
    public static final String CATEGORY_DELETE = "DELETE FROM category WHERE id = ?;";
    public static final String CATEGORY_UPDATE_STATUS = "UPDATE category SET status = ? WHERE id = ?";
    public static final String CATEGORY_FIND_BY_ID = "SELECT * FROM category WHERE id = ? AND status = ?;";
    public static final String CATEGORY_FIND_ALL = "SELECT * FROM category WHERE status = ? ORDER BY createdAt DESC;";
    public static final String CATEGORY_FIND_BY_SLUG = "SELECT * FROM category WHERE status = ? AND slug = ?;";


//    end of category
}
