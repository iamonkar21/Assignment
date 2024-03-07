package com.itshaala.controller;

import com.itshaala.model.Expense;
import com.itshaala.service.ExpenseService;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@WebServlet("/add")
public class AddExpenseController extends GenericServlet {

    ExpenseService expenseService = new ExpenseService();
    @SneakyThrows
    @Override

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {

        String Title =servletRequest.getParameter("title");
        double Amount = Integer.parseInt(servletRequest.getParameter("amount"));
        String Note = servletRequest.getParameter("note");
        String PaymentMode =servletRequest.getParameter("payment_mode");
      //  LocalDateTime time = LocalDateTime.parse(servletRequest.getParameter("time"));

        Expense expense = Expense.builder()
                .title(Title)
                .amount(Amount)
                .note(Note)
                .payment_mode(PaymentMode)
                .build();

        expenseService.addExpense(expense);
        PrintWriter writer = servletResponse.getWriter();
        writer.println("Expense Added!!!");
    }
}
