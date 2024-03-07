package com.itshaala.controller;

import com.itshaala.model.Expense;
import com.itshaala.service.ExpenseService;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/list")
public class GetAllExpensesController extends GenericServlet {

    ExpenseService expenseService = new ExpenseService();
    @SneakyThrows
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) {

                List<Expense> allExpenses = expenseService.getAllExpense();

                PrintWriter writer = servletResponse.getWriter();
                writer.println("<html>");
                writer.println("<head><title>All Expenses</title></head>");
                writer.println("<body>");

                if (!allExpenses.isEmpty()) {
                    writer.println("<h1>All Expenses</h1>");
                    writer.println("<table border='1'>");
                    writer.println("<tr>");
                    writer.println("<th>ID</th>");
                    writer.println("<th>Title</th>");
                    writer.println("<th>Amount</th>");
                    writer.println("<th>Note</th>");
                    writer.println("<th>Date</th>");
                    writer.println("<th>Time</th>");
                    writer.println("<th>Payment Mode</th>");
                    writer.println("</tr>");

                    for (Expense expense : allExpenses) {
                        writer.println("<tr>");
                        writer.println("<td>" + expense.getId() + "</td>");
                        writer.println("<td>" + expense.getTitle() + "</td>");
                        writer.println("<td>" + expense.getAmount() + "</td>");
                        writer.println("<td>" + expense.getNote() + "</td>");
                        writer.println("<td>" + expense.getDate() + "</td>");
                        writer.println("<td>" + expense.getTime() + "</td>");
                        writer.println("<td>" + expense.getPayment_mode() + "</td>");
                        writer.println("</tr>");
                    }

                    writer.println("</table>");
                } else {
                    writer.println("<div>No expenses found.</div>");
                }

                writer.println("</body>");
                writer.println("</html>");



    }
}
