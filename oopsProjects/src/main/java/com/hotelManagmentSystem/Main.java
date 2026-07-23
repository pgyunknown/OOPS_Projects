package com.hotelManagmentSystem;

import com.hotelManagmentSystem.connection.DBConnection;

import javax.xml.transform.Source;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.time.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        DBConnection db = new DBConnection();
        Connection con=db.getConnection();
        RoomsDAO room1= new RoomsDAO(con);
        ReservationDAO reservation1= new ReservationDAO(con);

        boolean running = true;

        while (running) {

            System.out.println("\n========== HOTEL MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Room");
            System.out.println("2. View Rooms");
            System.out.println("3. Book Room");
            System.out.println("4. View Reservations");
            System.out.println("5. Cancel Reservation");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Room Number: ");
                    int roomNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Room Type: ");
                    String roomType = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    Rooms room = new Rooms(roomNumber, roomType, true, price);

                    room1.addRoom(room);

                    break;

                case 2:
                    room1.veiwRoom();
                    break;

                case 3:
                    System.out.print("Enter Room ID: ");
                    int roomId = sc.nextInt();
                    sc.nextLine(); // Clear the leftover newline character

                    // 2. Guest Name (VARCHAR/String)
                    System.out.print("Enter Guest Name: ");
                    String guestName = sc.nextLine();

                    // 3. Phone Number (VARCHAR/String)
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = sc.nextLine();

                    // 4. Government ID (TEXT/String)
                    System.out.print("Enter Government ID / Passport Number: ");
                    String govId = sc.nextLine();

                    // 5. Check-In Date (DATE -> LocalDate)
                    System.out.print("Enter Check-In Date (YYYY-MM-DD) [or press Enter for Today]: ");
                    String checkInInput = sc.nextLine();
                    LocalDate checkIn;
                    if (checkInInput.trim().isEmpty()) {
                        checkIn = LocalDate.now(); // Default to today's date
                    } else {
                        checkIn = LocalDate.parse(checkInInput);
                    }

                    // 6. Check-Out Date (DATE -> LocalDate)
                    System.out.print("Enter Check-Out Date (YYYY-MM-DD): ");
                    String checkOutInput = sc.nextLine();
                    LocalDate checkOut = LocalDate.parse(checkOutInput);

                    Reservation reservation= new Reservation(roomId,guestName,phoneNumber,govId,checkIn,checkOut);
                    reservation1.addReservation(reservation);

                    break;

                case 4:
                    reservation1.veiwReservation();
                    break;

                case 5:
                    System.out.println("Cancel Reservation Selected");
                    System.out.println("Enter the Reservation Id to cancel the reservation");
                    reservation1.cancelReservation(sc.nextInt(),sc.nextInt());
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice. Please try again.");
            }
        }

        sc.close();
    }
}