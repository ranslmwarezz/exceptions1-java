package application;

import model.entities.Reservation;
import model.exceptions.DomainException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), fmt);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkOut = LocalDate.parse(sc.next(), fmt);

            Reservation rs = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + rs);

            System.out.println();
            System.out.print("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), fmt);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), fmt);

                rs.update(checkIn, checkOut);
                System.out.println("Reservation: " + rs);
            }
                catch (DateTimeParseException e){
                System.out.println("Invalid date format");
            }
                catch(DomainException e){
                 System.out.println("Error in reservation: " + e.getMessage());
                }
                 catch(InputMismatchException e){
                     System.out.println("Invalid room number");
                 }

        sc.close();
    }
}
