//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//         Any code taken from other sources is referenced within my code solution.
//         Student ID: 20210021 (IIT) / w19127880 (UoW)
//         Date: 24/12/2022

package com.OOP.w19127880_Coursework.ConsoleApplication;

//import libraries
import java.io.Serializable;
import java.util.Objects;

public class Doctor extends Person implements Serializable {
    //create instance variables
    private int medicalLicenseNo;
    private String specialisation;

    //constructor for initialization
    public Doctor(String name, String surName, DateTime dateOfBirth, int mobileNumber, int medicalLicenseNo, String specialisation) {
        super(name, surName, dateOfBirth, mobileNumber);
        this.medicalLicenseNo = medicalLicenseNo;
        this.specialisation = specialisation;
    }

    //getter(accessors) and setters(mutators)
    public int getMedicalLicenseNo(){
        return this.medicalLicenseNo;
    }
    public void setMedicalLicenseNo(int newMedicalLicenseNo){
        this.medicalLicenseNo = newMedicalLicenseNo;
    }
    public String getSpecialisation(){
        return this.specialisation;
    }
    public void setSpecialisation(String newSpecialisation){
        this.specialisation = newSpecialisation;
    }

    //overridden toString() method according to program requirement
    @Override
    public String toString() {
        return "\t|- " +super.toString()+
                "Medical License Number : " + medicalLicenseNo +
                ", Specialisation : " + specialisation;
    }

    public String toString(boolean nameOnly) {
        return "\tDr. "+ getName()+" " + getSurName();
    }

    //overridden equals() method and hashcode() method to check doctor from the attribute values
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return medicalLicenseNo == doctor.medicalLicenseNo && Objects.equals(specialisation, doctor.specialisation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), medicalLicenseNo, specialisation);
    }
}
