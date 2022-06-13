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

public class UpdateCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    @Override
    public void init() throws ServletException {
        categoryModel = new MySQLCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") == null) {
            req.getRequestDispatcher("/client/View/components/error.jsp").forward(req, resp);
            return;
        }
        int categoryId = Integer.parseInt(req.getParameter("id"));
        Category category = categoryModel.findById(categoryId);
        if (category == null) {
            req.getRequestDispatcher("/client/View/components/error.jsp").forward(req, resp);
            return;
        }
        List<Category> categoryList = categoryModel.findAll();
        req.setAttribute("categoryList", categoryList);
        req.setAttribute("category", category);
        System.out.println("Hello");
        req.getRequestDispatcher("/client/View/Category/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        if (categoryModel.findById(id) == null) {
            req.getRequestDispatcher("/admin/pages/errors/404.jsp").forward(req, resp);
            return;
        }
        String name = req.getParameter("name");
        int status = Integer.parseInt(req.getParameter("status"));
        int parentId = Integer.parseInt(req.getParameter("parentId"));
        Category category = Category.CategoryBuilder.aCategory()
                .name(name)
                .status(CategoryStatus.of(status))
                .parentId(parentId)
                .build();
//        if (category.isValid()) {
//            if (categoryModel.update(id, category)) {
//            } else {
//            }
//            resp.sendRedirect("/assignment_wcd/category");
//            return;
//        }
        req.setAttribute("category", category);
        req.setAttribute("errors", category.getErrors());
        List<Category> categoryList = categoryModel.findAll();
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("/client/View/Category/create.jsp").forward(req, resp);
    }
}
