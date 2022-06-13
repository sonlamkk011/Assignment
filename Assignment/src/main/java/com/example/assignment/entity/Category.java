package com.example.assignment.entity;

import com.example.assignment.SQLContans.Validate;
import com.example.assignment.entity.base.BaseEntity;
import com.example.assignment.entity.entityEnum.CategoryStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Category extends BaseEntity {
    private int id;
    private String name;
    private int parentId;
    private CategoryStatus status;
    private String slug;
    private HashMap<String, String> errors;

    public Category() {
        errors = new HashMap<>();
    }

    public Category(int id, String name, int parentId, CategoryStatus status, String slug, HashMap<String, String> errors) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.slug = slug;
    }

    public Category(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, int id, String name, int parentId, CategoryStatus status, String slug, HashMap<String, String> errors) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy);
        this.id = id;
        this.name = name;
        this.status = status;
        this.slug = slug;
    }

    public Category(String name, CategoryStatus status, String slug) {
        this.name = name;
        this.status = status;
        this.slug = slug;
        errors = new HashMap<>();
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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public CategoryStatus getStatus() {
        return status;
    }

    public void setStatus(CategoryStatus status) {
        this.status = status;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public static final class CategoryBuilder {
        public LocalDateTime createdAt;
        public LocalDateTime updatedAt;
        public LocalDateTime deletedAt;
        public int createdBy;
        public int updatedBy;
        public int deletedBy;
        private int id;
        private String name;
        private int parentId;
        private CategoryStatus status;
        private String slug;
        private HashMap<String, String> errors;

        private CategoryBuilder() {
            this.name = "";
            this.status = CategoryStatus.ACTIVE;
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
            this.createdBy = 1;
            this.updatedBy = 1;
        }

        public static CategoryBuilder aCategory() {
            return new CategoryBuilder();
        }

        public CategoryBuilder id(int id) {
            this.id = id;
            return this;
        }

        public CategoryBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CategoryBuilder parentId(int parentId) {
            this.parentId = parentId;
            return this;
        }

        public CategoryBuilder status(CategoryStatus status) {
            this.status = status;
            return this;
        }

        public CategoryBuilder slug(String slug) {
            this.slug = slug;
            return this;
        }

        public CategoryBuilder errors(HashMap<String, String> errors) {
            this.errors = errors;
            return this;
        }

        public CategoryBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CategoryBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public CategoryBuilder deletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public CategoryBuilder createdBy(int createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public CategoryBuilder updatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public CategoryBuilder deletedBy(int deletedBy) {
            this.deletedBy = deletedBy;
            return this;
        }

        public Category build() {
            Category category = new Category();
            category.setId(id);
            category.setName(name);
            category.setParentId(parentId);
            category.setStatus(status);
            category.setSlug(slug);
            category.setErrors(errors);
            category.setCreatedAt(createdAt);
            category.setUpdatedAt(updatedAt);
            category.setDeletedAt(deletedAt);
            category.setCreatedBy(createdBy);
            category.setUpdatedBy(updatedBy);
            category.setDeletedBy(deletedBy);
            return category;
        }

        public boolean isValid() {
            this.checkValid();
            return this.errors.size() == 0;
        }

        public void checkValid() {
            if(name == "" || name == null) {
                errors.put(Validate.CATEGORY_ERROR_KEY_NAME, Validate.CATEGORY_ERROR_MESSAGE_NAME_REQUIRED);
            }
            if(status == null) {
                errors.put(Validate.CATEGORY_ERROR_KEY_STATUS, Validate.CATEGORY_ERROR_MESSAGE_STATUS_REQUIRED);
            }
        }
    }
}
