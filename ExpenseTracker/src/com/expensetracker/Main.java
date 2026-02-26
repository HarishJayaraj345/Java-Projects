package com.expensetracker;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import com.expensetracker.dao.ExpenseDAO;
import com.expensetracker.model.Expense;

public class Main {

    public static void main(String[] args) {

        ExpenseDAO dao = new ExpenseDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("------ Expense Tracker -------");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Expense by Date");
            System.out.println("4. Delete Expense by ID");
            System.out.println("5. Exit");
            System.out.print("Choose your option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter category: ");
                        String category = sc.nextLine();

                        System.out.print("Enter amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Enter date (yyyy-mm-dd): ");
                        LocalDate date = LocalDate.parse(sc.nextLine());

                        dao.addExpense(new Expense(title, category, amount, date));
                        break;

                    case 2:
                        dao.showAllExpenses();
                        break;

                    case 3:
                        System.out.print("Enter date (yyyy-mm-dd): ");
                        LocalDate searchDate = LocalDate.parse(sc.nextLine());
                        dao.viewByDate(searchDate);
                        break;

                    case 4:
                        System.out.print("Enter Expense ID to delete: ");
                        int id = sc.nextInt();
                        dao.deleteExpenseById(id);
                        break;

                    case 5:
                        System.out.println("Thank you...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}