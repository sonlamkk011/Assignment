package com.example.assignment.controller.food;

import com.example.assignment.entity.CategoryFood;
import com.example.assignment.model.CategoryFoodModel;
import com.example.assignment.model.MyCategoryFoodModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListFoodServlet extends HttpServlet {
private CategoryFoodModel categoryFoodModel;
    @Override
    public void init() throws ServletException {
        categoryFoodModel = new MyCategoryFoodModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        List<CategoryFood> foodList = categoryFoodModel.findAll();
        req.setAttribute("foodList", foodList);
        req.getRequestDispatcher("/client/View/Food/list.jsp").forward(req, resp);
    }
}
