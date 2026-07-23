package com.hotelManagmentSystem;

public final class Utility {

    public static boolean isNull(String text){
        return (text!=null && !text.trim().isEmpty());
    }


    public static boolean isPos(int number) {
        return number > 0;
    }
    public static boolean isPos(float number) {
        return number > 0;
    }

    public static boolean isPos(double number) {
        return number > 0;
    }
}
