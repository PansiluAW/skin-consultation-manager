package com.OOP.w19127880_Coursework.GUI;

import com.OOP.w19127880_Coursework.ConsoleApplication.Consultation;
import com.OOP.w19127880_Coursework.ConsoleApplication.DateTime;
import com.OOP.w19127880_Coursework.ConsoleApplication.Doctor;
import com.OOP.w19127880_Coursework.ConsoleApplication.WestminsterSkinConsultationManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AddConsultation extends JFrame implements Serializable {
    private int doctorMedicalLicenseNo;

    //declare JFrame components.
    private JPanel panel;
    private JLabel backButton;
    private JLabel imageUploadLabel;

    //JTextField for getting the user inputs as information required to add new consultation.
    private JTextField nameField = new JTextField("Sam"){{setForeground(Color.GRAY);}};
    private JTextField surNameField = new JTextField("Rodriguez"){{setForeground(Color.GRAY);}};
    private JTextField mobileNumberField = new JTextField("07XXXXXXXX"){{setForeground(Color.GRAY);}};
    private JTextField patientIdField = new JTextField("XXXXXXXXX"){{setForeground(Color.GRAY);}};
    private JTextField costField = new JTextField("£XXX"){{setForeground(Color.GRAY);}};
    private JTextArea notesArea = new JTextArea("Leave Your Notes Here"){{setForeground(Color.GRAY);}};

    // JLabels to display the choosen images to the user as confirmation
    private JLabel imageLabel1 = new JLabel();
    private JLabel imageLabel2 = new JLabel();
    private JLabel imageLabel3 = new JLabel();
    // JFileChooser to get the user images into the program.
    private JFileChooser fileChooser = new JFileChooser();

    //JTextField for getting the user inputs as information required to add new consultation.
    private JTextField dateField = new JTextField("DD"){{setForeground(Color.GRAY);}};
    private JTextField monthField = new JTextField("MM"){{setForeground(Color.GRAY);}};
    private JTextField yearField = new JTextField("YYYY"){{setForeground(Color.GRAY);}};
    private JTextField dateConsField = new JTextField("DD"){{setForeground(Color.GRAY);}};
    private JTextField monthConsField = new JTextField("MM"){{setForeground(Color.GRAY);}};
    private JTextField yearConsField = new JTextField("YYYY"){{setForeground(Color.GRAY);}};
    private JTextField hoursConsField = new JTextField("HH"){{setForeground(Color.GRAY);}};
    private JTextField minutesConsField = new JTextField("MM"){{setForeground(Color.GRAY);}};

    //WestminsterSkinConsultationManager instance order to access doctor information saved to the system and related operations.
    private static final WestminsterSkinConsultationManager MANAGER = new WestminsterSkinConsultationManager();
    private static List<Doctor> doctorList = MANAGER.getDoctorList(); // ArrayList for taking the currently saved doctors.
    private List<Consultation> consultationList = new ArrayList<>(); // ArrayList for storing the consultation to the system.
    private String[] availDoctorList; //available doctors currently available in the system get updated into the Arrya.
    private JComboBox<String> doctorListing; // JComboBox for updating the user with available doctord and allowing them to choose doctors.

    //get the user input data for further processes.
    private String userName;
    private String userSurName;
    private String userDate;
    private String userMonth;
    private String userYear;
    private String userMobileNumber;
    private String userPatientId;
    private int userDoctorListing;
    private String userDateCons;
    private String userMonthCons;
    private String userYearCons;
    private String userHourCons;
    private String userMinuteCons;
    private String userCost;
    private String userNotes;
    String encryptedUserNotes;
    List<Doctor> updatedDoctorList;

    //stored user selected images as BufferedImages for conversions.
    BufferedImage image1;
    BufferedImage image2;
    BufferedImage image3;
    BufferedImage[] imageList = new BufferedImage[3];// Array for accessing the BufferedImages.

    public AddConsultation() {
        super("Westminster Skin Consultation Manager | Add New Doctor Consultation");//display the window title

        //add new panels for layout management.
        panel = new JPanel(new GridLayout(12,2,5,5));
        JPanel notesPanel = new JPanel(new GridLayout(2,1));
        JPanel imagesPanel = new JPanel(new GridLayout(1,2,5,0));
        JPanel imageUploads = new JPanel(new GridLayout(1,3));

        //add labels to make the user aware about the requirements of the TextFields next to them.
        JLabel nameLabel = new JLabel("Name : ");
        JLabel surNameLabel = new JLabel("Surname : ");
        JLabel dateOfBirthLabel = new JLabel("Date of Birth : ");
        JLabel mobileNumberLabel = new JLabel("Mobile Number : ");
        JLabel patientIdLabel = new JLabel("Patient ID");
        JLabel consultantTimeLabel = new JLabel("Consultation Time (Day/Month/Year/Hours/Minutes): ");
        JLabel costLabel =  new JLabel("Consultation Cost (£) : ");
        JLabel notesLabel =  new JLabel("Additional Notes : ");
        JLabel doctorLabel = new JLabel("Consult Doctor : ");

        //update the array of options for JComboBox on the doctors available at the centre.
        if (!doctorList.isEmpty()) {
            availDoctorList = new String[doctorList.size()];
        }else {availDoctorList = new String[1];}
        //update the representation of the available doctors in the JComboBox
        int count = 0;
        for (Doctor doctor : doctorList) {
            availDoctorList[count] = "Dr. " + doctor.getName() + " " + doctor.getSurName();
            count++;
        }
        //update the JComboBox options when no doctors available at the centre.
        if (availDoctorList[0] == null){
            availDoctorList[0] = "No Doctors Available";
        }
        doctorListing = new JComboBox<String>(availDoctorList);// update JComboBox with the option with initialization
        //panel for managing the date of birth text input fields.
        JPanel dobPanel = new JPanel(new GridLayout(1,3,5,5));
        dobPanel.add(dateField);
        dobPanel.add(monthField);
        dobPanel.add(yearField);

        // panel for managing the consultation time field inputs
        JPanel consultationTimePanel = new JPanel(new GridLayout(1,5,5,5));
        consultationTimePanel.add(dateConsField);
        consultationTimePanel.add(monthConsField);
        consultationTimePanel.add(yearConsField);
        consultationTimePanel.add(hoursConsField);
        consultationTimePanel.add(minutesConsField);
        //panels for JButton management
        JPanel addConsultationButtonPanel = new JPanel(new GridLayout(1,3));
        JPanel clearFormButtonPanel = new JPanel(new GridLayout(1,3));

        //update the main panel with the components to show on the frame.
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(surNameLabel);
        panel.add(surNameField);
        panel.add(dateOfBirthLabel);
        panel.add(dobPanel);
        panel.add(mobileNumberLabel);
        panel.add(mobileNumberField);
        panel.add(patientIdLabel);
        panel.add(patientIdField);
        panel.add(doctorLabel);
        panel.add(doctorListing);
        panel.add(consultantTimeLabel);
        panel.add(consultationTimePanel);
        panel.add(costLabel);
        panel.add(costField);
        panel.add(notesPanel);
        panel.add(imagesPanel);
        panel.add(new JLabel());//empty labels to fill up the specific location of the component layout
        panel.add(new JLabel());//empty labels to fill up the specific location of the component layout
        panel.add(addConsultationButtonPanel);
        panel.add(clearFormButtonPanel);
        panel.add(new JLabel());//empty labels to fill up the specific location of the component layout
        panel.add(new JLabel());//empty labels to fill up the specific location of the component layout
        //JButton for adding images according to user's choice.
        JButton addImagesButton = new JButton("Add Images"){{setBackground(new Color(94, 159, 98));setOpaque(true); setForeground(new Color(255,255,255));}};
        addImagesButton.setFocusable(false);// remove focus that appears on the JButton automatically
        ImageChooserButtonListener imageChooserButtonListener = new ImageChooserButtonListener();//set up button listener for "add image" button
        addImagesButton.addActionListener(imageChooserButtonListener); // add listener object to "Add Images" button
        imageUploadLabel = new JLabel("Upload Images:"); //display upload images with the JLabel
        //panels to manage the components related to "Add Images" by the user
        JPanel imageUploadInfoSortPanel = new JPanel(new GridLayout(1,2));
        JPanel imageUploadInfoGuidePanel = new JPanel(new GridLayout(2,1));
        imageUploadInfoSortPanel.add(imageUploadLabel);// add components on the panels setup
        imageUploadInfoSortPanel.add(addImagesButton);
        imageUploadInfoGuidePanel.add(new JLabel());
        imageUploadInfoGuidePanel.add(imageUploadInfoSortPanel);
        imagesPanel.add(imageUploadInfoGuidePanel);
        imagesPanel.add(imageUploads);
        JScrollPane scrollPane = new JScrollPane(notesArea);//scroll pane taking inputs for the notes from the user.
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED); //make the user notes input pane scrollable
        notesPanel.add(notesLabel);
        notesPanel.add(scrollPane);
        notesArea.setLineWrap(true);
        //add image previewing labels to the relevant panel
        imageUploads.add(imageLabel1);
        imageUploads.add(imageLabel2);
        imageUploads.add(imageLabel3);

        //set colors to the panel matching background colors
        imageUploadInfoSortPanel.setBackground(new Color(219, 243, 220));
        notesPanel.setBackground(new Color(219, 243, 220));
        imageUploads.setBackground(new Color(219, 243, 220));
        dobPanel.setBackground(new Color(219, 243, 220));
        consultationTimePanel.setBackground(new Color(219, 243, 220));
        imageUploadInfoGuidePanel.setBackground(new Color(219, 243, 220));
        addConsultationButtonPanel.setBackground(new Color(219, 243, 220));
        clearFormButtonPanel.setBackground(new Color(219, 243, 220));
        panel.setBackground(new Color(219, 243, 220));

        //set up button listener for clear form function taking all the text fields into consideration
        ClearTextListener clearTextListener = new ClearTextListener();
        nameField.addMouseListener(clearTextListener);
        surNameField.addMouseListener(clearTextListener);
        dateField.addMouseListener(clearTextListener);
        monthField.addMouseListener(clearTextListener);
        yearField.addMouseListener(clearTextListener);
        mobileNumberField.addMouseListener(clearTextListener);
        patientIdField.addMouseListener(clearTextListener);
        dateConsField.addMouseListener(clearTextListener);
        monthConsField.addMouseListener(clearTextListener);
        yearConsField.addMouseListener(clearTextListener);
        hoursConsField.addMouseListener(clearTextListener);
        minutesConsField.addMouseListener(clearTextListener);
        costField.addMouseListener(clearTextListener);
        notesArea.addMouseListener(clearTextListener);

        //set up screen header with customizations
        Font font = new Font("Dialog", Font.BOLD, 28);
        JLabel subTitleLabel = new JLabel("Add New Doctor Consultation", SwingConstants.CENTER){{setFont(font);setForeground(new Color(255, 255, 255));setBackground(new Color(94, 159, 98));setOpaque(true);}};
        subTitleLabel.setBackground(new Color(94, 159, 98));
        subTitleLabel.setOpaque(true);//set background visible
        JPanel emptyPanel1 = new JPanel();//empty panels to fit the layout manager spaces
        JPanel emptyPanel2 = new JPanel();//empty panels to fit the layout manager spaces
        //customizations for the center set up components in the main panel on the frame.
        emptyPanel1.setBackground(new Color(219, 243, 220));
        emptyPanel2.setBackground(new Color(219, 243, 220));
        emptyPanel1.setPreferredSize(new Dimension(150,150));
        emptyPanel2.setPreferredSize(new Dimension(150,150));
        JPanel titlePanel = new JPanel(new GridLayout(1,1));
        //add buttons for functionality
        JButton addConsultation = new JButton("Add Consultation"){{setBackground(new Color(94, 159, 98));setOpaque(true); setForeground(new Color(255,255,255));}};
        JButton clearInfoButton = new JButton("Clear This"){{setBackground(new Color(94, 159, 98));setOpaque(true); setForeground(new Color(255,255,255));}};
        addConsultationButtonPanel.add(new JLabel());//empty labels to fill the spaces for layout management
        addConsultationButtonPanel.add(new JLabel());//empty labels to fill the spaces for layout management
        addConsultationButtonPanel.add(addConsultation);
        clearFormButtonPanel.add(clearInfoButton);
        clearFormButtonPanel.add(new JLabel());//empty labels to fill the spaces for layout management
        clearFormButtonPanel.add(new JLabel());//empty labels to fill the spaces for layout management

        //set up back button icon for switching back to program home screen.
        backButton = new JLabel(""){{setBackground(new Color(94, 159, 98));setOpaque(true);}};
        backButton.setHorizontalAlignment(JLabel.LEFT);//position the back button on the frame
        JPanel subTitlePanel = new JPanel(new FlowLayout()){{setBackground(new Color(94, 159, 98));setOpaque(true);}}; // panel for managing screen header content
        subTitleLabel.setPreferredSize(new Dimension(1000,150));
        subTitlePanel.add(backButton);
        subTitlePanel.add(subTitleLabel);
        titlePanel.add(subTitlePanel);

        //set the size of the buttons
        addConsultation.setPreferredSize(new Dimension(150,50));
        clearInfoButton.setPreferredSize(new Dimension(150,50));

        //add panels with the components to the main frame according to layout management "BoarderLayout"
        add(titlePanel, BorderLayout.NORTH);
        add(emptyPanel1, BorderLayout.WEST);
        add(emptyPanel2, BorderLayout.EAST);
        add(panel, BorderLayout.CENTER);

        //set up listener object for back button functionality
        BackButtonListener backButtonListener = new BackButtonListener();
        backButton.addMouseListener(backButtonListener); //add listener object for back button
        ImageIcon imageIconLogo = new ImageIcon("src/com/OOP/w19127880_Coursework/GUI/Images/BackButton.png"); //setting the image to appear as the back button icon
        Image imageLogo = imageIconLogo.getImage();
        Image newImageLogo = imageLogo.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        backButton.setLocation(0,0);
        backButton.setIcon(new ImageIcon(newImageLogo));
        addConsultation.setFocusable(false); // remove focus that appears in JButton by default
        clearInfoButton.setFocusable(false); // remove focus that appears in JButton by default

        //customizations on the text field components matching the theme
        nameField.setBackground(new Color(190,216,192));
        surNameField.setBackground(new Color(190,216,192));
        dateField.setBackground(new Color(190,216,192));
        monthField.setBackground(new Color(190,216,192));
        yearField.setBackground(new Color(190,216,192));
        mobileNumberField.setBackground(new Color(190,216,192));
        patientIdField.setBackground(new Color(190,216,192));
        doctorListing.setBackground(new Color(190,216,192));
        dateConsField.setBackground(new Color(190,216,192));
        monthConsField.setBackground(new Color(190,216,192));
        yearConsField.setBackground(new Color(190,216,192));
        hoursConsField.setBackground(new Color(190,216,192));
        minutesConsField.setBackground(new Color(190,216,192));
        costField.setBackground(new Color(190,216,192));
        notesArea.setBackground(new Color(190,216,192));

        //Extracting data entered by user
        FormButtonListener formButtonListener = new FormButtonListener();
        addConsultation.addActionListener(formButtonListener);

        //clear the form to the default appearance for refilling the form by user
        ClearButtonListener clearButtonListener = new ClearButtonListener();
        clearInfoButton.addActionListener(clearButtonListener);

        //set up the frame, window appearance and functionalities
        this.setSize(1200,700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public class FormButtonListener implements ActionListener {
        //boolean attributes to check the validity of the user inputs
        private boolean validNameFormat = false;
        private boolean validSurNameFormat = false;
        private boolean validDateFormat = false;
        private boolean validMonthFormat = false;
        private boolean validYearFormat = false;
        private boolean validMobileNumberFormat = false;
        private boolean validPatientIdFormat = false;
        private boolean validDoctorAvailable = false;
        private boolean validDateConsFormat = false;
        private boolean validMonthConsFormat = false;
        private boolean validYearConsFormat = false;
        private boolean validHourConsFormat = false;
        private boolean validMinutesConsFormat = false;
        private boolean validCostFormat = false;
        private boolean checkFieldValues = true;
        private boolean displayError;//boolean attributed to check if any error messages need to displayed to make the user alert
        private boolean noErrorDetect;//boolean attribute to make sure that no user input errors are detected from the current inputs
        private boolean consultationAdded;//boolean attribute to confirm a new consultation is added

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            consultationList.clear();// clear the currently exisiting data to reassign the values retrieved from the save data
            loadConsultationData();// load consultation save data back into the file
            // initialize variables
            displayError = true;
            noErrorDetect = false;

            //check if the user inputs fields are not empty tp proceed
            if (!nameField.getText().isEmpty() && !surNameField.getText().isEmpty() && !dateField.getText().isEmpty() && !monthField.getText().isEmpty() && !yearField.getText().isEmpty() && !mobileNumberField.getText().isEmpty() && !patientIdField.getText().isEmpty() && !dateConsField.getText().isEmpty() && !monthConsField.getText().isEmpty() && !yearConsField.getText().isEmpty() && !hoursConsField.getText().isEmpty() && !minutesConsField.getText().isEmpty() && !costField.getText().isEmpty()) {
                //check if the user inputs matches the requirements of the program and update the relevant variable to indicate the invalidity
                if (nameField.getText().matches("[a-zA-Z]+")) {//check name validity
                    validNameFormat = true; //update boolean value accordingly for further use of the program
                }
                if (surNameField.getText().matches("[a-zA-Z]+")) {//check surname validity
                    validSurNameFormat = true;//update boolean value accordingly for further use of the program
                }
                if (Pattern.matches("[0-9]+", dateField.getText())) {//check date field of date of birth validity
                    if (0 < Integer.parseInt(dateField.getText()) && Integer.parseInt(dateField.getText()) <= 31) {
                        validDateFormat = true;//update boolean value accordingly for further use of the program
                    }
                }
                if (Pattern.matches("[0-9]+", monthField.getText())) {//check month field of date of birth validity
                    if (0 < Integer.parseInt(monthField.getText()) && Integer.parseInt(monthField.getText()) <= 12) {
                        validMonthFormat = true;//update boolean value accordingly for further use of the program
                    }
                }
                if (Pattern.matches("[0-9]+", yearField.getText())) {//check year field of date of birth validity
                    if (1000 <= Integer.parseInt(yearField.getText()) && Integer.parseInt(yearField.getText()) <= 2023) {
                        validYearFormat = true;//update boolean value accordingly for further use of the program
                    }
                }
                if (Pattern.matches("[0-9]+", mobileNumberField.getText()) && mobileNumberField.getText().length() == 10) {//check mobile number validity
                    validMobileNumberFormat = true;//update boolean value accordingly for further use of the program
                }
                if (Pattern.matches("[0-9]+", patientIdField.getText()) && patientIdField.getText().length() == 9) {//check patient ID validity
                    validPatientIdFormat = true;//update boolean value accordingly for further use of the program
                }
                if (Pattern.matches("[0-9]+", dateConsField.getText())) {
                    if (0 < Integer.parseInt(dateConsField.getText()) && Integer.parseInt(dateConsField.getText()) <= 31) {//check date field of consultation time validity
                        validDateConsFormat = true;//update boolean value accordingly for further use of the program
                    }
                }
                if (Pattern.matches("[0-9]+", monthConsField.getText())) {
                    if (0 < Integer.parseInt(monthConsField.getText()) && Integer.parseInt(monthConsField.getText()) <= 12) {//check month field of consultation time validity
                        validMonthConsFormat = true;//update boolean value accordingly for further use of the program
                    }
                }
                if (Pattern.matches("[0-9]+", yearConsField.getText())) {//check year field of consultation time validity
                    if (2023 <= Integer.parseInt(yearConsField.getText()) && Integer.parseInt(yearConsField.getText()) <= 9999) {
                        validYearConsFormat = true;//update boolean value accordingly for further use of the program
                    }
                }
                if (!doctorListing.getItemAt(0).equals("No Doctors Available")) {//check if the combo box displays "No Doctors Available" based on the program data
                    validDoctorAvailable = true;//update boolean value accordingly for further use of the program
                }
                if (Pattern.matches("[0-9]+", hoursConsField.getText())) {////check hours field of consultation time validity
                    if (0 <= Integer.parseInt(hoursConsField.getText()) && Integer.parseInt(hoursConsField.getText()) <= 23) {
                        validHourConsFormat = true;//update boolean value accordingly for further use of the program
                    }
                }
                if (Pattern.matches("[0-9]+", minutesConsField.getText())) {//check minutes field of consultation time validity
                    if (0 <= Integer.parseInt(minutesConsField.getText()) && Integer.parseInt(minutesConsField.getText()) <= 60) {
                        validMinutesConsFormat = true;//update boolean value accordingly for further use of the program
                    }
                }
                if (Pattern.matches("[0-9]+", costField.getText())) {//check if the cost field input validity
                    validCostFormat = true;//update boolean value accordingly for further use of the program
                }
                checkFieldValues = true;// update boolean value for proceeding further with the user inputs
            } else {// display alert message to the user when the form field is empty.
                displayErrorMessage("Form is still incomplete.");
                //update boolean value for making the program aware not to check the inputs further in the program until user enters all valid inputs
                checkFieldValues = false;
                noErrorDetect = false;
            }

            //proceed to alert the user on invalid inputs after the inputs are given to the system
            if (checkFieldValues) {
                //display error messages based on the boolean values updated at each loop of user input check
                if (validNameFormat == false) {//check if the user needs to be alerted on name input
                    if (displayError) {
                        //alert user on invalid input given and update boolean value to default value
                        displayErrorMessage("Invalid input for patient's name");
                        displayError = false;
                    }
                }
                if (validSurNameFormat == false) {//check if the user needs to be alerted on surname input
                    if (displayError) {
                        //alert user on invalid input given and update boolean value to default value
                        displayErrorMessage("Invalid input for patient's surname");
                        displayError = false;
                    }
                }
                if (validDateFormat == false || validMonthFormat == false || validYearFormat == false) {//check if the user needs to be alerted on date of birth related inputs
                    if (displayError) {
                        //alert user on invalid input given and update boolean value to default value
                        displayErrorMessage("Invalid input for patient's date of birth");
                        displayError = false;
                    }
                }
                if (validMobileNumberFormat == false) {//check if the user needs to be alerted on mobile number input
                    if (displayError) {
                        //alert user on invalid input given and update boolean value to default value
                        displayErrorMessage("Invalid input for patient's mobile number");
                        displayError = false;
                    }
                }
                if (validPatientIdFormat == false) {//check if the user needs to be alerted on patient ID input
                    if (displayError) {
                        //alert user on invalid input given and update boolean value to default value
                        displayErrorMessage("Invalid input for patient's ID");
                        displayError = false;
                    }
                }
                if (validDoctorAvailable == false) {//check if the user needs to be alerted on doctor not available
                    if (displayError) {
                        //alert user on invalid input given and update boolean value to default value
                        displayErrorMessage("No doctor available at the moment.");
                        displayError = false;
                    }
                }
                if (validDateConsFormat == false || validMonthConsFormat == false || validYearConsFormat == false || validHourConsFormat == false || validMinutesConsFormat == false) {//check if the user needs to be alerted on consultation time related inputs
                    if (displayError) {
                        //alert user on invalid input given and update boolean value to default value
                        displayErrorMessage("Invalid input for consultation time");
                        displayError = false;
                    }
                }
                if (validCostFormat == false) {//check if the user needs to be alerted on cost input
                    if (displayError) {
                        //alert user on invalid input given and update boolean value to default value
                        displayErrorMessage("Invalid input for consultation cost");
                        displayError = false;
                    }
                }
            }

            //changes the color of the text fields based on the input validity given by the user and make the user aware on which inputs needs attention
            if (validNameFormat == false){ //if name input is valid
                nameField.setBackground(new Color(241,120,161));
            }else {//if name input is invalid
                nameField.setBackground(new Color(196, 246, 162));
            }if (validSurNameFormat == false){ //if surname input is valid
                surNameField.setBackground(new Color(241,120,161));
            }else{//if surname input is valid
                surNameField.setBackground(new Color(196,246,162));
            }if (validDateFormat == false){//if date input of date of birth is valid
                dateField.setBackground(new Color(241,120,161));
            }else{//if date input of date of birth is invalid
                dateField.setBackground(new Color(196,246,162));
            }if (validMonthFormat == false){//if month input of date of birth is valid
                monthField.setBackground(new Color(241,120,161));
            }else{//if month input of date of birth is invalid
                monthField.setBackground(new Color(196,246,162));
            }if (validYearFormat == false){//if year input of date of birth is valid
                yearField.setBackground(new Color(241,120,161));
            }else{//if year input of date of birth is invalid
                yearField.setBackground(new Color(196,246,162));
            }if (validMobileNumberFormat == false){//if mobile number input is valid
                mobileNumberField.setBackground(new Color(241,120,161));
            }else{//if mobile number input is invalid
                mobileNumberField.setBackground(new Color(196,246,162));
            }if (validPatientIdFormat == false){//if patient ID input is valid
                patientIdField.setBackground(new Color(241,120,161));
            }else{//if patient ID input is invalid
                patientIdField.setBackground(new Color(196,246,162));
            }if (validDateConsFormat == false){//if date input of consultation time is valid
                dateConsField.setBackground(new Color(241,120,161));
            }else{//if date input of consultation time is invalid
                dateConsField.setBackground(new Color(196,246,162));
            }if (validMonthConsFormat == false){//if month input of consultation time is valid
                monthConsField.setBackground(new Color(241,120,161));
            }else{//if month input of consultation time is invalid
                monthConsField.setBackground(new Color(196,246,162));
            }if (validYearConsFormat == false){//if year input of consultation time is valid
                yearConsField.setBackground(new Color(241,120,161));
            }else{//if year input of consultation time is invalid
                yearConsField.setBackground(new Color(196,246,162));
            }if (validHourConsFormat == false){//if hour input of consultation time is valid
                hoursConsField.setBackground(new Color(241,120,161));
            }else{//if hour input of consultation time is invalid
                hoursConsField.setBackground(new Color(196,246,162));
            }if (validMinutesConsFormat == false){//if minutes input of consultation time is valid
                minutesConsField.setBackground(new Color(241,120,161));
            }else{//if minutes input of consultation time is invalid
                minutesConsField.setBackground(new Color(196,246,162));
            }if (validCostFormat == false){//if cost input is valid
                costField.setBackground(new Color(241,120,161));
            }else{//if cost input is invalid
                costField.setBackground(new Color(196,246,162));
            }

            //check if all the user inputs are in valid format to proceed further
            if (validNameFormat && validSurNameFormat && validDateFormat && validMonthFormat && validYearFormat && validMobileNumberFormat && validPatientIdFormat && validDoctorAvailable && validDateConsFormat && validMonthConsFormat && validYearConsFormat && validHourConsFormat && validMinutesConsFormat && validCostFormat) {
                noErrorDetect = true;//update boolean value on no inputs are invalid condition
            }

            // update the boolean value for each input to start the procedure on each loop
            validNameFormat = false;
            validSurNameFormat = false;
            validDateFormat = false;
            validMonthFormat = false;
            validYearFormat = false;
            validMobileNumberFormat = false;
            validPatientIdFormat = false;
            validDoctorAvailable = false;
            validDateConsFormat = false;
            validMonthConsFormat = false;
            validYearConsFormat = false;
            validHourConsFormat = false;
            validMinutesConsFormat = false;
            validCostFormat = false;

            //extract user inputs from the text field
            userName = nameField.getText();
            userSurName = surNameField.getText();
            userDate = dateField.getText();
            userMonth = monthField.getText();
            userYear = yearField.getText();
            userMobileNumber = mobileNumberField.getText();
            userPatientId = patientIdField.getText();
            userDoctorListing = doctorListing.getSelectedIndex();
            userDateCons = dateConsField.getText();
            userMonthCons = monthConsField.getText();
            userYearCons = yearConsField.getText();
            userHourCons = hoursConsField.getText();
            userMinuteCons = minutesConsField.getText();
            userCost = costField.getText();
            userNotes = notesArea.getText();

            try {//error handler for exceptions that may occur through the process
                if (noErrorDetect) {// if no error is detected from the user given user inputs
                    // declare a new Datetime objects with the relevant data for it, which is extracted from the user
                    DateTime consultTimeSlot = new DateTime(Integer.parseInt(userDateCons), Integer.parseInt(userMonthCons), Integer.parseInt(userYearCons), Integer.parseInt(userHourCons), Integer.parseInt(userMinuteCons));

                    //new ArrayList for making update to the doctors based on their availability at a certain specific time slot
                    updatedDoctorList = new ArrayList<>();
                    //extract the doctors currently available into the new Array List
                    updatedDoctorList.addAll(doctorList);
                    boolean doctorUnavailable = false;// set the boolean variables to its default values

                    if (!updatedDoctorList.isEmpty()) {//check if the doctors are available or not to be checked further on their availability
                        Doctor doctor = updatedDoctorList.get(userDoctorListing); // get the doctor object from the doctor list based on the index of combo box choice given by user

                        if (consultationList == null) {//check if the consultation list is null to proceed
                            consultationList = new ArrayList<>();

                        }

                        if (consultationList.isEmpty()) {//check if the consultation list is empty to assign the doctor without any further checking
                            doctorMedicalLicenseNo = doctor.getMedicalLicenseNo();//get the medical license number of the doctor directly without going through conditions on check the availability
                        } else {//proceed if the list contains consultations to check if the doctor is assigned at a specific time slot which is taken by another consultation
                            for (Consultation consultation : consultationList) {//check each consultation added to the system
                                if (consultation.getDoctorMedicalLicenseNo() == doctor.getMedicalLicenseNo()) {//check if the doctor appears in a previous consultation inorder to check furthermore
                                    if (consultation.getConsultationDateTime().equals(consultTimeSlot)) {//check if the consultation time slot is same as current consultation time slot by patient
                                        doctorUnavailable = true;//confirm the doctor unavailability by updating the boolean value
                                        //make changes to the doctor list as the current chosen doctor is unavailable
                                        if (!updatedDoctorList.isEmpty()) {
                                            int indexOfDoctor = (updatedDoctorList.indexOf(doctor));//get the index of the doctor that is currently unavailable
                                            if (indexOfDoctor != -1) {//proceed if the index exists
                                                updatedDoctorList.set(indexOfDoctor, null);//set the current doctor object at the index location of the Array List to null
                                            }
                                        }
                                    } else {//if the consultation time is different and doctor is available to be assigned
                                        doctorUnavailable = false;
                                    }
                                }
                            }
                        }

                        if (doctorUnavailable) {//if the current doctor chosen by the user is unavailable
                            searchLoop://loop name
                            while (true) {
                                for (Doctor doctorAvailable : updatedDoctorList) {//loop through each available doctor in the list to check the doctor appoint-able as a replacement to the chosen doctor
                                    if (doctorAvailable != null) {//proceed only if the doctor object exists after assigning the doctor unavailable object index to null
                                        for (Consultation consultation : consultationList) {//loop through the consultations to check if the doctor appears in any time slot which matches the current time slot of consultation
                                            if (consultation.getDoctorMedicalLicenseNo() == doctorAvailable.getMedicalLicenseNo()) {//check if consultation doctor and the currently available doctor is the same
                                                if (consultation.getConsultationDateTime().equals(consultTimeSlot)) {//check if the consultation time matches the current consultation time
                                                    int indexOfDoctor = (updatedDoctorList.indexOf(doctorAvailable));//if the doctor matches, remove the doctor from the list to assign a another onw
                                                    if (indexOfDoctor != -1) {//proceed if the index exists
                                                        updatedDoctorList.set(indexOfDoctor, null);//migrate the object to null as the doctor is already taken
                                                        continue searchLoop;//jump to next check loop
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                break;//break main loop after search is over
                            }

                            if (doctor.getMedicalLicenseNo() != 0) {//check if the doctor medical license number is not 0
                                for (Doctor doctorFinal : updatedDoctorList) {//loop through each doctor object to assign a doctor to the consultation
                                    if (doctorFinal != null) {//proceed if the current index is not null
                                        doctorMedicalLicenseNo = doctorFinal.getMedicalLicenseNo(); //choose the doctor to be assigned to the current consultation by extracting its medical license number
                                        //alert user on the assigned new doctor for the consultation
                                        displayErrorMessage("Doctor's consultation time slot is occupied. Dr. " + doctorFinal.getName() + " " + doctorFinal.getSurName() + " has been appointed for the consultation");
                                        break;//break out of loop after assigning doctor
                                    }
                                }
                            }
                        } else if (doctorUnavailable == false) {//if the doctor is available
                            if (doctor.getMedicalLicenseNo() != 0) {//proceed further if the medical license number of the doctor is not 0
                                doctorMedicalLicenseNo = doctor.getMedicalLicenseNo();// get the doctor medical license number
                            }
                        } else {//dislay the alert message to the user on the unavailability of a doctor to be assigned on the chosen time slot
                            displayErrorMessage("Doctor's consultation time slot is occupied. No available doctor to consult at the moment");
                        }

                        if (doctorMedicalLicenseNo != 0) {//proceed if the medical license is not 0
                            if (userNotes.equals("Leave Your Notes Here")){
                                userNotes = "-";// change the notes text if the user hasn't added any notes
                            }

                            //declare encryption decryption objects to be used for their functionality
                            NotesEncryptionDecryption notesEncryptionDecryption = new NotesEncryptionDecryption(); // for notes encryption decryption
                            ImageEncryptionDecryption imageEncryptionDecryption = new ImageEncryptionDecryption(); //for images encryption decryption
                            byte[][] encryptedImageList = new byte[3][];//byte list for the 3 encrypted images
                            int count = 0;
                            if (imageList[0] != null) {//proceed if at least one image is added to the system
                                for (BufferedImage image : imageList) {//loop through each image in the list for encryption
                                    encryptedImageList[count] = imageEncryptionDecryption.encrypt(image, "9982DxW");// encrypt the image and allocate to the relevant index position in array
                                    count++;
                                }
                            }

                            encryptedUserNotes = notesEncryptionDecryption.encrypt(userNotes,"9896WxD"); //encrypt the notes input or the default text
                            //create a consultation object with the valid inputs and encrypted data
                            Consultation consultation = new Consultation(userName, userSurName, new DateTime(Integer.parseInt(userDate), Integer.parseInt(userMonth), Integer.parseInt(userYear)), Integer.parseInt(userMobileNumber), userPatientId, consultTimeSlot, Integer.parseInt(userCost), encryptedUserNotes, doctorMedicalLicenseNo, encryptedImageList);
                            if (!(consultationList.contains(consultation))) {//check if the current consultation already exists in the system
                                consultationList.add(consultation);//add to consultation Array List
                                saveConsultationData();//save the updated progress
                                consultationAdded = true;//update consultation status boolean
                            } else {//display alert message if the consultation already exists in the system
                                displayErrorMessage("Consultation already exists already in the system.");
                            }
                        } else//display alert message if the no doctor is available to be assigned to the consultation
                            displayErrorMessage("Doctor's consultation time slot is occupied. No available doctor to consult at the moment");
                    }
                }
            //set error handlers for common errors and specific NullPointerException and proceed accordingly
            }catch (NullPointerException exception){
                GUIApplication guiApplication = new GUIApplication();
                AddConsultation.this.dispose();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            if (consultationAdded) {//switch back to main screen if the new consultation is added to the system
                GUIApplication guiApplication = new GUIApplication();
                AddConsultation.this.dispose();
                displayErrorMessage("Consultation successfully added to the system.");//display the alert on the success of the process
                consultationAdded = false;//set to default boolean
            }
        }


        public void saveConsultationData(){
            /*Title: Write and read an ArrayList object to a file in Java
                  Author: samderlust.com
                  Date: 24/12/2022
                  Code Version: 1.0
                  Availability: https://samderlust.com/dev-blog/java/write-read-arraylist-object-file-java*/

            try {
                //create file object with save data file
                File file = new File("src/com/OOP/w19127880_Coursework/SaveFiles/ConsultationSaveData.data");
                if (!file.exists()) {//create new file if file doesn't exist
                    file.createNewFile();
                }
                FileOutputStream writeData = new FileOutputStream(file);
                ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
                writeStream.writeObject(consultationList); //write object to file
                writeStream.flush();
                writeData.close();
                writeStream.close();
            }catch (FileNotFoundException e){//exception handler based alert to be displayed to the user
                System.out.println("Save file not found");
            }catch (IOException e){
                System.out.println("Error has occurred during process. Error: "+e);
            }
        }

        public void loadConsultationData(){
            try {
                //create file object with save data file
                File file = new File("src/com/OOP/w19127880_Coursework/SaveFiles/ConsultationSaveData.data");
                if (!file.exists()) {//create new file if file doesn't exist
                    file.createNewFile();
                }
                FileInputStream readData = new FileInputStream(file);
                ObjectInputStream readStream = new ObjectInputStream(readData);
                consultationList = (ArrayList<Consultation>) readStream.readObject(); //load save data back to the arrayList of doctor objects
                readStream.close();
            }catch (InvalidClassException e){
            }catch (Exception e) { // error handler for exception for only sending data with ObjectInputStream
            }
        }

        public void displayErrorMessage(String errorMessage){
            //customize the option pane that displays the alert message
            ImageIcon imageIconLogo = new ImageIcon("src/com/OOP/w19127880_Coursework/GUI/Images/WestminsterSkinConsultationLogo.png");
            Image imageLogo = imageIconLogo.getImage();
            Image newImageLogo = imageLogo.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
            UIManager.put("OptionPane.background", new ColorUIResource(174, 207, 176));
            UIManager.put("OptionPane.informationIcon",new ImageIcon(newImageLogo));//set Westminster Skin Consultation Centre logo
            UIManager.put("OptionPane.Button.background", new Color(174, 207, 176));
            JFrame errorFrame = new JFrame();
            JOptionPane.showMessageDialog(errorFrame,errorMessage,"WARNING",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public class ClearButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //set the text to a specific text on the text field separately as action occurs
            nameField.setText(null);
            nameField.setForeground(new Color(0,0,0));
            surNameField.setText(null);
            dateField.setText("DD");
            monthField.setText("MM");
            yearField.setText("YYYY");
            mobileNumberField.setText("07XXXXXXXX");
            patientIdField.setText("XXXXXXXXX");
            dateConsField.setText("DD");
            monthConsField.setText("MM");
            yearConsField.setText("YYYY");
            hoursConsField.setText("HH");
            minutesConsField.setText("MM");
            costField.setText("£XXX");
            notesArea.setText("Leave Your Notes Here");
        }
    }
    public class BackButtonListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            //switch to main window on label click
            GUIApplication guiApplication = new GUIApplication();
            Component source = (Component) mouseEvent.getSource();
            AddConsultation frame = (AddConsultation) SwingUtilities.windowForComponent(source);
            frame.dispose();
        }
    }

    public class ImageChooserButtonListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            /*Title: How to restrict file choosers in java to specific files?
            Author: MadProgrammer
            Date: 29/12/2022
            Code Version: 1.0
            Availability: https://stackoverflow.com/questions/18575655/how-to-restrict-file-choosers-in-java-to-specific-files*/
            FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Image Files", "jpeg","jpg","png");// file extension filter to show only image files to be chosed by user
            /*Title: Uploading multiple images with JFileChooser
            Author: Godriguez
            Date: 29/12/2022
            Code Version: 1.0
            Availability: https://stackoverflow.com/questions/36657082/uploading-multiple-images-with-jfilechooser*/
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));// setup fileChooser starting path
            fileChooser.setFileFilter(fileNameExtensionFilter);
            fileChooser.setMultiSelectionEnabled(true);
            int result = fileChooser.showOpenDialog(getParent());
            if (result == JFileChooser.APPROVE_OPTION){
                try{
                    /*Title: How to display an image that a user has selected on the JFrame using JavaSwing
                    Author: Andrew Thompson
                    Date: 29/12/2022
                    Code Version: 1.0
                `   Availability: https://stackoverflow.com/questions/67356005/how-to-display-an-image-that-a-user-has-selected-on-the-jframe-using-javaswing*/
                    File[] imageFiles = fileChooser.getSelectedFiles();
                    if (imageFiles.length>3){
                        //alert user upon choosing more than 3 (maximum limit) images
                        JOptionPane.showMessageDialog(null,"More than 3 images have been selected. Only the first 3 selections will be recorded.");
                    }
                    //set the images into the labels for quick preview
                    for (int fileCount = 0; fileCount< imageFiles.length; fileCount++){
                        BufferedImage imageUpload = ImageIO.read(imageFiles[fileCount]);
                        Image imageResized = imageUpload.getScaledInstance(imageLabel1.getWidth(),imageLabel1.getHeight(),Image.SCALE_SMOOTH);
                        if (fileCount ==0) {
                            image1 = imageUpload;
                            imageLabel1.setIcon(new ImageIcon(imageResized));
                        }else if (fileCount ==1) {
                            image2 = imageUpload;
                            imageLabel2.setIcon(new ImageIcon(imageResized));
                        }else if (fileCount ==2) {
                            image3 = imageUpload;
                            imageLabel3.setIcon(new ImageIcon(imageResized));
                        }
                    }
                    //allocate image into array positions for furthermore access
                    imageList[0] = image1;
                    imageList[1] = image2;
                    imageList[2] = image3;

                    //set image appear size as preferred
                    imageLabel1.setPreferredSize(new Dimension(200,200));
                    imageLabel2.setPreferredSize(new Dimension(200,200));
                    imageLabel3.setPreferredSize(new Dimension(200,200));
                }catch (IOException ioException){//throw exception in times of error
                    JOptionPane.showMessageDialog(null,"Error occurred during process. Please check whether the file exists or is not corrupted.");
                }
            }
        }
    }

    public class ClearTextListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            //clear the default text of the text field upon click on input area
            //change the text-field color from grey shade to black upon click
            if (mouseEvent.getSource() == nameField){
                nameField.setText(null);
                nameField.setForeground(new Color(0,0,0));
            }else if (mouseEvent.getSource() == surNameField){
                surNameField.setText(null);
                surNameField.setForeground(new Color(0,0,0));
            }else if (mouseEvent.getSource() == dateField){
                dateField.setText(null);
                dateField.setForeground(new Color(0,0,0));
            }else if (mouseEvent.getSource() == monthField){
                monthField.setText(null);
                monthField.setForeground(new Color(0,0,0));
            }else if (mouseEvent.getSource() == yearField){
                yearField.setText(null);
                yearField.setForeground(new Color(0,0,0));
            }else if (mouseEvent.getSource() == patientIdField){
                patientIdField.setText(null);
                patientIdField.setForeground(new Color(0,0,0));
            }else if (mouseEvent.getSource() == mobileNumberField){
                mobileNumberField.setText(null);
                mobileNumberField.setForeground(new Color(0,0,0));
            }else if (mouseEvent.getSource() == dateConsField){
                dateConsField.setText(null);
                dateConsField.setForeground(new Color(0,0,0));
            }else if (mouseEvent.getSource() == monthConsField){
                monthConsField.setText(null);
                monthConsField.setForeground(new Color(0,0,0));
            }else if (mouseEvent.getSource() == yearConsField){
                yearConsField.setText(null);
                yearConsField.setForeground(new Color(0,0,0));
            }else if (mouseEvent.getSource() == hoursConsField){
                hoursConsField.setText(null);
                hoursConsField.setForeground(new Color(0,0,0));
            }else if (mouseEvent.getSource() == minutesConsField){
                minutesConsField.setText(null);
                minutesConsField.setForeground(new Color(0,0,0));
            }else if (mouseEvent.getSource() == costField){
                costField.setText(null);
                costField.setForeground(new Color(0,0,0));
            }else if (mouseEvent.getSource() == notesArea){
                notesArea.setText(null);
                notesArea.setForeground(new Color(0,0,0));
            }
        }
    }


}
