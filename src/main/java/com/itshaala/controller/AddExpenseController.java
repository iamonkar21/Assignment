package com.itshaala.controller;

import com.itshaala.model.Expense;
import com.itshaala.service.ExpenseService;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebServlet("/expense/add")
public class addExpenseController extends GenericServlet {

    ExpenseService expenseService = new ExpenseService();
    @Override

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {

        String Title =servletRequest.getParameter("title");
        double Amount = Integer.parseInt(servletRequest.getParameter("amount"));
        String Note = servletRequest.getParameter("note");
        LocalDateTime time = LocalDateTime.parse(servletRequest.getParameter("time"));

        Expense expense = Expense.builder()
                .title(Title)
                .amount(Amount)
                .note(Note)
                .time(Time.valueOf(String.valueOf(time)))
                .build();

        expenseService.addExpense(expense);
        PrintWriter writer = servletResponse.getWriter();
        writer.println("Expense Added!!!");
    }
}
