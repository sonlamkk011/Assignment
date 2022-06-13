package com.example.assignment.controller.category;

import com.example.assignment.entity.Category;
import com.example.assignment.model.CategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        List<Category> categoryList = categoryModel.findAll();
        if (categoryList == null) {
            categoryList = new ArrayList<>();
        }
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("/client/View/Category/list.jsp").forward(req, resp);
    }
}
