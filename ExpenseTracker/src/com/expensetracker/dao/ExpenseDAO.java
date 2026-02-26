package com.expensetracker.dao;

import java.sql.*;
import java.time.LocalDate;

import com.expensetracker.model.Expense;
import com.expensetracker.util.DBConnection;

public class ExpenseDAO {

    // Add Expense
    public void addExpense(Expense expense) throws SQLException {
        String sql = "INSERT INTO expense(title, category, amount, expense_date) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, expense.getTitle());
            ps.setString(2, expense.getCategory());
            ps.setDouble(3, expense.getAmount());
            ps.setDate(4, Date.valueOf(expense.getDate()));

            ps.executeUpdate();
            System.out.println("Expense added successfully.");
        }
    }

    // View all expenses
    public void showAllExpenses() throws SQLException {
        String sql = "SELECT * FROM expense";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("ID | Title | Category | Amount | Date");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("category") + " | " +
                        rs.getDouble("amount") + " | " +
                        rs.getDate("expense_date")
                );
            }
        }
    }

    // View expense by date
    public void viewByDate(LocalDate date) throws SQLException {
        String sql = "SELECT * FROM expense WHERE expense_date = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(date));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("category") + " | " +
                        rs.getDouble("amount")
                );
            }
        }
    }

    //  Delete expense by ID
    public void deleteExpenseById(int id) throws SQLException {
        String sql = "DELETE FROM expense WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Expense deleted successfully.");
            } else {
                System.out.println("Expense ID not found.");
            }
        }
    }
}

















/* 
 *   LocalDate (2024-12-31)
        ↓
    java.sql.Date (2024-12-31)
        ↓
    Database DATE column
*/
