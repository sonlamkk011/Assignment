package com.example.assignment.controller.food;

import com.example.assignment.entity.Category;
import com.example.assignment.entity.CategoryFood;
import com.example.assignment.entity.entityEnum.CategoryFoodStatus;
import com.example.assignment.model.CategoryFoodModel;
import com.example.assignment.model.CategoryModel;
import com.example.assignment.model.MyCategoryFoodModel;
import com.example.assignment.model.MySQLCategoryModel;
import com.example.assignment.util.FormatHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class CreateFoodServlet extends HttpServlet {
    private CategoryFoodModel categoryFoodModel;
    private CategoryModel categoryModel;

    @Override
    public void init() throws ServletException {
        categoryModel = new MySQLCategoryModel();
        categoryFoodModel = new MyCategoryFoodModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = categoryModel.findAll();
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("/client/View/Food/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String name = req.getParameter("name");
        String thumbnail = req.getParameter("thumbnail");
        String code = req.getParameter("code");
        String description = req.getParameter("description");
        LocalDateTime saleAt = FormatHelper.convertStringToLocalDateTime(req.getParameter("saleAt") + " 00:00", "yyyy-MM-dd HH:mm");
        double price = 0;
        if (req.getParameter("price") != null) {
            price = Double.parseDouble(req.getParameter("price"));
        }
        CategoryFoodStatus status = CategoryFoodStatus.of(Integer.parseInt(req.getParameter("status")));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        CategoryFood categoryFood = CategoryFood.CategoryFoodBuilder.aCategoryFood()
                .name(name)
                .code(code)
                .thumbnail(thumbnail)
                .price(price)
                .status(status)
                .categoryId(categoryId)
                .description(description)
                .saleAt(saleAt)
                .build();
        try {
//            if (categoryFood.isValid()) {
//                if (categoryFoodModel.create(categoryFood)) {
//
//                } else {
//                    throw new Exception();
//                }
//            } else {
//                List<Category> categoryList = categoryModel.findAll();
//                req.setAttribute("categoryList", categoryList);
//                req.setAttribute("food", categoryFood);
//                req.setAttribute("errors", categoryFood.getErrors());
//                req.getRequestDispatcher("/client/View/").forward(req, resp);
//                return;
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/assignment_wcd/food");
    }
}

