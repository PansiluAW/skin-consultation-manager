package com.OOP.w19127880_Coursework.Test;

import com.OOP.w19127880_Coursework.ConsoleApplication.DateTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeTest {
    @Test
    void dateTimeTest1() {//test case 1 for testing the date time class in a specific instance of the class DateTime
        //create object of DateTime class
        DateTime dateTime1 = new DateTime(1, 2,  1999);
        //the day attribute under test
        assertEquals(1, dateTime1.getDay());
        dateTime1.setDay(2);
        assertEquals(2, dateTime1.getDay());
        //the month attribute under test
        assertEquals(2, dateTime1.getMonth());
        dateTime1.setMonth(3);
        assertEquals(3, dateTime1.getMonth());
        //the year attribute under test
        assertEquals(1999, dateTime1.getYear());
        dateTime1.setYear(1998);
        assertEquals(1998, dateTime1.getYear());
    }

    @Test
    void dateTimeTest2() {//test case 2 for testing the date time class in a specific instance of the class DateTime
        //create object of DateTime class
        DateTime dateTime2 = new DateTime(10, 1,  1970);
        //the day attribute under test
        assertEquals(10, dateTime2.getDay());
        dateTime2.setDay(23);
        assertEquals(23, dateTime2.getDay());
        //the month attribute under test
        assertEquals(1, dateTime2.getMonth());
        dateTime2.setMonth(5);
        assertEquals(5, dateTime2.getMonth());
        //the year attribute under test
        assertEquals(1970, dateTime2.getYear());
        dateTime2.setYear(1988);
        assertEquals(1988, dateTime2.getYear());
    }

    @Test
    void dateTimeTest3() {//test case 3 for testing the date time class in a specific instance of the class DateTime
        //create object of DateTime class
        DateTime dateTime3 = new DateTime(27, 12,  2023);
        //the day attribute under test
        assertEquals(27, dateTime3.getDay());
        dateTime3.setDay(25);
        assertEquals(25, dateTime3.getDay());
        //the month attribute under test
        assertEquals(12, dateTime3.getMonth());
        dateTime3.setMonth(9);
        assertEquals(9, dateTime3.getMonth());
        //the year attribute under test
        assertEquals(2023, dateTime3.getYear());
        dateTime3.setYear(2000);
        assertEquals(2000, dateTime3.getYear());
    }

}