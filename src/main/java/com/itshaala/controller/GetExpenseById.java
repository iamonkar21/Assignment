package com.itshaala.controller;

import com.itshaala.service.ExpenseService;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/by-id")
public class GetExpenseById extends GenericServlet {
    ExpenseService expenseService = new ExpenseService();
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) {
        int id =Integer.parseInt(servletRequest.getParameter("id"));
        expenseService.getExpenseById(id);

    }
}
