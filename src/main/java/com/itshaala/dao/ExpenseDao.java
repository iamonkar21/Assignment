package com.itshaala.dao;

import com.itshaala.configuration.ConnectionUtil;
import com.itshaala.model.Expense;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDao {
    @SneakyThrows
    public void addExpense(Expense expense) {
        String query = "insert into expense(title, amount, note, date, time, payment_mode) values(?,?,?,?,?,?)";
        Connection connection = ConnectionUtil.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,expense.getTitle());
            preparedStatement.setDouble(2,expense.getAmount());
            preparedStatement.setString(3,expense.getNote());
            preparedStatement.setDate(4,expense.getDate());
            preparedStatement.setTime(5,expense.getTime());
            preparedStatement.setString(6,expense.getPaymentMode());

            preparedStatement.executeUpdate();
            System.out.println("Expense added successfully");
    }

    @SneakyThrows
    public List<Expense> getAllExpense (){
        List <Expense> expenseList = new ArrayList<>();

        String query = "SELECT * FROM expense";
        Connection connection = ConnectionUtil.getConnection();


        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            Expense expense = Expense.builder()
                    .title(resultSet.getString("title"))
                    .amount(resultSet.getDouble("amount"))
                    .note(resultSet.getString("note"))
                    .date(Date.valueOf(resultSet.getString("date")))
                    .time(Time.valueOf(resultSet.getString("time")))
                    .paymentMode(resultSet.getString("payment mode"))
                    .build();
            expenseList.add(expense);
        }

        return expenseList;
    }

    @SneakyThrows
    public void getExpenseById (int id){
        String query = "select * from expense where id=?";
        Connection connection = ConnectionUtil.getConnection();
        Expense expense = new Expense();

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //expense(resultSet.getInt("id"));
                expense.setTitle(resultSet.getString("title"));
                expense.setAmount(resultSet.getDouble("amount"));
                expense.setNote(resultSet.getString("note"));
                expense.setDate(resultSet.getDate("date"));
                expense.setTime(resultSet.getTime("time"));
                expense.setPaymentMode(resultSet.getString("payment_mode"));
            }

    }

}
