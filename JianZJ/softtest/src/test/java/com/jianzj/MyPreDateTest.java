package com.jianzj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @Author JianZJ
 * @Date 2024/9/12 13:47
 */

@RunWith(Parameterized.class)
public class MyPreDateTest {

    @Parameters(name = "{index}: test({0}, {1}, {2}) = {3}")
    public static Collection<?> data() {
        return Arrays.asList(new Object[][] {
                // 日
                {2004, 8, 29, "2004:8:28"},
                // 月
                {2004, 12, 1, "2004:11:30"},
                {2004, 11, 1, "2004:10:31"},
                // 2
                {2004, 3, 1, "2004:2:29"},
                {2003, 3, 1, "2003:2:28"},
                // 年
                {2003, 1, 1, "2002:12:31"},
                {2005, 1, 1, "2004:12:31"},
                // 不合法
                {2004, 8, 32, "Not Valid Date"},
                {2004, 9, 31, "Not Valid Date"},
                {2003, 2, 29, "Not Valid Date"},
                {2004, 2, 30, "Not Valid Date"}
        });
    }

    int year;
    int month;
    int day;
    String expected;

    public MyPreDateTest(int year, int month, int day, String expected) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, MyPreDate.preDate(year, month, day));
    }

}