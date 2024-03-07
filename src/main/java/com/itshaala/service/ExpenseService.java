package com.itshaala.service;

import com.itshaala.dao.ExpenseDao;
import com.itshaala.model.Expense;

import java.util.List;

public class ExpenseService {
    ExpenseDao expenseDao = new ExpenseDao();
    public void addExpense(Expense expense){
        expenseDao.addExpense(expense);
    }

    public void deleteExpence(int id){
        expenseDao.deleteExpense(id);

    }

    public List<Expense> getAllExpense (){

        return expenseDao.getAllExpense();
    }

    public Expense getExpenseById (int id){
    return expenseDao.getExpenseById(id);

    }
}
