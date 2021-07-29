package com.DataStructurePrograms;
import java.util.Scanner;

public class Calendar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a month : ");
        int month = sc.nextInt();
        System.out.println("Enter a year : ");
        int year = sc.nextInt();

        int month0, x, day = 1, day0, year0;

        year0 = year - (14 - month) / 12;
        x = year0 + (year0 / 4) - (year0 / 100) + (year0 / 400);
        month0 = month + 12 * ((14 - month) / 12) - 2;
        day0 = (day + x + (31 * month0) / 12) % 7;


        int[] dayInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int dayLimitInMonth = 0;

        for (int i=0; i<dayInMonth.length; i++){
            if (i == month-1){
                dayLimitInMonth = dayInMonth[i];
            }
        }

        int tDays[][] = new int[6][7];

        boolean flagLeapYear = false;
        if ((year%4==0 && year%100!=0) || year%400==0){
            flagLeapYear = true;
        }else {
            flagLeapYear = false;
        }

        if (flagLeapYear == true && month == 2){
            dayLimitInMonth = 29;
        }

        int countDay = 1;

        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                if (i==0 && j<day0){
                    tDays[i][j] = -1;
                }else if (countDay<=dayLimitInMonth){
                    tDays[i][j] = countDay;
                    countDay++;
                }else {
                    tDays[i][j] = -1;
                }
            }
        }

        String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] dayName = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (int i=0; i<12; i++){
            if (month == i+1)
                System.out.println(monthName[i] + " " + year);
        }
        for (int i=0; i<7; i++){
            System.out.print(dayName[i]+"\t");
        }
        System.out.print("\n==========================\n");

        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++) {
                if (tDays[i][j] != -1) {
                    if (tDays[i][j] < 10)
                        System.out.print(tDays[i][j] + "\t");
                    else
                        System.out.print(tDays[i][j] + "\t");
                } else
                    System.out.print("\t");
            }
            System.out.println();

        }

    }

}
