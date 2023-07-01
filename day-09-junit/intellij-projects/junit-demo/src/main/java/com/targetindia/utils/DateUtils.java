package com.targetindia.utils;

public class DateUtils {

    public boolean isLeap(int year) {
//        if(year<0){
//            throw new RuntimeException("Year cannot be less than zero!");
//        }
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }
}
