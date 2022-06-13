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

public class DeleteCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    @Override
    public void init() throws ServletException {
        categoryModel = new MySQLCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") == null) {
            req.getRequestDispatcher("/admin/pages/errors/404.jsp").forward(req, resp);
            return;
        }
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryModel.findById(id);
        if (category == null) {
            req.getRequestDispatcher("/admin/pages/errors/404.jsp").forward(req, resp);
            return;
        }
        category.setStatus(CategoryStatus.DELETED);
        resp.sendRedirect("/assignment_wcd/category");
    }

}
