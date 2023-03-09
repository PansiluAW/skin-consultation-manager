//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//         Any code taken from other sources is referenced within my code solution.
//         Student ID: 20210021 (IIT) / w19127880 (UoW)
//         Date: 24/12/2022
//        ---------------------------------------------------------------------------------------------

package com.OOP.w19127880_Coursework.ConsoleApplication;

import java.io.Serializable;
import java.util.Objects;

public class Patient extends Person implements Serializable {
    //create instance variables
    private String patientId;

    //constructor for initialization
    public Patient(String name, String surName, DateTime dateOfBirth, int mobileNumber, String patientId) {
        super(name, surName, dateOfBirth, mobileNumber);
        this.patientId = patientId;
    }

    //getter(accessors) and setters(mutators)
    public String getPatientId(){
        return this.patientId;
    }
    public void setPatientId(String newPatientId){
        this.patientId = newPatientId;
    }

    //overridden toString() method according to program requirement
    @Override
    public String toString() {
        return "Patient { " +super.toString()+
                "Patient ID : " + patientId + " }";
    }

    //overridden equals() method and hashcode() method to check doctor from the attribute values
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(patientId, patient.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), patientId);
    }
}
