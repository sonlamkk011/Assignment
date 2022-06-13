package com.example.assignment.controller.category;

import com.example.assignment.entity.Category;
import com.example.assignment.entity.entityEnum.CategoryStatus;
import com.example.assignment.model.CategoryModel;
import com.example.assignment.model.MySQLCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CreateCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    @Override
    public void init() throws ServletException {
        categoryModel = new MySQLCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = categoryModel.findAll();
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("/client/View/Category/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");
        String name = req.getParameter("name");
        int status = Integer.parseInt(req.getParameter("status"));
        int parentId = Integer.parseInt(req.getParameter("parentId"));
        List<Category> categoryList = categoryModel.findAll();
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("/admin/pages/category/form.jsp").forward(req, res);
    }
}
