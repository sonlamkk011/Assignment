package com.example.assignment.controller.food;

import com.example.assignment.entity.CategoryFood;
import com.example.assignment.entity.entityEnum.CategoryFoodStatus;
import com.example.assignment.model.CategoryFoodModel;
import com.example.assignment.model.MyCategoryFoodModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteFoodServlet extends HttpServlet {

    private CategoryFoodModel categoryFoodModel;

    @Override
    public void init() throws ServletException {
        categoryFoodModel = new MyCategoryFoodModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") == null || req.getParameter("id").length() == 0) {
            req.getRequestDispatcher("/client/View/components/error.jsp").forward(req, resp);
            return;
        }
        int id = Integer.parseInt(req.getParameter("id"));
        CategoryFood food = categoryFoodModel.findById(id);
        if (food == null) {
            req.getRequestDispatcher("/client/View/components/error.jsp").forward(req, resp);
            return;
        }

        food.setStatus(CategoryFoodStatus.DELETED);
        try {
            if (categoryFoodModel.update(id, food)) {

            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/assignment_wcd/food");
    }
}


