//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//         Any code taken from other sources is referenced within my code solution.
//         Student ID: 20210021 (IIT) / w19127880 (UoW)
//         Date: 24/12/2022
//        ---------------------------------------------------------------------------------------------

package com.OOP.w19127880_Coursework.ConsoleApplication;

//import libraries
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WestminsterSkinConsultationManager implements SkinConsultationManager, Serializable{
    //create instance and static variables
    public static List<Doctor> doctorList = new ArrayList<>(){};
    private static final int MAX_DOCTORS = 10;
    private int availableDoctors = doctorList.size();

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    @Override
    public boolean addDoctor(Doctor doctor) {
        if (!doctorList.contains(doctor)){ //check if arrayList of doctors contains the doctor
            if (availableDoctors < MAX_DOCTORS){
                doctorList.add(doctor); //add doctor object to arrayList of doctors
                availableDoctors += 1; //update available doctor count
                //display success status message to the user
                System.out.println("\nDr. "+doctor.getName()+" was successfully added to the system.");
                System.out.println("Doctors available in the centre as of now : "+availableDoctors+"\n");
                return true;
            }else{
                //display message for reaching maximum count of doctors in the centre
                System.out.println("\nDoctor capacity in the centre has reached it's maximum!");
            }
        } else{
            //display message if doctor already exists in the system
            System.out.println("\nDr. "+doctor.getName()+" is already added into the system.\n");
        }
        return false;
    }

    @Override
    public String deleteDoctor(int medicalLicenseNo){
        boolean doctorAvailable = false;
        docLoop: //loop to get the doctor object with the medical license number
        for (Doctor doctor : doctorList) {
            if (doctor.getMedicalLicenseNo() == medicalLicenseNo) {
                doctorAvailable = true; //boolean to mark the availability of doctor in the centre
                availableDoctors -= 1; //update available doctor count
                //display success status message to user
                System.out.printf("%s has been successfully deleted from the system.\n\nAvailable doctors in the centre : %d\n",doctor, availableDoctors);
                doctorList.remove(doctor); //remove doctor object from the arrayList of doctors
                break docLoop; //break out of for loop named
            }
        }
        if (doctorAvailable == false){ //display relevant message if the doctor is not available at the centre
            System.out.printf("Doctor with %d as the medical license number is NOT FOUND!\nPlease check whether the entered medical license number is valid!\n", medicalLicenseNo);
        }
        return "Success";
    }

    @Override
    public String displayDoctors(){
        Collections.sort(doctorList); //sort doctors based on the user surname (overridden compareTo() method)
        if (!doctorList.isEmpty()) { //display doctors if the arrayList of doctors aren't empty
            System.out.println("\nDoctors available at the centre,\n");
            for (Doctor doctor : doctorList) {
                System.out.println(doctor); //display doctor with the respective details
            }
        }else System.out.println("\nNo doctor is available at the moment..."); //display message if the arrayList of doctors is empty
        return "Success";
    }
    @Override
    public boolean saveDoctorData(){
        /*Title: Write and read an ArrayList object to a file in Java
                  Author: samderlust.com
                  Date: 24/12/2022
                  Code Version: 1.0
                  Availability: https://samderlust.com/dev-blog/java/write-read-arraylist-object-file-java*/

        try {
            if (doctorList.isEmpty()){ //display message if arrayList of doctors is empty and nothing to store to save file
                System.out.println("No data to write to the file.");
            }else {
                //create file object with save data file
                File file = new File("src/com/OOP/w19127880_Coursework/SaveFiles/DoctorSaveData.data");
                if (!file.exists()) {//create new file if file doesn't exist
                    file.createNewFile();
                }
                FileOutputStream writeData = new FileOutputStream(file);
                ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
                writeStream.writeObject(doctorList); //write object to file
                writeStream.flush();
                writeData.close();
                writeStream.close();
                System.out.println("\nData successfully saved to file"); //display success status message to user
                availableDoctors = doctorList.size();
            }
            return true;
            //error handlers for FileNotFoundExceptions and IOExceptions
        }catch (FileNotFoundException e){
            System.out.println("Save file not found");
        }catch (IOException e){
                System.out.println("Error has occurred during process. Error: "+e);
        }
        return false;
    }
    @Override
    public boolean loadDoctorData() {
        try {
            //create file object with save data file
            File file = new File("src/com/OOP/w19127880_Coursework/SaveFiles/DoctorSaveData.data");
            if (!file.exists()) {//create new file if file doesn't exist
                file.createNewFile();
            }
            FileInputStream readData = new FileInputStream(file);
            ObjectInputStream readStream = new ObjectInputStream(readData);
            doctorList = (ArrayList<Doctor>) readStream.readObject(); //load save data back to the arrayList of doctor objects
            readStream.close();
            availableDoctors = doctorList.size();
            System.out.println("\nSave data retrieved back to the system."); //display success status message to the user
        }catch (InvalidClassException e){
        }catch (Exception e) { // error handler for exception for only sending data with ObjectInputStream
        }
        return true;    }
}