package com.OOP.w19127880_Coursework.GUI;

import com.OOP.w19127880_Coursework.ConsoleApplication.DateTime;
import com.OOP.w19127880_Coursework.ConsoleApplication.Doctor;
import com.OOP.w19127880_Coursework.ConsoleApplication.WestminsterSkinConsultationManager;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DoctorTableModel extends AbstractTableModel {
    private static final String[] columnNames = {"Name", "Surname", "Date of Birth", "Mobile Number", "Medical License No", "Specialisation"};//columns names that are set to appear on the table
    private List<Doctor> doctorTList = WestminsterSkinConsultationManager.doctorList;//get the doctor detail list using the WestminsterSkinConsultationManager object

    @Override
    public int getRowCount() {
        return doctorTList.size();
    }//get the row count based on doctor count stored in the system

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }//get column count based on the columns named in the Array

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {//extract information from each doctor, and it's (doctor object) attributes
        Object temp = null;
        if (columnIndex == 0) {
            temp = doctorTList.get(rowIndex).getName();
        } else if (columnIndex == 1) {
            temp = doctorTList.get(rowIndex).getSurName();
        } else if (columnIndex == 2) {
            temp = doctorTList.get(rowIndex).getDateOfBirth();
        } else if (columnIndex == 3) {
            temp = doctorTList.get(rowIndex).getMobileNumber();
        } else if (columnIndex == 4) {
            temp = doctorTList.get(rowIndex).getMedicalLicenseNo();
        } else if (columnIndex == 5) {
            temp = doctorTList.get(rowIndex).getSpecialisation();
        }
        return temp;
    }

    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }//get the name of the column

    public Class getColumnClass(int columnIndex) {//get the class of the date that spread under a specific column
        if (columnIndex == 2) {
            return DateTime.class;
        } else if (columnIndex == 3) {
            return Integer.class;
        } else {
            return String.class;
        }
    }
}
