package com.itshaala.controller;

import com.itshaala.service.ExpenseService;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import lombok.SneakyThrows;

import java.io.IOException;
@WebServlet("/delete")
public class DeleteExpenseByID extends GenericServlet {

    ExpenseService expenseService = new ExpenseService();
    @SneakyThrows
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse){

                // Extract the expense ID from the request parameter
                int id = Integer.parseInt(servletRequest.getParameter("id"));

                // Call the ExpenseService to delete the expense
                expenseService.deleteExpence(id);

                servletResponse.getWriter().println("Expense with ID " + id + " has been deleted successfully.");

        }
}
