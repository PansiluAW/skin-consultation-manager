package com.OOP.w19127880_Coursework.GUI;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIApplication extends JFrame {
    private JPanel panel = new JPanel();
    private JPanel buttonPanel;
    private JButton doctorsButton;
    private JButton consultationButton;
    private JButton viewConsButton;
    private JButton exitButton;

    public GUIApplication() {
        super("Westminster Skin Consultation Manager");//set title of the window
        panel.setLayout(new GridLayout(2, 3));//set layout of the main panel for components and other panels

        //set and customize the window header based on the GUI theme
        Font font = new Font("Dialog", Font.BOLD, 25);//set font for header title text
        JLabel titleLabel = new JLabel("Welcome to Westminster Skin Consultation Manager", SwingConstants.CENTER) {{//set font and customize the title text
            setFont(font);
            setForeground(new Color(255, 255, 255));
        }};
        //set the background of the title text
        titleLabel.setBackground(new Color(94, 159, 98));
        titleLabel.setOpaque(true);
        //add the components and panels to the frame
        add(titleLabel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(new JLabel(), BorderLayout.SOUTH);//add empty label to the SOUTH of the window for button space
        buttonPanel = new JPanel(new GridLayout(0, 1, 10, 10));//panel to manage the buttons
        JLabel appLogo = new JLabel("", SwingConstants.CENTER);//label to display the business logo
        ImageIcon imageIconLogo = new ImageIcon("src/com/OOP/w19127880_Coursework/GUI/Images/WestminsterSkinConsultationBackgroundAndLogoImage.jpg");//Westminster Skin Consultation Centre logo
        Image imageLogo = imageIconLogo.getImage();
        Image newImageLogo = imageLogo.getScaledInstance(900, 1000, Image.SCALE_SMOOTH);//set preferred for the image
        appLogo.setIcon(new ImageIcon(newImageLogo));
        //set preferred size and customization based on the GUI theme
        buttonPanel.setPreferredSize(new Dimension(300, 100));
        buttonPanel.setBackground(new Color(233, 255, 234));

        ImageIcon imageIconBackground = new ImageIcon("src/com/OOP/w19127880_Coursework/GUI/Images/WestminsterSkinConsultationBackgroundImage.jpg");// set up the background image for the home screen of the GUI
        Image imageBackground = imageIconBackground.getImage();
        Image newImageBackground = imageBackground.getScaledInstance(1000, 1000, Image.SCALE_SMOOTH);//set the preferred size of the image
        //create labels for setting the background image on relevant components set with the layout manager
        JLabel backgroundLabel1 = new JLabel();
        JLabel backgroundLabel2 = new JLabel();
        JLabel backgroundLabel3 = new JLabel();
        JLabel backgroundLabel4 = new JLabel();
        JLabel backgroundLabel5 = new JLabel();
        //add the images to the relevant labels for use
        backgroundLabel1.setIcon(new ImageIcon(newImageBackground));
        backgroundLabel2.setIcon(new ImageIcon(newImageBackground));
        backgroundLabel3.setIcon(new ImageIcon(newImageBackground));
        backgroundLabel4.setIcon(new ImageIcon(newImageBackground));
        backgroundLabel5.setIcon(new ImageIcon(newImageBackground));

        //add panels and components to the main panel
        panel.add(backgroundLabel1);
        panel.add(appLogo);
        panel.add(backgroundLabel2);
        panel.add(backgroundLabel3);
        panel.add(buttonPanel);
        panel.add(backgroundLabel4);
        //set-up button for accessing each separate functionality of the GUI
        doctorsButton = new JButton("View Available Doctors");
        consultationButton = new JButton("Add Consultation");
        viewConsButton = new JButton("View Consultation");
        exitButton = new JButton("Exit Application");

        HomePageHandler homePageHandler = new HomePageHandler();//setup event handler
        //add event listener object to the buttons
        doctorsButton.addActionListener(homePageHandler);
        consultationButton.addActionListener(homePageHandler);
        viewConsButton.addActionListener(homePageHandler);
        exitButton.addActionListener(homePageHandler);

        buttonPanel.setLayout(new GridLayout(5, 1, 5, 6));//set the layout for the button panel
        //add the button and other components to the button panel
        buttonPanel.add(doctorsButton);
        buttonPanel.add(consultationButton);
        buttonPanel.add(viewConsButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(backgroundLabel5);

        //customize the buttons and the text based on the GUI theme
        doctorsButton.setBackground(new Color(94, 159, 98));
        consultationButton.setBackground(new Color(94, 159, 98));
        viewConsButton.setBackground(new Color(94, 159, 98));
        exitButton.setBackground(new Color(94, 159, 98));
        doctorsButton.setForeground(new Color(255, 255, 255));
        consultationButton.setForeground(new Color(255, 255, 255));
        viewConsButton.setForeground(new Color(255, 255, 255));
        exitButton.setForeground(new Color(255, 255, 255));

        //set a font to the button text in the home screen of the GUI
        Font buttonFont = new Font("Dialog",Font.BOLD,16);
        //add font to buttons
        doctorsButton.setFont(buttonFont);
        consultationButton.setFont(buttonFont);
        viewConsButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        //remove focus from the button which is set to focus default
        consultationButton.setFocusable(false);
        viewConsButton.setFocusable(false);
        exitButton.setFocusable(false);
        doctorsButton.setFocusable(false);

        //set the window frame size and properties
        this.setSize(1200,700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public class HomePageHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //customize the option pane displayed at land to the home screen
            ImageIcon imageIconLogo = new ImageIcon("src/com/OOP/w19127880_Coursework/GUI/Images/WestminsterSkinConsultationLogo.png");//set Westminster Skin Consultation Centre logo
            Image imageLogo = imageIconLogo.getImage();
            Image newImageLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);//set size of the logo
            UIManager.put("OptionPane.background", new ColorUIResource(174, 207, 176));
            UIManager.put("OptionPane.informationIcon",new ImageIcon(newImageLogo));//set the icon on option pane
            UIManager.put("OptionPane.Button.background", new Color(174, 207, 176));
            UIManager.put("OptionPane.font", new Font("Dialog",Font.BOLD,10));

            //switch to window based on the source of the action event that triggers it.
            if (actionEvent.getSource() == doctorsButton) {
                DisplayDoctorInformationList doctorInformationList = new DisplayDoctorInformationList();
                frameDispose(actionEvent);
            } else if (actionEvent.getSource() == consultationButton) {
                AddConsultation addConsultation = new AddConsultation();
                frameDispose(actionEvent);
                //display the alert message to the user upon entering the "Add Consultation" window
                JOptionPane.showMessageDialog(addConsultation, "*Please note that in case the doctor is unavailable at a certain \n  time slot a currently available doctor at the center will be randomly allocated.\n*Each consultation is £25 per hour and the first consultation is £15 per hour.","IMPORTANT",JOptionPane.INFORMATION_MESSAGE);
            } else if (actionEvent.getSource() == viewConsButton) {
                ViewConsultation viewConsultation = new ViewConsultation();
                frameDispose(actionEvent);

            } else if (actionEvent.getSource() == exitButton) {
                //display success message to the user upon exit
                System.out.println("Program Exited Successfully.");
                System.out.println("**************************************************************");
                System.out.println("* Thank you for using Westminster Skin Consultation Manager! *");
                System.out.println("**************************************************************");
                System.out.println("Have a wonderful day!");
                System.exit(0);
            }
        }
        public void frameDispose(ActionEvent actionEvent){
            //dispose the current frame upon entering the new window
            Component source = (Component) actionEvent.getSource();
            GUIApplication frame = (GUIApplication) SwingUtilities.windowForComponent(source);
            frame.dispose();
        }
    }
}
