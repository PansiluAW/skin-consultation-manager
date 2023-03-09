//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//         Any code taken from other sources is referenced within my code solution.
//         Student ID: 20210021 (IIT) / w19127880 (UoW)
//         Date: 24/12/2022
//        ---------------------------------------------------------------------------------------------

package com.OOP.w19127880_Coursework.ConsoleApplication;

//import libraries
import com.OOP.w19127880_Coursework.GUI.GUIApplication;
import java.util.Scanner;

public class ConsoleApplication {
    //create instance(object) of WestminsterSkinConsultationManager() class
    private static final SkinConsultationManager MANAGER = new WestminsterSkinConsultationManager();

    //create scanner object
    public static final Scanner USER_INPUT = new Scanner(System.in);
    public static void main(String[] args){
        int choice;
        //Display Menu Title
        System.out.println();
        System.out.println("********************************************************");
        System.out.println("* Welcome to the Westminster Skin Consultation Manager *");
        System.out.println("********************************************************");
        //call method to load the previously stored data in file
        MANAGER.loadDoctorData();
        continueLoop:
        while (true) {
            //call method to display the program menu to the user on console.
            displayMenu();
            //get user choice
            choice = 0;
            try{
                choice = USER_INPUT.nextInt();
            }catch (Exception e){
                System.out.println("\nInvalid input! Please enter your choice in numerical format...");
                USER_INPUT.next();
                continue;
            }
            switch(choice){
                case 1:
                    // add doctor to the system using method
                    addDoctor();
                    break;
                case 2:
                    //delete doctor from the system using method
                    deleteDoctor();
                    break;
                case 3:
                    //display all the doctors with their respective details using method
                    MANAGER.displayDoctors();
                    break;
                case 4:
                    //save the data from the current program run into the .dataDoctorSaveData.data file
                    MANAGER.saveDoctorData();
                    break;
                case 5:
                    //load the data stored in DoctorSaveData.data file into the program.
                    MANAGER.loadDoctorData();
                    break;
                case 6:
                    MANAGER.saveDoctorData();
                    MANAGER.loadDoctorData();
                    System.out.println("GUI Application successfully opened");
                    new GUIApplication();
                    break;
                case 7:
                    //display success message to the user upon exit
                    System.out.println("Program Exited Successfully.");
                    System.out.println("**************************************************************");
                    System.out.println("* Thank you for using Westminster Skin Consultation Manager! *");
                    System.out.println("**************************************************************");
                    System.out.println("Have a wonderful day!");
                    break continueLoop;
                default:
                    //display relevant message to the user upon invalid input
                    System.out.println("Invalid Input! Please try again with valid inputs within range...");
            }
        }
    }

    public static void displayMenu(){
        //display menu with their respective options to the user
        System.out.println();
        System.out.println("Please select your choice,");
        System.out.println("\t1. Add a new doctor.");
        System.out.println("\t2. Delete a doctor.");
        System.out.println("\t3. Display all available doctors.");
        System.out.println("\t4. Save data into file");
        System.out.println("\t5. Load data from file");
        System.out.println("\t6. Launch GUI Application");
        System.out.println("\t7. Quit the Program\n");
        System.out.print(">>>>");
    }

    private static void addDoctor() {
        //create variable to be used for addDoctor operations
        String name;
        String surName;
        int day;
        int month;
        int year;
        int mobileNumber;
        int medicalLicenseNo;
        String specialization;

        nameLoop: //loop for validating user input for name, until valid input is entered by user
        while (true) {
            //get name of the doctor from user
            System.out.print("Enter the name of the doctor : ");
            name = USER_INPUT.next();

            if (name.matches("[a-zA-Z]+")) { //check if the input contains valid characters for name
                break nameLoop;
            } else System.out.println("Invalid characters used for Name"); //else display relevant message to the user
        }

        surNameLoop: //loop for validating user input for surname, until valid input is entered by user
        while (true) {
            //get surname of the doctor from user
            System.out.print("Enter the surname of the doctor : ");
            surName = USER_INPUT.next();

            if (surName.matches("[a-zA-Z]+")) { //check if the input contains valid characters for surname
                break surNameLoop;
            } else System.out.println("Invalid characters used for Surname"); //else display relevant message to the user
        }
        //display instructive message for furthermore specialised inputs which prompts next to the user
        System.out.println("Enter the date of birth of the doctor sequentially,");

        dateLoop: //loop for validating user input for day, until valid input is entered by user
        while (true) {
            try{
                //get day from user
                System.out.print("\tD : ");
                day = USER_INPUT.nextInt();
            }catch (Exception e){ //error handling when user enters invalid characters
                System.out.println("Invalid Characters! Please try again...");
                USER_INPUT.next();
                continue;
            }
            if (0 < day && day < 32) { //check whether the user input for day is in valid range
                break dateLoop;
            } else System.out.println("Invalid range for day. Please try again!"); //else display relevant message to the user
        }

        monthLoop: //loop for validating user input for month, until valid input is entered by user
        while (true) {
            try {
                //get month from user
                System.out.print("\tM : ");
                month = USER_INPUT.nextInt();
            }catch (Exception e){ //error handling when user enters invalid characters
                System.out.println("Invalid Character! Please try again...");
                USER_INPUT.next();
                continue;
            }
            if (0 < month && month <= 12) { //check whether the user input for month is in valid range
                break monthLoop;
            } else System.out.println("Invalid range for month. Please try again!"); //else display relevant message to the user
        }

        yearLoop: //loop for validating user input for year, until valid input is entered by user
        while (true) {
            try {
                //get year from user
                System.out.print("\tY : ");
                year = USER_INPUT.nextInt();
            }catch (Exception e){ //error handling when user enters invalid characters
                System.out.println("Invalid Character! Please try again...");
                USER_INPUT.next();
                continue;
            }
            if (1000 <= year && year <= 2023) { //check whether the user input for day is in valid range
                break yearLoop;
            } else System.out.println("Invalid range for year. Please try again!"); //else display relevant message to the user
        }

        mobileNumberLoop: //loop for validating user input for mobile number, until valid input is entered by user
        while (true) {
            try {
                System.out.print("Enter the mobile number of the doctor (i.e. 712345678) : ");
                mobileNumber = USER_INPUT.nextInt();
                if (String.valueOf(mobileNumber).length() != 9){
                    System.out.println("Invalid format for mobile number.");
                    continue mobileNumberLoop;
                }
                break mobileNumberLoop;
            } catch (Exception e) { //error handling when user enters invalid characters
                System.out.println("Invalid type of input. Contact number should follow the format. i.e. 0712345678");
                USER_INPUT.next();
            }
        }

        medicalLicenseNoLoop: //loop for validating user input for medical license number, until valid input is entered by user
        while (true) {
            try {
                System.out.print("Enter the medical license number (i.e. 123456789) : ");
                medicalLicenseNo = USER_INPUT.nextInt();
                if (String.valueOf(medicalLicenseNo).length() != 9){
                    System.out.println("Invalid format for medical license number.");
                    continue medicalLicenseNoLoop;
                }
                break medicalLicenseNoLoop;
            } catch (Exception e) { //error handling when user enters invalid characters
                System.out.println("Invalid type of input. Medical License Number should follow the format. i.e. 123456789");
                USER_INPUT.next();
            }
        }

        specializationLoop: //loop for validating user input for doctor's specialization, until valid input is entered by user
        while (true) {
            System.out.print("Enter specialization (cosmetic dermatology, medical dermatology, pediatric dermatology, etc.) : ");
            specialization = USER_INPUT.next();

            if (specialization.matches("[a-zA-Z]+")) { //check if the input contains valid characters for specialization
                break specializationLoop;
            } else System.out.println("Invalid characters used for specialization title. Please try again!"); //else display relevant message to the user
        }

        Doctor doctor = new Doctor(name, surName, new DateTime(day, month, year), mobileNumber, medicalLicenseNo, specialization);
        MANAGER.addDoctor(doctor);
    }

    private static void deleteDoctor() {
        //get medical license number from the user, inorder to remove the doctor with the specific license number from system.
        System.out.print("Enter the medical license number of the doctor to be deleted : ");
        try {
            int medicalLicenseNo = USER_INPUT.nextInt();
            MANAGER.deleteDoctor(medicalLicenseNo);//pass input value to method for removing doctor from system.
        }catch (Exception exception){
            System.out.println("Invalid format for the medical license number.");
        }
    }
}