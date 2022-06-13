package com.example.assignment.controller.food;

import com.example.assignment.entity.Category;
import com.example.assignment.entity.CategoryFood;
import com.example.assignment.model.CategoryFoodModel;
import com.example.assignment.model.CategoryModel;
import com.example.assignment.model.MyCategoryFoodModel;
import com.example.assignment.model.MySQLCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UpdateFoodServlet extends HttpServlet {
    private CategoryFoodModel categoryFoodModel;
    private CategoryModel categoryModel;

    @Override
    public void init() throws ServletException {
        categoryFoodModel = new MyCategoryFoodModel();
        categoryModel = new MySQLCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") == null) {
            req.getRequestDispatcher("/admin/pages/errors/404.jsp").forward(req, resp);
            return;
        }
        int id = Integer.parseInt(req.getParameter("id"));
//        CategoryFood categoryFood = CategoryFood.findById(id);
//        if (categoryFood == null) {
//            req.getRequestDispatcher("/client/View/components/error.jsp").forward(req, resp);
//            return;
//        }
        List<Category> categoryList = categoryModel.findAll();
        req.setAttribute("categoryList", categoryList);
        req.setAttribute("categoryFood", categoryFoodModel);
        req.getRequestDispatcher("/client/View/Food/create.jsp").forward(req, resp);
    }
}

