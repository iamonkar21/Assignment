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
            preparedStatement.setString(6,expense.getPayment_mode());

            preparedStatement.executeUpdate();
            System.out.println("Expense added successfully");
    }

    public void deleteExpense(int id) {
        String query = "DELETE FROM b006.expense WHERE id=?";
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Record Deleted from db");
        } catch (SQLException e) {
            System.out.println("issue in compiling the query");
        }
    }

    @SneakyThrows
    public List<Expense> getAllExpense (){
        String query = "SELECT * FROM b006.expense";
        Connection connection = ConnectionUtil.getConnection();
        List<Expense> expenseList = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Expense expense = new Expense();
                expense.setId(resultSet.getInt("Id"));
                expense.setTitle(resultSet.getString("title"));
                expense.setAmount(resultSet.getDouble("amount"));
                expense.setNote(resultSet.getString("note"));
                expense.setDate(resultSet.getDate("date"));
                expense.setTime(resultSet.getTime("time"));
                expense.setPayment_mode(resultSet.getString("payment_mode"));

                expenseList.add(expense);
            }
        return expenseList;
    }

    @SneakyThrows
    public  Expense getExpenseById (int id){
        String query = "select * from b006.expense where id=?";
        Connection connection = ConnectionUtil.getConnection();
        Expense expense = new Expense();

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                expense.setId(resultSet.getInt("id"));
                expense.setTitle(resultSet.getString("title"));
                expense.setAmount(resultSet.getDouble("amount"));
                expense.setNote(resultSet.getString("note"));
                expense.setDate(resultSet.getDate("date"));
                expense.setTime(resultSet.getTime("time"));
                expense.setPayment_mode(resultSet.getString("payment_mode"));
            }
return expense;
    }

}
