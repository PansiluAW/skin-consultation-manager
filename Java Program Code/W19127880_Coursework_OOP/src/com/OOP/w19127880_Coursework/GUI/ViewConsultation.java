package com.OOP.w19127880_Coursework.GUI;

import com.OOP.w19127880_Coursework.ConsoleApplication.Consultation;
import com.OOP.w19127880_Coursework.ConsoleApplication.Doctor;
import com.OOP.w19127880_Coursework.ConsoleApplication.WestminsterSkinConsultationManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ViewConsultation extends JFrame {
    //declare constants of the object
    //to access the doctor list
    private final WestminsterSkinConsultationManager MANAGER = new WestminsterSkinConsultationManager();
    //to access notes encryption methods
    private final NotesEncryptionDecryption NOTES_ENCRYPTION_DECRYPTION = new NotesEncryptionDecryption();
    //declare components
    private final JButton DATA_RETRIEVER_BUTTON;
    private JLabel backButton;
    //declare JLabels for viewing the images uploaded by the user
    private JLabel image1Data = new JLabel();
    private JLabel image2Data = new JLabel();
    private JLabel image3Data = new JLabel();
    private JLabel notesData;//JLabel to view the notes
    private JComboBox<String> consultationListing;//JComboBox to choose from the consultation added into the system
    private String[] consultationListIds; //array to store the existing consultation information or message to be displayed
    private BufferedImage[] bufferedImages = new BufferedImage[3];//to store the extracted images from the consultation save
    private List<Consultation> consultationList = new ArrayList<>();

    public ViewConsultation() {
        super("Westminster Skin Consultation Manager | View Consultations");//display the window title
        loadConsultationData();//load consultation data back to the system

        //component to instruct and get input from the user
        JLabel promptLabel = new JLabel("Select Consultation") {{
            setFont(new Font("Dialog", Font.BOLD, 16));
            setBackground(new Color(235, 255, 240));
        }};

        if (!consultationList.isEmpty()){//proceed if the consultation list is not empty
            consultationListIds = new String[consultationList.size()];//set size of the array to the size of the consultation list inorder to display all in the JComboBox
        }else {consultationListIds = new String[1];}//declare the size of the array to 1 to show the "No Consultation Available" to the user

        int count = 0;
        for (Consultation consultation: consultationList){//loop through each consultation to set the informative title for each consultation in the options in the JComboBox
            consultationListIds[count] = (count+1)+". "+consultation.getPatient().getName()+" "+consultation.getPatient().getSurName()+" : "+consultation.getConsultationDateTime();
            count++;
        }
        if (consultationListIds[0] == null){//set the message to display in the JComboBox if no consultation are added to the system
            consultationListIds[0] = "No consultation available at the moment";
        }
        consultationListing = new JComboBox<String>(consultationListIds){{//set the array of option in JCombBox declaration
            setFont(new Font("Dialog", Font.BOLD, 14));//set a new font for JComboBox
        }};

        consultationListing.getEditor().getEditorComponent().setBackground(new Color(219,233,220));//customize the JComboBox on GUI theme

        //set up and customize the button for information viewing
        DATA_RETRIEVER_BUTTON = new JButton("Get Info") {{
            setBackground(new Color(94,159,98));
            setForeground(new Color(255,255,255));
        }};

        //set up panels for component management and customize them to suit GUI theme
        JPanel inputPanel = new JPanel(new GridLayout(4, 1)) {{
            setBackground(new Color(219, 243, 220));
        }};
        JPanel centerPanel = new JPanel(new GridLayout(3,3)){{
            setBackground(new Color(219, 243, 220));
        }};

        //set up window header with title and back button
        JLabel titleLabel = new JLabel("View Consultations", SwingConstants.CENTER) {{
            setFont(new Font("Dialog", Font.BOLD, 28));
            setForeground(new Color(255, 255, 255));
            setBackground(new Color(94, 159, 98));
            setOpaque(true);
        }};
        titleLabel.setHorizontalAlignment(JLabel.CENTER);//align the header title text

        //set up back button on the window header
        backButton = new JLabel("") {{
            setBackground(new Color(94, 159, 98));
            setOpaque(true);
        }};
        //set back button icon alignment on window header
        backButton.setHorizontalAlignment(JLabel.LEFT);
        JPanel titlePanel = new JPanel(new FlowLayout()) {{
            setBackground(new Color(94, 159, 98));
            setOpaque(true);
        }};
        //set the preferences on the widnow header
        titleLabel.setPreferredSize(new Dimension(1000, 150));

        //add the panels with the components to the frame of the window and to the relevant panels
        add(titlePanel, BorderLayout.NORTH);
        titlePanel.add(backButton);
        titlePanel.add(titleLabel);

        inputPanel.add(promptLabel);
        inputPanel.add(consultationListing);
        inputPanel.add(DATA_RETRIEVER_BUTTON);
        inputPanel.add(new JLabel());

        promptLabel.setHorizontalAlignment(SwingConstants.CENTER);//center align the prompt text label

        //set label background customizations based on the GUI theme when adding to the respective panel
        centerPanel.add(new JLabel() {{
            setBackground(new Color(219, 243, 220));
        }});
        centerPanel.add(new JLabel() {{
            setBackground(new Color(219, 243, 220));
        }});
        centerPanel.add(new JLabel() {{
            setBackground(new Color(219, 243, 220));
        }});
        centerPanel.add(new JLabel() {{
            setBackground(new Color(219, 243, 220));
        }});
        centerPanel.add(inputPanel);
        centerPanel.add(new JLabel() {{
            setBackground(new Color(219, 243, 220));
        }});
        centerPanel.add(new JLabel() {{
            setBackground(new Color(219, 243, 220));
        }});
        centerPanel.add(new JLabel() {{
            setBackground(new Color(219, 243, 220));
        }});
        centerPanel.add(new JLabel() {{
            setBackground(new Color(219, 243, 220));
        }});
        add(centerPanel,BorderLayout.CENTER);//add central panel to frame

        //set up event handler for the button "Get Info"
        GetInfoEventHandler getInfoEventHandler = new GetInfoEventHandler();
        DATA_RETRIEVER_BUTTON.addActionListener(getInfoEventHandler);//add event handler to the button
        DATA_RETRIEVER_BUTTON.setFocusable(false);//remove focus of the button which is set at default

        //set up event handler for back button
        BackButtonListener backButtonListener = new BackButtonListener();
        backButton.addMouseListener(backButtonListener);//add back button listener to the button
        ImageIcon imageIconLogo = new ImageIcon("src/com/OOP/w19127880_Coursework/GUI/Images/BackButton.png");//image icon for back button
        Image imageLogo = imageIconLogo.getImage();
        Image newImageLogo = imageLogo.getScaledInstance(45, 45, Image.SCALE_SMOOTH);//set size for the image icon
        backButton.setLocation(0,0);//set coordinates for label
        backButton.setIcon(new ImageIcon(newImageLogo));

        //set window frame size and properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setVisible(true);


    }
    public class GetInfoEventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (!consultationListing.getItemAt(0).equals("No consultation available at the moment")) {//proceed only if consultation data exists in the system.
                JFrame detailFrame = new JFrame();//set up a new frame to display the information in a new window
                detailFrame.setTitle("Westminster Skin Consultation Manager | Consultation Summary");//set window title

                //set up and customize the panels based on the GUI theme
                JPanel topPanel = new JPanel(new GridLayout(3, 1)) {{
                    setBackground(new Color(174, 207, 176));
                }};
                JPanel centerPanel = new JPanel(new GridLayout(10, 3));
                JPanel bottomPanel = new JPanel(new GridLayout(3, 1)) {{
                    setBackground(new Color(174, 207, 176));
                }};
                JPanel buttonPanel = new JPanel(new GridLayout(1, 5)) {{
                    setBackground(new Color(174, 207, 176));
                }};
                JLabel detailViewLabel = new JLabel("Consultation Summary") {{
                    setFont(new Font("Dialog", Font.BOLD, 26));
                }};
                detailViewLabel.setHorizontalAlignment(SwingConstants.CENTER);//set center alignment for the label
                //button and customization to match GUI theme
                JButton detailViewButton = new JButton("OK") {{
                    setBackground(new Color(94, 159, 98));
                }};
                detailViewButton.setFocusable(false); // remove focus of the button which is set by default to focus
                DetailedViewButtonListener detailedViewButtonListener = new DetailedViewButtonListener();//set up button listener for the detailed view button
                detailViewButton.addActionListener(detailedViewButtonListener);//add listener to button

                //set-up top panel with title text
                topPanel.add(new JLabel());
                topPanel.add(detailViewLabel);
                topPanel.add(new JLabel());

                //retrieve data based on the choice of user given through the JComboBox
                String selectedDoctorName = "";
                if (!consultationListing.getItemAt(0).equals("No consultation available at the moment")) {//proceed only if consultation is not empty
                    for (Doctor doctor : MANAGER.getDoctorList()) {//extract doctor information based on the medical license number given to the consultation object
                        if (doctor.getMedicalLicenseNo() == consultationList.get(consultationListing.getSelectedIndex()).getDoctorMedicalLicenseNo()){
                            selectedDoctorName = "Dr. " + doctor.getName() + " " + doctor.getSurName();//concatinate the doctor name and surname for displaying purpose
                        }
                    }
                }

                //create array of BufferedImages
                bufferedImages = new BufferedImage[3];
                //set the image displaying labels to their defaults inorder to e displayed when no image is attached by user
                image1Data.setText("No Images");
                image2Data.setText("");
                image3Data.setText("");

                //add image to the labels as of availability
                image1Data.setIcon(new ImageIcon());
                image2Data.setIcon(new ImageIcon());
                image3Data.setIcon(new ImageIcon());

                //center components
                //set the components to display information to the user comprehensive
                JLabel name = new JLabel("Name");
                JLabel surName = new JLabel("Surname");
                JLabel dateOfBirth = new JLabel("Date Of Birth");
                JLabel mobileNumber = new JLabel("Mobile Number");
                JLabel patientId = new JLabel("Patient ID");
                JLabel consultedDoctor = new JLabel("Consulted Doctor");
                JLabel consultationTime = new JLabel("Consultation At");
                JLabel cost = new JLabel("Cost");
                JLabel notes = new JLabel("Additional Notes");
                JLabel images = new JLabel("Images Upload By User");

                //get data extracted from the selected consultation object to display the information on JLabels
                JLabel nameData = new JLabel(consultationList.get(consultationListing.getSelectedIndex()).getPatient().getName());
                JLabel surNameData = new JLabel(consultationList.get(consultationListing.getSelectedIndex()).getPatient().getSurName());
                JLabel dateOfBirthData = new JLabel(String.valueOf(consultationList.get(consultationListing.getSelectedIndex()).getPatient().getDateOfBirth()));
                JLabel mobileNumberData = new JLabel(String.valueOf(consultationList.get(consultationListing.getSelectedIndex()).getPatient().getMobileNumber()));
                JLabel patientIdData = new JLabel(consultationList.get(consultationListing.getSelectedIndex()).getPatient().getPatientId());
                JLabel consultedDoctorData = new JLabel(selectedDoctorName);
                JLabel consultationTimeData = new JLabel(String.valueOf(consultationList.get(consultationListing.getSelectedIndex()).getConsultationDateTime()));
                JLabel costData = new JLabel(String.valueOf(BigDecimal.valueOf(consultationList.get(consultationListing.getSelectedIndex()).getCost())));
                notesData = new JLabel(NOTES_ENCRYPTION_DECRYPTION.decrypt(consultationList.get(consultationListing.getSelectedIndex()).getNotes(), "9896WxD"));
                notesData.setPreferredSize(new Dimension(notes.getWidth(),notes.getHeight()));//set size of the notes pane

                //set up event listener object for previewing the images uploaded by the user
                ViewExtendedImageListener viewExtendedImageListener = new ViewExtendedImageListener();
                image1Data.addMouseListener(viewExtendedImageListener);//add listener object to the image label 1
                image2Data.addMouseListener(viewExtendedImageListener);//add listener object to the image label 2
                image3Data.addMouseListener(viewExtendedImageListener);//add listener object to the image label 3

                ImageEncryptionDecryption imageEncryptionDecryption = new ImageEncryptionDecryption();//create object of the ImageEncryptionDecryption to call methods of decryption images stored

                byte[][] encryptedImages = consultationList.get(consultationListing.getSelectedIndex()).getImageList();//get the encrypted images in bytes stored under consultation

                int count = 0;
                for (byte[] encryptedImage: encryptedImages) {//loop through to decrypt the image and display to the user
                    if (count == 0 && image1Data != null) {
                        BufferedImage bufferedImage = new BufferedImage(50, 50, Image.SCALE_SMOOTH);//set the size of the image
                        BufferedImage imageUpload = imageEncryptionDecryption.decrypt(encryptedImage,"9982DxW");//decrypt image given secret key
                        if (imageUpload != null) {
                            bufferedImages[count] = imageUpload;//get the image to an array further access
                            Image imageResized = imageUpload.getScaledInstance(bufferedImage.getWidth(), bufferedImage.getHeight(), Image.SCALE_SMOOTH);//set size preferences for the image
                            image1Data.setIcon(new ImageIcon(imageResized));//set image for the label
                        }else {
                            image1Data.setText("No Images");
                        }
                    } else if (count == 1 && image2Data != null) {
                        BufferedImage bufferedImage = new BufferedImage(50, 50, Image.SCALE_SMOOTH);//set the size of the image
                        BufferedImage imageUpload = imageEncryptionDecryption.decrypt(encryptedImage,"9982DxW");//decrypt image given secret key
                        if (imageUpload != null) {
                            bufferedImages[count] = imageUpload;//get the image to an array further access
                            Image imageResized = imageUpload.getScaledInstance(bufferedImage.getWidth(), bufferedImage.getHeight(), Image.SCALE_SMOOTH);;//set size preferences for the image
                            image2Data.setIcon(new ImageIcon(imageResized));//set image for the label
                        }
                    } else if (count == 2 && image3Data != null) {
                        BufferedImage bufferedImage = new BufferedImage(50, 50, Image.SCALE_SMOOTH);//set the size of the image
                        BufferedImage imageUpload = imageEncryptionDecryption.decrypt(encryptedImage,"9982DxW");//decrypt image given secret key
                        if (imageUpload != null) {
                            bufferedImages[count] = imageUpload;//get the image to an array further access
                            Image imageResized = imageUpload.getScaledInstance(bufferedImage.getWidth(), bufferedImage.getHeight(), Image.SCALE_SMOOTH);;//set size preferences for the image
                            image3Data.setIcon(new ImageIcon(imageResized));//set image for the label
                        }
                    }
                    count++;
                }

                JPanel imagesData =  new JPanel(new GridLayout(1,3));//set the panel for component management
                imagesData.setBackground(new Color(219, 243, 220));//customize the background the suit the GUI theme
                //add the label to relevant panel
                imagesData.add(image1Data);
                imagesData.add(image2Data);
                imagesData.add(image3Data);

                //array of JLabel to be used for adding into the center panel
                JLabel[] centerLabelList = {name, new JLabel(":"), nameData, surName, new JLabel(":"), surNameData, dateOfBirth, new JLabel(":"), dateOfBirthData, mobileNumber, new JLabel(":"), mobileNumberData, patientId, new JLabel(":"), patientIdData, consultedDoctor, new JLabel(":"), consultedDoctorData, consultationTime, new JLabel(":"), consultationTimeData, cost, new JLabel(":"), costData, notes, new JLabel(":"), notesData, images, new JLabel(":")};

                //add the components to the center panel
                for (JLabel label : centerLabelList) {
                    centerPanel.add(label);//add component
                }
                centerPanel.add(imagesData);//add images panel;

                JPanel emptyPanel = new JPanel();//empty panels for layout management on empty slots
                //customization based on GUI theme and size changes based on fit
                emptyPanel.setPreferredSize(new Dimension(90, 100));
                emptyPanel.setBackground(new Color(219, 243, 220));
                centerPanel.setBackground(new Color(219, 243, 220));

                //add components to their respective panels
                //empty labels to fill the empty slots
                buttonPanel.add(new JLabel());
                buttonPanel.add(new JLabel());
                buttonPanel.add(detailViewButton);
                buttonPanel.add(new JLabel());
                buttonPanel.add(new JLabel());
                bottomPanel.add(new JLabel());
                bottomPanel.add(buttonPanel);
                bottomPanel.add(new JLabel());
                detailFrame.add(topPanel, BorderLayout.NORTH);
                detailFrame.add(centerPanel, BorderLayout.CENTER);
                detailFrame.add(bottomPanel, BorderLayout.SOUTH);
                detailFrame.add(emptyPanel, BorderLayout.WEST);

                //set up the window and frame size and properties
                detailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                detailFrame.setSize(665, 700);
                detailFrame.setVisible(true);
            }
        }
    }
    public static class BackButtonListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            //switch windows when mouse event triggers
            GUIApplication guiApplication = new GUIApplication();
            Component source = (Component) mouseEvent.getSource();
            ViewConsultation frame = (ViewConsultation) SwingUtilities.windowForComponent(source);
            frame.dispose();//close the current window
        }
    }

    public static class DetailedViewButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //open a new window with the information on a specific consultation when the action event is triggered
            Component source = (Component) actionEvent.getSource();
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(source);
            frame.dispose();

        }
    }

    public class ViewExtendedImageListener extends MouseAdapter{
        private JFrame frame;
        private JLabel imageLabel = new JLabel();

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
            //preview extended image when mouse hovers over the image
            frame = new JFrame();//set a new frame to open a seperate window
            frame.setTitle("Westminster Skin Consultation Manager | View Images");//set window title
            Image image;
            //display image based on the label the mouse is hovered.
            if (mouseEvent.getSource() == image1Data && bufferedImages[0] != null){
                image = bufferedImages[0].getScaledInstance(500, 500, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(image));
                frame.add(imageLabel);
            }else if (mouseEvent.getSource() == image2Data && bufferedImages[1] != null){
                image = bufferedImages[1].getScaledInstance(500, 500, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(image));
                frame.add(imageLabel);
            }else if (mouseEvent.getSource() == image3Data && bufferedImages[2] != null){
                image = bufferedImages[2].getScaledInstance(500, 500, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(image));
                frame.add(imageLabel);
            }
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500,500);
            frame.setVisible(true);
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {//close preview of  image when mouse hovers exits the image
            frame.dispose();
        }
    }

    public void loadConsultationData() {
        try {
            //create file object with save data file
            File file = new File("src/com/OOP/w19127880_Coursework/SaveFiles/ConsultationSaveData.data");
            if (!file.exists()) {//create new file if file doesn't exist
                file.createNewFile();
            }
            FileInputStream readData = new FileInputStream(file);
            ObjectInputStream readStream = new ObjectInputStream(readData);
            consultationList = (ArrayList<Consultation>) readStream.readObject();//load save data back to the arrayList of doctor objects
            readStream.close();
        } catch (Exception e) { // error handler for exception for only sending data with ObjectInputStream
        }
    }
}
