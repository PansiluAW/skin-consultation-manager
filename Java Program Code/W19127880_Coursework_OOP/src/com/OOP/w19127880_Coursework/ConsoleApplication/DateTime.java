//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//         Any code taken from other sources is referenced within my code solution.
//         Student ID: 20210021 (IIT) / w19127880 (UoW)
//         Date: 24/12/2022
//        ---------------------------------------------------------------------------------------------

package com.OOP.w19127880_Coursework.ConsoleApplication;

//import libraries
import java.io.Serializable;
import java.util.Objects;

public class DateTime implements Serializable{
    //create instance variables
    private int day;
    private int month;
    private int year;
    private int hours;
    private int minutes;
    private String hourMinuteStr = "";

    //constructor for initialization
    //with hours and minutes
    public DateTime(int day, int month, int year, int hours, int minutes){
        this.day = day;
        this.month = month;
        this.year = year;
        this.hours = hours;
        this.minutes = minutes;
        hourMinuteStr = hours +":"+minutes+" ";
    }
    //constructor for initialization
    //without hours and minutes
    public DateTime(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //getter(accessors) and setters(mutators)
    public int getDay(){
        return this.day;
    }

    public void setDay(int newDay){
        this.day = newDay;
    }
    public int getMonth(){
        return this.month;
    }
    public void setMonth(int newMonth){
        this.month = newMonth;
    }
    public int getYear(){
        return this.year;
    }
    public void setYear(int newYear){
        this.year = newYear;
    }

    //overridden toString() method according to program requirement
    @Override
    public String toString() {
        return day +" / "+
                month + " / "+
                year + " "+hourMinuteStr;
    }

    //overridden equals() method and hashcode() method to check doctor from the attribute values
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTime dateTime = (DateTime) o;
        return day == dateTime.day && month == dateTime.month && year == dateTime.year && hours == dateTime.hours && minutes == dateTime.minutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year, hours, minutes);
    }
}
