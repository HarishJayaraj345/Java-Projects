package com.expensetracker.model;

import java.time.LocalDate;

public class Expense {

    private int id;
    private String title;
    private String category;
    private double amount;
    private LocalDate expense_date;

    // Constructor without id (for insert)
    public Expense(String title, String category, double amount, LocalDate expense_date) {
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.expense_date = expense_date;
    }

    // Constructor with id 
    public Expense(int id, String title, String category, double amount, LocalDate expense_date) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.expense_date = expense_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return expense_date;
    }
}
