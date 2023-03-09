//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//         Any code taken from other sources is referenced within my code solution.
//         Student ID: 20210021 (IIT) / w19127880 (UoW)
//         Date: 24/12/2022
//        ---------------------------------------------------------------------------------------------

package com.OOP.w19127880_Coursework.ConsoleApplication;

public interface SkinConsultationManager {
    //abstract methods
    boolean addDoctor(Doctor doctor);
    String deleteDoctor(int medicalLicenseNo);
    String displayDoctors();
    boolean saveDoctorData();
    boolean loadDoctorData();

}
