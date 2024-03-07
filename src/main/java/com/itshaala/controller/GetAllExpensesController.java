package com.itshaala.controller;

import com.itshaala.model.Expense;
import com.itshaala.service.ExpenseService;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/list")
public class GetAllExpensesController extends GenericServlet {

    ExpenseService expenseService = new ExpenseService();
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        List<Expense> expenseList = expenseService.getAllExpense();
        PrintWriter writer = servletResponse.getWriter();
        writer.println(expenseList);

    }
}
