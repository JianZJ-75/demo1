package com.jianzj;

/**
 * @Author JianZJ
 * @Date 2024/9/12 13:39
 */
public class MyPreDate {

    private static int[] day31;

    static {
        day31 = new int[]{1, 3, 5, 7, 8, 10, 12};
    }

    public static boolean validateDate(int year, int month, int day) {
        if (month < 1 || month > 12) {
            return false;
        }
        int max = 0;
        if (month == 2) {
            if (isLeapYear(year)) {
                max = 29;
            } else {
                max = 28;
            }
        } else {
            if (isBigMonth(month)) {
                max = 31;
            } else {
                max = 30;
            }
        }
        if (day < 1 || day > max) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isBigMonth(int month) {
        for (int m : day31) {
            if (m == month) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String preDate(int year, int month, int day) {
        if (!validateDate(year, month, day)) {
            return "Not Valid Date";
        }
        // 跨月
        if (day > 1) {
            day--;
        } else {
            // 跨年
            if (month > 1) {
                month--;
                if (month == 2) {
                    if (isLeapYear(year)) {
                        day = 29;
                    } else {
                        day = 28;
                    }
                } else if (isBigMonth(month)) {
                    day = 31;
                } else {
                    day = 30;
                }
            } else {
                year--;
                month = 12;
                day = 31;
            }
        }
        return year + ":" + month + ":" + day;
    }

}