package com.example.assignment.entity;

import com.example.assignment.SQLContans.Validate;
import com.example.assignment.entity.base.BaseEntity;
import com.example.assignment.entity.entityEnum.CategoryFoodStatus;
import com.example.assignment.model.CategoryModel;
import com.example.assignment.model.MySQLCategoryModel;

import java.time.LocalDateTime;
import java.util.HashMap;

public class CategoryFood extends BaseEntity {
    private int id;
    private String name;
    private String code;
    private int categoryId;
    private String description;
    private String thumbnail;
    private double price;
    private CategoryFoodStatus status;
    private HashMap<String, String> errors;
    private CategoryModel categoryModel;
    private LocalDateTime saleAt;

    public CategoryFood() {
        errors = new HashMap<>();
        categoryModel = new MySQLCategoryModel();
    }

    public CategoryFood(int id, String name, String code, int categoryId, String description, String thumbnail, double price, CategoryFoodStatus status, HashMap<String, String> errors, CategoryModel categoryModel, LocalDateTime saleAt) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.categoryId = categoryId;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.status = status;
        this.errors = errors;
        this.categoryModel = categoryModel;
        this.saleAt = saleAt;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryFoodStatus getStatus() {
        return status;
    }

    public void setStatus(CategoryFoodStatus status) {
        this.status = status;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    public LocalDateTime getSaleAt() {
        return saleAt;
    }

    public void setSaleAt(LocalDateTime saleAt) {
        this.saleAt = saleAt;
    }

    public static final class CategoryFoodBuilder {
        public LocalDateTime createdAt;
        public LocalDateTime updatedAt;
        public LocalDateTime deletedAt;
        public int createdBy;
        public int updatedBy;
        public int deletedBy;
        private int id;
        private String name;
        private String code;
        private int categoryId;
        private String description;
        private String thumbnail;
        private double price;
        private CategoryFoodStatus status;
        private HashMap<String, String> errors;
        private CategoryModel categoryModel;
        private LocalDateTime saleAt;

        private CategoryFoodBuilder() {
            this.name = "";
            this.code = "";
            this.description = "";
            this.thumbnail = "";
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
            this.saleAt = LocalDateTime.now();
            this.status = CategoryFoodStatus.ON_SALE;
        }

        public static CategoryFoodBuilder aCategoryFood() {
            return new CategoryFoodBuilder();
        }

        public CategoryFoodBuilder id(int id) {
            this.id = id;
            return this;
        }

        public CategoryFoodBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CategoryFoodBuilder code(String code) {
            this.code = code;
            return this;
        }

        public CategoryFoodBuilder categoryId(int categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public CategoryFoodBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CategoryFoodBuilder thumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public CategoryFoodBuilder price(double price) {
            this.price = price;
            return this;
        }

        public CategoryFoodBuilder status(CategoryFoodStatus status) {
            this.status = status;
            return this;
        }

        public CategoryFoodBuilder errors(HashMap<String, String> errors) {
            this.errors = errors;
            return this;
        }

        public CategoryFoodBuilder categoryModel(CategoryModel categoryModel) {
            this.categoryModel = categoryModel;
            return this;
        }

        public CategoryFoodBuilder saleAt(LocalDateTime saleAt) {
            this.saleAt = saleAt;
            return this;
        }

        public CategoryFoodBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CategoryFoodBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public CategoryFoodBuilder deletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public CategoryFoodBuilder createdBy(int createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public CategoryFoodBuilder updatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public CategoryFoodBuilder deletedBy(int deletedBy) {
            this.deletedBy = deletedBy;
            return this;
        }

        public CategoryFood build() {
            CategoryFood categoryFood = new CategoryFood();
            categoryFood.setId(id);
            categoryFood.setName(name);
            categoryFood.setCode(code);
            categoryFood.setCategoryId(categoryId);
            categoryFood.setDescription(description);
            categoryFood.setThumbnail(thumbnail);
            categoryFood.setPrice(price);
            categoryFood.setStatus(status);
            categoryFood.setErrors(errors);
            categoryFood.setCategoryModel(categoryModel);
            categoryFood.setSaleAt(saleAt);
            categoryFood.setCreatedAt(createdAt);
            categoryFood.setUpdatedAt(updatedAt);
            categoryFood.setDeletedAt(deletedAt);
            categoryFood.setCreatedBy(createdBy);
            categoryFood.setUpdatedBy(updatedBy);
            categoryFood.setDeletedBy(deletedBy);
            return categoryFood;
        }

        public boolean isValid() {
            this.checkValid();
            return this.errors.size() == 0;
        }

        public void checkValid() {
            if (name.length() <= 7 || name == null) {
                errors.put(Validate.FOOD_ERROR_KEY_NAME, "Name cannot be empty");
            }
            if (categoryId == 0) {
                errors.put(Validate.FOOD_ERROR_KEY_CATEGORY_ID, "CategoryId cannot be empty");
            }
            if (price == 0) {
                errors.put(Validate.FOOD_ERROR_KEY_PRICE, "Price must be greater than 0");
            }
            if (thumbnail.length() == 0 || thumbnail == null) {
                errors.put(Validate.FOOD_ERROR_KEY_THUMBNAIL, "Thumbnail cannot be empty");
            }
            if (description.length() == 0 || description == null) {
                errors.put(Validate.FOOD_ERROR_KEY_DESCRIPTION, "Description cannot be empty");
            }
            if (code.length() == 0 || code == null) {
                errors.put(Validate.FOOD_ERROR_KEY_CODE, "Code cannot be empty");
            }
        }
    }
}
