package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException{
        this.roomNumber = roomNumber;
        setDates(checkIn, checkOut);
    }

    public long duration(){
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public void update(LocalDate checkIn, LocalDate checkOut) throws DomainException{
        setDates(checkIn, checkOut);
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
    private void setDates(LocalDate checkIn, LocalDate checkOut) throws DomainException{
        LocalDate now = LocalDate.now();
        if(checkIn.isBefore(now) || checkOut.isBefore(now)){
            throw new DomainException("Reservation dates for update must be future dates!");
        }
        if (!checkOut.isAfter(checkIn)){
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    @Override
    public String toString(){
        return "Room "
                + roomNumber
                +", check-in: "
                + checkIn.format(fmt)
                +", check-out: "
                + checkOut.format(fmt)
                + ", "
                + duration()
                + " nights";
    }

}
