package com.hotelManagmentSystem;
import java.time.LocalDate;
public class Reservation {
//    private final int reservationId;
    private final int roomId;
    private String guestName;
    private String phoneNumber;
    private String govId;
    private LocalDate checkIn;
    private LocalDate checkOut;

//    public int getReservationId() {
//        return reservationId;
//    }

    public int getRoomId() {
        return roomId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        if(Utility.isNull(guestName)) this.guestName = guestName;
        else System.out.println("Invalid ");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (Utility.isNull(phoneNumber))this.phoneNumber = phoneNumber;
        else System.out.println("Invalid");
    }

    public String getGovId() {
        return govId;
    }

    public void setGovId(String govId) {
        if(Utility.isNull(govId)) this.govId = govId;
        else System.out.println("Inalid");
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        if (checkIn == null) {
            throw new IllegalArgumentException("Check-in date cannot be null.");
        }

        if (checkIn.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Check-in date cannot be in the past.");
        }
        if (this.checkOut != null && !checkIn.isBefore(this.checkOut)) {
            throw new IllegalArgumentException("Check-in date must be before Check-out date.");
        }

        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        if (checkOut == null) {
            throw new IllegalArgumentException("Check-out date cannot be null.");
        }
        if (this.checkIn == null) {
            throw new IllegalStateException("Please set Check-In date before setting Check-Out date.");
        }
        if (!checkOut.isAfter(this.checkIn)) {
            throw new IllegalArgumentException("Check-out date must be after Check-in date (" + this.checkIn + ").");
        }

        this.checkOut = checkOut;
    }

    public Reservation( int roomId, String guestName, String phoneNumber, String govId, LocalDate checkIn, LocalDate checkOut) {
        this.roomId = roomId;
        setGuestName(guestName);
        setPhoneNumber(phoneNumber);
        setGovId(govId);
        setCheckIn(checkIn);
        setCheckOut(checkOut);
    }
}
