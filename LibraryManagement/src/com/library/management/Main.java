package com.library.management;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. View All Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. View Transaction History");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine().toLowerCase();

                    library.addBook(new Book(bookId, title));
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Member Name: ");
                    String name = sc.nextLine();

                    library.addmember(new Member(memberId, name));
                    break;

                case 3:
                    library.displayAllBooks();
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int issueBookId = sc.nextInt();
                    System.out.print("Enter Member ID: ");
                    int issueMemberId = sc.nextInt();
                    System.out.print("Enter Transaction ID: ");
                    int issueTxnId = sc.nextInt();

                    library.issueBook(issueBookId, issueMemberId, issueTxnId);
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    int returnBookId = sc.nextInt();
                    System.out.print("Enter Member ID: ");
                    int returnMemberId = sc.nextInt();
                    System.out.print("Enter Transaction ID: ");
                    int returnTxnId = sc.nextInt();

                    library.returnBook(returnBookId, returnMemberId, returnTxnId);
                    break;

                case 6:
                    library.displayTransactions();
                    break;

                case 7:
                    System.out.println("Exiting... Thank you for using LMS!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
