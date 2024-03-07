package com.itshaala.controller;

import com.itshaala.model.Expense;
import com.itshaala.service.ExpenseService;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import lombok.SneakyThrows;

import java.io.PrintWriter;

@WebServlet("/GetExpence")
public class GetExpenseById extends GenericServlet {
    ExpenseService expenseService = new ExpenseService();
    @SneakyThrows
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) {

                int id = Integer.parseInt(servletRequest.getParameter("id"));
                Expense expense = expenseService.getExpenseById(id);

                PrintWriter writer = servletResponse.getWriter();
                writer.println("<html>");
                writer.println("<head><title>Show Expense</title></head>");
                writer.println("<body>");

                if (expense != null) {
                    // Display the expense data on the HTML page
                    writer.println("<div>");
                    writer.println("<p>ID: " + expense.getId() + "</p>");
                    writer.println("<p>Title: " + expense.getTitle() + "</p>");
                    writer.println("<p>Amount: " + expense.getAmount() + "</p>");
                    writer.println("<p>Note: " + expense.getNote() + "</p>");
                    writer.println("<p>Date: " + expense.getDate() + "</p>");
                    writer.println("<p>Time: " + expense.getTime() + "</p>");
                    writer.println("<p>Payment Mode: " + expense.getPayment_mode() + "</p>");
                    writer.println("</div>");
                } else {
                    writer.println("<div>Expense not found for ID: " + id + "</div>");
                }

                writer.println("</body>");
                writer.println("</html>");

        }


}
