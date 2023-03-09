package com.OOP.w19127880_Coursework.ConsoleApplication;

import java.io.Serializable;

public class Consultation implements Serializable {
    //create instance variables
    private DateTime consultationDateTime;
    private double cost;
    private String notes;
    private int doctorMedicalLicenseNo;
    private Patient patient;
    private byte[][] imageList;
    //constructor for initialization
    public Consultation(String name, String surName, DateTime dateOfBirth, int mobileNumber, String patientId, DateTime consultationDateTime, int cost, String notes, int doctorMedicalLicenseNo, byte[][] encryptedImageList) {
        patient = new Patient(name, surName, dateOfBirth, mobileNumber, patientId);
        this.doctorMedicalLicenseNo = doctorMedicalLicenseNo;
        this.consultationDateTime = consultationDateTime;
        this.cost = cost;
        this.notes = notes;
        this.imageList = encryptedImageList;
    }

    //getter(accessors) and setters(mutators)
    public int getDoctorMedicalLicenseNo() {
        return doctorMedicalLicenseNo;
    }
    public DateTime getConsultationDateTime() {
        return consultationDateTime;
    }
    public void setConsultationDateTime(DateTime consultationDateTime) {
        this.consultationDateTime = consultationDateTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Patient getPatient() {
        return patient;
    }

    public byte[][] getImageList() {
        return imageList;
    }

    public void setImageList(byte[][] imageList) {
        this.imageList = imageList;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "consultationDateTime=" + consultationDateTime +
                ", cost=" + cost +
                ", notes='" + notes + '\'' +
                ", doctorMedicalLicenseNo=" + doctorMedicalLicenseNo +
                ", patient=" + patient +
                '}';
    }
}
