    package com.hotelManagmentSystem;

    import java.sql.Connection;

    public class Rooms {
        private int roomNumber;
        private String roomType;
        private boolean avaliability;
        private double price;

        public int getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(int roomNumber) {
            if(Utility.isPos(roomNumber)) this.roomNumber = roomNumber;
            else System.out.println("Invalid");
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            if(Utility.isNull(roomType))this.roomType = roomType;
            else System.out.println("Invalid");
        }

        public boolean isAvaliability() {
            return avaliability;
        }

        public void setAvaliability(boolean avaliability) {
            this.avaliability = avaliability;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            if(Utility.isPos(price))this.price = price;
            else System.out.println("invalid");
        }

        public Rooms(int roomNumber, String roomType, boolean avaliability, double price) {
            setRoomNumber(roomNumber);
            setRoomType(roomType);
            setAvaliability(avaliability);
            setPrice(price);
        }
    }
