package com.OOP.w19127880_Coursework.Test;

import com.OOP.w19127880_Coursework.ConsoleApplication.DateTime;
import com.OOP.w19127880_Coursework.ConsoleApplication.Doctor;
import com.OOP.w19127880_Coursework.ConsoleApplication.WestminsterSkinConsultationManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WestminsterSkinConsultationManagerTest {

    @Test
    void westminsterSkinConsultationManagerTest1() {//test case 1 for testing the date time class in a specific instance of the class WestminsterSkinConsultationManager
        //create object of Doctor class
        Doctor doctor1 =  new Doctor("Anzon", "Gaberialle",new DateTime(1, 4, 1998), 779949898, 984354776, "Medical Dermatology");
        //create object of WestminsterSkinConsultationManager class
        WestminsterSkinConsultationManager westminsterSkinConsultationManager1 = new WestminsterSkinConsultationManager();
        //addDoctor() method under test given inputs 
        assertEquals(true, westminsterSkinConsultationManager1.addDoctor(doctor1));
        //deleteDoctor() method under test given inputs of different scenarios  
        assertEquals("Success", westminsterSkinConsultationManager1.deleteDoctor(984354755));
        assertEquals("Success", westminsterSkinConsultationManager1.deleteDoctor(984354776));
        //saveDoctorData() method under test
        assertEquals(true, westminsterSkinConsultationManager1.saveDoctorData());
        //loadDoctorData() method under test
        assertEquals(true, westminsterSkinConsultationManager1.loadDoctorData());
    }
    @Test
    void westminsterSkinConsultationManagerTest2() {//test case 2 for testing the date time class in a specific instance of the class WestminsterSkinConsultationManager
        //create object of Doctor class
        Doctor doctor2 =  new Doctor("Arthur", "Ford",new DateTime(26, 3, 1997), 778865664, 998547364, "Surgical Dermatology");
        //create object of WestminsterSkinConsultationManager class
        WestminsterSkinConsultationManager westminsterSkinConsultationManager2 = new WestminsterSkinConsultationManager();
        //addDoctor() method under test given inputs 
        assertEquals(true, westminsterSkinConsultationManager2.addDoctor(doctor2));
        //deleteDoctor() method under test given inputs of different scenarios  
        assertEquals("Success", westminsterSkinConsultationManager2.deleteDoctor(977547364));
        assertEquals("Success", westminsterSkinConsultationManager2.deleteDoctor(998547364));
        //saveDoctorData() method under test
        assertEquals(true, westminsterSkinConsultationManager2.saveDoctorData());
        //loadDoctorData() method under test
        assertEquals(true, westminsterSkinConsultationManager2.loadDoctorData());
    }
    @Test
    void westminsterSkinConsultationManagerTest3() {//test case 3 for testing the date time class in a specific instance of the class WestminsterSkinConsultationManager
        //create object of Doctor class
        Doctor doctor3 =  new Doctor("Arnold", "Atherero",new DateTime(6, 2, 1988), 778544934, 985544354, "Cosmetic Dermatology");
        //create object of WestminsterSkinConsultationManager class
        WestminsterSkinConsultationManager westminsterSkinConsultationManager3 = new WestminsterSkinConsultationManager();
        //addDoctor() method under test given inputs 
        assertEquals(true, westminsterSkinConsultationManager3.addDoctor(doctor3));
        //deleteDoctor() method under test given inputs of different scenarios  
        assertEquals("Success", westminsterSkinConsultationManager3.deleteDoctor(985884334));
        assertEquals("Success", westminsterSkinConsultationManager3.deleteDoctor(985544354));
        //saveDoctorData() method under test
        assertEquals(true, westminsterSkinConsultationManager3.saveDoctorData());
        //loadDoctorData() method under test
        assertEquals(true, westminsterSkinConsultationManager3.loadDoctorData());
    }
    @Test
    void westminsterSkinConsultationManagerTest4() {//test case 4 for testing the date time class in a specific instance of the class WestminsterSkinConsultationManager
        //create object of Doctor class
        Doctor doctor4 =  new Doctor("Ethan", "Hunt",new DateTime(1, 4, 1978), 778547632, 998845343, "Cosmetic Dermatology");
        //create object of WestminsterSkinConsultationManager class
        WestminsterSkinConsultationManager westminsterSkinConsultationManager4 = new WestminsterSkinConsultationManager();
        //addDoctor() method under test given inputs 
        assertEquals(true, westminsterSkinConsultationManager4.addDoctor(doctor4));
        //deleteDoctor() method under test given inputs of different scenarios  
        assertEquals("Success", westminsterSkinConsultationManager4.deleteDoctor(998800043));
        assertEquals("Success", westminsterSkinConsultationManager4.deleteDoctor(998845343));
        //saveDoctorData() method under test
        assertEquals(true, westminsterSkinConsultationManager4.saveDoctorData());
        //loadDoctorData() method under test
        assertEquals(true, westminsterSkinConsultationManager4.loadDoctorData());
    }
    @Test
    void westminsterSkinConsultationManagerTest5() {//test case 5 for testing the date time class in a specific instance of the class WestminsterSkinConsultationManager
        //create object of Doctor class
        Doctor doctor1 =  new Doctor("Roger", "Gustawo",new DateTime(2, 4, 1996), 778434332, 998574687, "Surgical Dermatology");
        //create object of WestminsterSkinConsultationManager class
        WestminsterSkinConsultationManager westminsterSkinConsultationManager5 = new WestminsterSkinConsultationManager();
        //addDoctor() method under test given inputs 
        assertEquals(true, westminsterSkinConsultationManager5.addDoctor(doctor1));
        //deleteDoctor() method under test given inputs of different scenarios  
        assertEquals("Success", westminsterSkinConsultationManager5.deleteDoctor(998574447));
        assertEquals("Success", westminsterSkinConsultationManager5.deleteDoctor(998574687));
        //saveDoctorData() method under test
        assertEquals(true, westminsterSkinConsultationManager5.saveDoctorData());
        //loadDoctorData() method under test
        assertEquals(true, westminsterSkinConsultationManager5.loadDoctorData());
    }


}