package com.itshaala.service;

import com.itshaala.dao.ExpenseDao;
import com.itshaala.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
    ExpenseDao expenseDao = new ExpenseDao();
    public void addExpense(Expense expense){
        expenseDao.addExpense(expense);
    }

    public List<Expense> getAllExpense (){

        return expenseDao.getAllExpense();
    }

    public void getExpenseById (int id){
    expenseDao.getExpenseById(id);
    }
}
