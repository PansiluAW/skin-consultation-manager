//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//         Any code taken from other sources is referenced within my code solution.
//         Student ID: 20210021 (IIT) / w19127880 (UoW)
//         Date: 24/12/2022
//        ---------------------------------------------------------------------------------------------

package com.OOP.w19127880_Coursework.ConsoleApplication;

//import libraries
import java.io.Serializable;
import java.util.Objects;

public abstract class Person implements Comparable<Person>, Serializable {
    //create instance variables
    private String name;
    private String surName;
    private DateTime dateOfBirth;
    private int mobileNumber;

    //constructor for initialization
    public Person(String name, String surName, DateTime dateOfBirth, int mobileNumber) {
        this.name = name;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
    }

    //getter(accessors) and setters(mutators)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    //overridden toString() method according to program requirement
    @Override
    public String toString() {
        return "Name : " + name +
                ", Surname : " + surName +
                ", Date Of Birth : " + dateOfBirth +
                ", Mobile Number : " + mobileNumber + ", ";
    }

    //overridden equals() method and hashcode() method to check doctor from the attribute values
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return mobileNumber == person.mobileNumber && Objects.equals(name, person.name) && Objects.equals(surName, person.surName) && Objects.equals(dateOfBirth, person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, dateOfBirth, mobileNumber);
    }

    //overridden compareTo() method for comparison between to objects for sorting based on doctor's surname
    @Override
    public int compareTo(Person person) {
        return this.getSurName().compareToIgnoreCase(person.getSurName());
    }
}
