package com.OOP.w19127880_Coursework.Test;

import com.OOP.w19127880_Coursework.ConsoleApplication.DateTime;
import com.OOP.w19127880_Coursework.ConsoleApplication.Doctor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {
    @Test
    void doctorTest1() {//test case 1 for testing the date time class in a specific instance of the class Doctor
        //create object of Doctor class
        Doctor doctor1 = new Doctor("Sam", "Ricardo", new DateTime(1, 2, 1986), 779949898, 928622468, "Cosmetic Dermatology");
        //name attribute under test
        assertEquals("Sam", doctor1.getName());
        doctor1.setName("Samuel");
        assertEquals("Samuel", doctor1.getName());
        //surname attribute under test
        assertEquals("Ricardo", doctor1.getSurName());
        doctor1.setSurName("Richards");
        assertEquals("Richards", doctor1.getSurName());
        //attribute that relates date of birth under test
        assertEquals(new DateTime(1,2,1986), doctor1.getDateOfBirth());
        doctor1.setDateOfBirth(new DateTime(1,3,1986));
        assertEquals(new DateTime(1, 3, 1986), doctor1.getDateOfBirth());
        //mobile number attribute under test
        assertEquals(779949898, doctor1.getMobileNumber());
        doctor1.setMobileNumber(779949899);
        assertEquals(779949899, doctor1.getMobileNumber());
        //medical license number attribute under test
        assertEquals(928622468, doctor1.getMedicalLicenseNo());
        doctor1.setMedicalLicenseNo(934546522);
        assertEquals(934546522, doctor1.getMedicalLicenseNo());
        //specialization attribute under test
        assertEquals("Cosmetic Dermatology", doctor1.getSpecialisation());
        doctor1.setSpecialisation("Medical Dermatology");
        assertEquals("Medical Dermatology", doctor1.getSpecialisation());
    }

    @Test
    void doctorTest2() {//test case 2 for testing the date time class in a specific instance of the class Doctor
        //create object of Doctor class
        Doctor doctor2 = new Doctor("Alexa", "Rodriguez", new DateTime(2, 4, 1987), 778844525, 934546522, "Medical Dermatology");
        //name attribute under test
        assertEquals("Alexa", doctor2.getName());
        doctor2.setName("Alexis");
        assertEquals("Alexis", doctor2.getName());
        //surname attribute under test
        assertEquals("Rodriguez", doctor2.getSurName());
        doctor2.setSurName("Rodger");
        assertEquals("Rodger", doctor2.getSurName());
        //attribute that relates date of birth under test
        assertEquals(new DateTime(2, 4, 1987), doctor2.getDateOfBirth());
        doctor2.setDateOfBirth(new DateTime(2, 4, 1997));
        assertEquals(new DateTime(2, 4, 1997), doctor2.getDateOfBirth());
        //mobile number attribute under test
        assertEquals(778844525, doctor2.getMobileNumber());
        doctor2.setMobileNumber(778844545);
        assertEquals(778844545, doctor2.getMobileNumber());
        //medical license number attribute under test
        assertEquals(934546522, doctor2.getMedicalLicenseNo());
        doctor2.setMedicalLicenseNo(934546500);
        assertEquals(934546500, doctor2.getMedicalLicenseNo());
        //specialization attribute under test
        assertEquals("Medical Dermatology", doctor2.getSpecialisation());
        doctor2.setSpecialisation("Cosmetic Dermatology");
        assertEquals("Cosmetic Dermatology", doctor2.getSpecialisation());
    }

    @Test
    void doctorTest3() {//test case 3 for testing the date time class in a specific instance of the class Doctor
        //create object of Doctor class
        Doctor doctor3 = new Doctor("Arnold", "Schwarzenegger", new DateTime(1, 11, 1988), 776454342, 986657634, "Surgical Dermatology");
        //name attribute under test
        assertEquals("Arnold", doctor3.getName());
        doctor3.setName("Arun");
        assertEquals("Arun", doctor3.getName());
        //surname attribute under test
        assertEquals("Schwarzenegger", doctor3.getSurName());
        doctor3.setSurName("Schwarz");
        assertEquals("Schwarz", doctor3.getSurName());
        //attribute that relates date of birth under test
        assertEquals(new DateTime(1, 11, 1988), doctor3.getDateOfBirth());
        doctor3.setDateOfBirth(new DateTime(1, 11, 1980));
        assertEquals(new DateTime(1, 11, 1980), doctor3.getDateOfBirth());
        //mobile number attribute under test
        assertEquals(776454342, doctor3.getMobileNumber());
        doctor3.setMobileNumber(776454340);
        assertEquals(776454340, doctor3.getMobileNumber());
        //medical license number attribute under test
        assertEquals(986657634, doctor3.getMedicalLicenseNo());
        doctor3.setMedicalLicenseNo(986657000);
        assertEquals(986657000, doctor3.getMedicalLicenseNo());
        //specialization attribute under test
        assertEquals("Surgical Dermatology", doctor3.getSpecialisation());
        doctor3.setSpecialisation("Cosmetic Dermatology");
        assertEquals("Cosmetic Dermatology", doctor3.getSpecialisation());

    }

    @Test
    void doctorTest4() {//test case 4 for testing the date time class in a specific instance of the class Doctor
        //create object of Doctor class
        Doctor doctor4 = new Doctor("Martin", "Garrison", new DateTime(16, 1, 1999), 786547111, 998564543, "Cosmetic Dermatology");
        //name attribute under test
        assertEquals("Martin", doctor4.getName());
        doctor4.setName("Martiaz");
        assertEquals("Martiaz", doctor4.getName());
        //surname attribute under test
        assertEquals("Garrison", doctor4.getSurName());
        doctor4.setSurName("Garrix");
        assertEquals("Garrix", doctor4.getSurName());
        //attribute that relates date of birth under test
        assertEquals(new DateTime(16, 1, 1999), doctor4.getDateOfBirth());
        doctor4.setDateOfBirth(new DateTime(16, 1, 1990));
        assertEquals(new DateTime(16, 1, 1990), doctor4.getDateOfBirth());
        //mobile number attribute under test
        assertEquals(786547111, doctor4.getMobileNumber());
        doctor4.setMobileNumber(786547000);
        assertEquals(786547000, doctor4.getMobileNumber());
        //medical license number attribute under test
        assertEquals(998564543, doctor4.getMedicalLicenseNo());
        doctor4.setMedicalLicenseNo(998560043);
        assertEquals(998560043, doctor4.getMedicalLicenseNo());
        //specialization attribute under test
        assertEquals("Cosmetic Dermatology", doctor4.getSpecialisation());
        doctor4.setSpecialisation("Medical Dermatology");
        assertEquals("Medical Dermatology", doctor4.getSpecialisation());
    }

    @Test
    void doctorTest5() {//test case 5 for testing the date time class in a specific instance of the class Doctor
        //create object of Doctor class
        Doctor doctor5 = new Doctor("Raul", "Rolando", new DateTime(11, 10, 1982), 723349801, 993222111, "Cosmetic Dermatology");
        //name attribute under test
        assertEquals("Raul", doctor5.getName());
        doctor5.setName("Paul");
        assertEquals("Paul", doctor5.getName());
        //surname attribute under test
        assertEquals("Rolando", doctor5.getSurName());
        doctor5.setSurName("Rowan");
        assertEquals("Rowan", doctor5.getSurName());
        //attribute that relates date of birth under test
        assertEquals(new DateTime(11, 10, 1982), doctor5.getDateOfBirth());
        doctor5.setDateOfBirth(new DateTime(21, 1, 1982));
        assertEquals(new DateTime(21, 1, 1982), doctor5.getDateOfBirth());
        //mobile number attribute under test
        assertEquals(723349801, doctor5.getMobileNumber());
        doctor5.setMobileNumber(723349901);
        assertEquals(723349901, doctor5.getMobileNumber());
        //medical license number attribute under test
        assertEquals(993222111, doctor5.getMedicalLicenseNo());
        doctor5.setMedicalLicenseNo(912234389);
        assertEquals(912234389, doctor5.getMedicalLicenseNo());
        //specialization attribute under test
        assertEquals("Cosmetic Dermatology", doctor5.getSpecialisation());
        doctor5.setSpecialisation("Surgical Dermatology");
        assertEquals("Surgical Dermatology", doctor5.getSpecialisation());

    }

    @Test
    void doctorTest6() {//test case 6 for testing the date time class in a specific instance of the class Doctor
        //create object of Doctor class
        Doctor doctor6 = new Doctor("Paul", "Bart", new DateTime(19, 2, 1988), 714324552, 917786342, "Surgical Dermatology");
        //name attribute under test
        assertEquals("Paul", doctor6.getName());
        doctor6.setName("Alan");
        assertEquals("Alan", doctor6.getName());
        //surname attribute under test
        assertEquals("Bart", doctor6.getSurName());
        doctor6.setSurName("Bartinowa");
        assertEquals("Bartinowa", doctor6.getSurName());
        //attribute that relates date of birth under test
        assertEquals(new DateTime(19, 2, 1988), doctor6.getDateOfBirth());
        doctor6.setDateOfBirth(new DateTime(19, 2, 1978));
        assertEquals(new DateTime(19, 2, 1978), doctor6.getDateOfBirth());
        //mobile number attribute under test
        assertEquals(714324552, doctor6.getMobileNumber());
        doctor6.setMobileNumber(714324000);
        assertEquals(714324000, doctor6.getMobileNumber());
        //medical license number attribute under test
        assertEquals(917786342, doctor6.getMedicalLicenseNo());
        doctor6.setMedicalLicenseNo(910086342);
        assertEquals(910086342, doctor6.getMedicalLicenseNo());
        //specialization attribute under test
        assertEquals("Surgical Dermatology", doctor6.getSpecialisation());
        doctor6.setSpecialisation("Cosmetic Dermatology");
        assertEquals("Cosmetic Dermatology", doctor6.getSpecialisation());
    }

    @Test
    void doctorTest7() {//test case 7 for testing the date time class in a specific instance of the class Doctor
        //create object of Doctor class
        Doctor doctor7 = new Doctor("Sam", "Williams", new DateTime(10, 9, 1992), 772348675, 912234389, "Medical Dermatology");
        //name attribute under test
        assertEquals("Sam", doctor7.getName());
        doctor7.setName("Samson");
        assertEquals("Samson", doctor7.getName());
        //surname attribute under test
        assertEquals("Williams", doctor7.getSurName());
        doctor7.setSurName("Will");
        assertEquals("Will", doctor7.getSurName());
        //attribute that relates date of birth under test
        assertEquals(new DateTime(10, 9, 1992), doctor7.getDateOfBirth());
        doctor7.setDateOfBirth(new DateTime(10, 11, 1992));
        assertEquals(new DateTime(10, 11, 1992), doctor7.getDateOfBirth());
        //mobile number attribute under test
        assertEquals(772348675, doctor7.getMobileNumber());
        doctor7.setMobileNumber(772348075);
        assertEquals(772348075, doctor7.getMobileNumber());
        //medical license number attribute under test
        assertEquals(912234389, doctor7.getMedicalLicenseNo());
        doctor7.setMedicalLicenseNo(912004389);
        assertEquals(912004389, doctor7.getMedicalLicenseNo());
        //specialization attribute under test
        assertEquals("Medical Dermatology", doctor7.getSpecialisation());
        doctor7.setSpecialisation("Surgical Dermatology");
        assertEquals("Surgical Dermatology", doctor7.getSpecialisation());
    }

    @Test
    void doctorTest8() {//test case 8 for testing the date time class in a specific instance of the class Doctor
        //create object of Doctor class
        Doctor doctor8 = new Doctor("Max", "Verstappen", new DateTime(14, 4, 1998), 772233423, 901232456, "Medical Dermatology");
        //name attribute under test
        assertEquals("Max", doctor8.getName());
        doctor8.setName("Maxan");
        assertEquals("Maxan", doctor8.getName());
        //surname attribute under test
        assertEquals("Verstappen", doctor8.getSurName());
        doctor8.setSurName("Verson");
        assertEquals("Verson", doctor8.getSurName());
        //attribute that relates date of birth under test
        assertEquals(new DateTime(14, 4, 1998), doctor8.getDateOfBirth());
        doctor8.setDateOfBirth(new DateTime(14, 4, 1978));
        assertEquals(new DateTime(14, 4, 1978), doctor8.getDateOfBirth());
        //mobile number attribute under test
        assertEquals(772233423, doctor8.getMobileNumber());
        doctor8.setMobileNumber(772230023);
        assertEquals(772230023, doctor8.getMobileNumber());
        //medical license number attribute under test
        assertEquals(901232456, doctor8.getMedicalLicenseNo());
        doctor8.setMedicalLicenseNo(901232999);
        assertEquals(901232999, doctor8.getMedicalLicenseNo());
        //specialization attribute under test
        assertEquals("Medical Dermatology", doctor8.getSpecialisation());
        doctor8.setSpecialisation("Cosmetic Dermatology");
        assertEquals("Cosmetic Dermatology", doctor8.getSpecialisation());

    }

    @Test
    void doctorTest9() {//test case 9 for testing the date time class in a specific instance of the class Doctor
        //create object of Doctor class
        Doctor doctor9 = new Doctor("Sebastian", "Vettel", new DateTime(23, 12, 1999), 779232123, 978546321, "Surgical Dermatology");
        //name attribute under test
        assertEquals("Sebastian", doctor9.getName());
        doctor9.setName("Sebes");
        assertEquals("Sebes", doctor9.getName());
        //surname attribute under test
        assertEquals("Vettel", doctor9.getSurName());
        doctor9.setSurName("Valen");
        assertEquals("Valen", doctor9.getSurName());
        //attribute that relates date of birth under test
        assertEquals(new DateTime(23, 12, 1999), doctor9.getDateOfBirth());
        doctor9.setDateOfBirth(new DateTime(23, 12, 1979));
        assertEquals(new DateTime(23, 12, 1979), doctor9.getDateOfBirth());
        //mobile number attribute under test
        assertEquals(779232123, doctor9.getMobileNumber());
        doctor9.setMobileNumber(779232199);
        assertEquals(779232199, doctor9.getMobileNumber());
        //medical license number attribute under test
        assertEquals(978546321, doctor9.getMedicalLicenseNo());
        doctor9.setMedicalLicenseNo(978540000);
        assertEquals(978540000, doctor9.getMedicalLicenseNo());
        //specialization attribute under test
        assertEquals("Surgical Dermatology", doctor9.getSpecialisation());
        doctor9.setSpecialisation("Cosmetic Dermatology");
        assertEquals("Cosmetic Dermatology", doctor9.getSpecialisation());
    }

    @Test
    void doctorTest10() {//test case 10 for testing the date time class in a specific instance of the class Doctor
        //create object of Doctor class
        Doctor doctor10 = new Doctor("Will", "Farrel", new DateTime(26, 1, 1980), 777723324, 998845400, "Cosmetic Dermatology");
        //name attribute under test
        assertEquals("Will", doctor10.getName());
        doctor10.setName("William");
        assertEquals("William", doctor10.getName());
        //surname attribute under test
        assertEquals("Farrel", doctor10.getSurName());
        doctor10.setSurName("Farrelson");
        assertEquals("Farrelson", doctor10.getSurName());
        //attribute that relates date of birth under test
        assertEquals(new DateTime(26, 1, 1980), doctor10.getDateOfBirth());
        doctor10.setDateOfBirth(new DateTime(26, 1, 1960));
        assertEquals(new DateTime(26, 1, 1960), doctor10.getDateOfBirth());
        //mobile number attribute under test
        assertEquals(777723324, doctor10.getMobileNumber());
        doctor10.setMobileNumber(770023324);
        assertEquals(770023324, doctor10.getMobileNumber());
        //medical license number attribute under test
        assertEquals(998845400, doctor10.getMedicalLicenseNo());
        doctor10.setMedicalLicenseNo(998845444);
        assertEquals(998845444, doctor10.getMedicalLicenseNo());
        //specialization attribute under test
        assertEquals("Cosmetic Dermatology", doctor10.getSpecialisation());
        doctor10.setSpecialisation("Surgical Dermatology");
        assertEquals("Surgical Dermatology", doctor10.getSpecialisation());
    }
}