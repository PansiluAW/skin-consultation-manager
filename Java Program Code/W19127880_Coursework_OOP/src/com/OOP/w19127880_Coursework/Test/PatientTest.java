package com.OOP.w19127880_Coursework.Test;

import com.OOP.w19127880_Coursework.ConsoleApplication.DateTime;
import com.OOP.w19127880_Coursework.ConsoleApplication.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void patientTest1() {//test case 1 for testing the date time class in a specific instance of the class Patient
        //create object of Patient class
        Patient patient1 = new Patient("Jason", "Mamoa", new DateTime(1, 1, 1998), 779965434, "823721232");
        //patient ID attribute under test
        assertEquals("823721232", patient1.getPatientId());
        patient1.setPatientId("823721200");
        assertEquals("823721200", patient1.getPatientId());
        assertEquals("Jason", patient1.getName());
        //name attribute under test
        patient1.setName("Anson");
        assertEquals("Anson", patient1.getName());
        //surname attribute under test
        assertEquals("Mamoa", patient1.getSurName());
        patient1.setSurName("Manbowi");
        assertEquals("Manbowi", patient1.getSurName());
        //attributes that related date of birth under test
        assertEquals(new DateTime(1, 1, 1998), patient1.getDateOfBirth());
        patient1.setDateOfBirth(new DateTime(1, 12, 1996));
        assertEquals(new DateTime(1, 12, 1996), patient1.getDateOfBirth());
        //mobile number attribute under test
        assertEquals(779965434, patient1.getMobileNumber());
        patient1.setMobileNumber(779900434);
        assertEquals(779900434, patient1.getMobileNumber());
    }

    @Test
    void patientTest2() {//test case 2 for testing the date time class in a specific instance of the class Patient
        //create object of Patient class
        Patient patient2 = new Patient("Anton", "Gustawo", new DateTime(11, 10, 1978), 779949898, "453434543");
        //patient ID attribute under test
        assertEquals("453434543", patient2.getPatientId());
        patient2.setPatientId("453434000");
        assertEquals("453434000", patient2.getPatientId());
        //name attribute under test
        assertEquals("Anton", patient2.getName());
        patient2.setName("Antonio");
        assertEquals("Antonio", patient2.getName());
        //surname attribute under test
        assertEquals("Gustawo", patient2.getSurName());
        patient2.setSurName("Gusta");
        assertEquals("Gusta", patient2.getSurName());
        //attributes that related date of birth under test
        assertEquals(new DateTime(11, 10, 1978), patient2.getDateOfBirth());
        patient2.setDateOfBirth(new DateTime(11, 9, 1978));
        assertEquals(new DateTime(11, 9, 1978), patient2.getDateOfBirth());
        //mobile number attribute under test
        assertEquals(779949898, patient2.getMobileNumber());
        patient2.setMobileNumber(779940098);
        assertEquals(779940098, patient2.getMobileNumber());
    }

    @Test
    void patientTest3() {//test case 3 for testing the date time class in a specific instance of the class Patient
        //create object of Patient class
        Patient patient3 = new Patient("Adam", "Levine", new DateTime(7, 7, 1997), 778943545, "998574832");
        //patient ID attribute under test
        assertEquals("998574832", patient3.getPatientId());
        patient3.setPatientId("998000832");
        assertEquals("998000832", patient3.getPatientId());
        //name attribute under test
        assertEquals("Adam", patient3.getName());
        patient3.setName("Adan");
        assertEquals("Adan", patient3.getName());
        //surname attribute under test
        assertEquals("Levine", patient3.getSurName());
        patient3.setSurName("Leviara");
        assertEquals("Leviara", patient3.getSurName());
        //attributes that related date of birth under test
        assertEquals(new DateTime(7, 7, 1997), patient3.getDateOfBirth());
        patient3.setDateOfBirth(new DateTime(7, 17, 1997));
        assertEquals(new DateTime(7, 17, 1997), patient3.getDateOfBirth());
        //mobile number attribute under test
        assertEquals(778943545, patient3.getMobileNumber());
        patient3.setMobileNumber(778999545);
        assertEquals(778999545, patient3.getMobileNumber());
    }

    @Test
    void patientTest4() {//test case 4 for testing the date time class in a specific instance of the class Patient
        //create object of Patient class
        Patient patient4 = new Patient("Ajax", "Silda", new DateTime(25, 5, 1998), 779965642, "995847354");
        //patient ID attribute under test
        assertEquals("995847354", patient4.getPatientId());
        patient4.setPatientId("995847366");
        assertEquals("995847366", patient4.getPatientId());
        //name attribute under test
        assertEquals("Ajax", patient4.getName());
        patient4.setName("Ajaxon");
        assertEquals("Ajaxon", patient4.getName());
        //surname attribute under test
        assertEquals("Silda", patient4.getSurName());
        patient4.setSurName("Sildawa");
        assertEquals("Sildawa", patient4.getSurName());
        //attributes that related date of birth under test
        assertEquals(new DateTime(25, 5, 1998), patient4.getDateOfBirth());
        patient4.setDateOfBirth(new DateTime(5, 11, 1998));
        assertEquals(new DateTime(5, 11, 1998), patient4.getDateOfBirth());
        //mobile number attribute under test
        assertEquals(779965642, patient4.getMobileNumber());
        patient4.setMobileNumber(779961133);
        assertEquals(779961133, patient4.getMobileNumber());
    }

    @Test
    void patientTest5() {//test case 5 for testing the date time class in a specific instance of the class Patient
        //create object of Patient class
        Patient patient5 = new Patient("Harold", "Arthur", new DateTime(25, 3, 1998), 776654543, "994356321");
        //patient ID attribute under test
        assertEquals("994356321", patient5.getPatientId());
        patient5.setPatientId("994112321");
        assertEquals("994112321", patient5.getPatientId());
        //name attribute under test
        assertEquals("Harold", patient5.getName());
        patient5.setName("Arnold");
        assertEquals("Arnold", patient5.getName());
        //surname attribute under test
        assertEquals("Arthur", patient5.getSurName());
        patient5.setSurName("Arthuka");
        assertEquals("Arthuka", patient5.getSurName());
        //attributes that related date of birth under test
        assertEquals(new DateTime(25, 3, 1998), patient5.getDateOfBirth());
        patient5.setDateOfBirth(new DateTime(15, 3, 1998));
        assertEquals(new DateTime(15, 3, 1998), patient5.getDateOfBirth());
        //mobile number attribute under test
        assertEquals(776654543, patient5.getMobileNumber());
        patient5.setMobileNumber(776364543);
        assertEquals(776364543, patient5.getMobileNumber());
    }
}