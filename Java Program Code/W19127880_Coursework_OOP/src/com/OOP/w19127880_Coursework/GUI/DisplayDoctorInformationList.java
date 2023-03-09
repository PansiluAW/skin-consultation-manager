package com.OOP.w19127880_Coursework.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DisplayDoctorInformationList extends JFrame{
    private JLabel backButton;
    private JButton nameSortButton;
    private JButton surnameSortButton;
    private JButton defaultSortButton;
    private JTable table;
    public DisplayDoctorInformationList(){
        this.setTitle("Westminster Skin Consultation Manager | View All Available Doctors");//set window title
        DoctorTableModel doctorTableModel = new DoctorTableModel(); //create table model object

        //set fonts for the use throughout the program
        Font font = new Font("Dialog", Font.BOLD, 28);
        Font fieldFont = new Font("Dialog", Font.BOLD, 14);
        Font buttonFont = new Font("Dialog", Font.BOLD, 14);

        //create JTable with the set customization aligned with the GUI theme
        table = new JTable(doctorTableModel){{setFont(fieldFont);setForeground(new Color(255, 255, 255)); setBackground(new Color(94, 159, 98));}};
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();//table cell render object to make changes to the table content appearance in GUI
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int colCount = 0; colCount< 6; colCount++) {
            table.getColumnModel().getColumn(colCount).setCellRenderer(centerRenderer);//center align table content
        }
        //customize the appearance of the table to align with the GUI theme
        table.getTableHeader().setPreferredSize(new Dimension(getWidth(),50));//set size of the table
        table.setRowHeight(40);//set row height
        table.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));//set font for the column header of the table
        table.getTableHeader().setBackground(new Color(174,207,176));// set column header of the table background color
        JScrollPane scrollPane = new JScrollPane(table){{setFont(fieldFont);setForeground(new Color(255, 255, 255)); setBackground(new Color(94, 159, 98));}};//customize the scroll pane of the content of the table to align with the GUI theme
        JPanel buttonPanel = new JPanel(new FlowLayout());

        //set and customize the title and back button on the header of the window with customizations
        JLabel titleLabel = new JLabel("All Available Doctors", SwingConstants.CENTER){{setFont(font);setForeground(new Color(255, 255, 255));setBackground(new Color(94, 159, 98));setOpaque(true);}};
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        //add content to the frame
        add(scrollPane);
        table.setAutoCreateRowSorter(true);//allow sorting functionality in the method

        //set and customize the back button at the left of the header of the window
        backButton = new JLabel(""){{setBackground(new Color(94, 159, 98));setOpaque(true);}};
        backButton.setHorizontalAlignment(JLabel.LEFT);
        JPanel titlePanel = new JPanel(new FlowLayout()){{setBackground(new Color(94, 159, 98));setOpaque(true);}};
        titleLabel.setPreferredSize(new Dimension(1000,150));

        //add title content to title panel and frame
        add(titlePanel, BorderLayout.NORTH);
        titlePanel.add(backButton);
        titlePanel.add(titleLabel);

        //set the JButtons for the sorting functionalities
        nameSortButton = new JButton("Sort By Name"){{setFont(buttonFont);setBackground(new Color(94, 159, 98));setOpaque(true); setForeground(new Color(255,255,255));}};
        surnameSortButton = new JButton("Sort By Surname"){{setFont(buttonFont);setBackground(new Color(94, 159, 98));setOpaque(true); setForeground(new Color(255,255,255));}};
        defaultSortButton = new JButton("Default Sort"){{setFont(buttonFont);setBackground(new Color(94, 159, 98));setOpaque(true); setForeground(new Color(255,255,255));}};
        //add buttons to button panel
        buttonPanel.add(new Label());
        buttonPanel.add(nameSortButton);
        buttonPanel.add(surnameSortButton);
        buttonPanel.add(defaultSortButton);

        TableEventHandler tableEventHandler = new TableEventHandler();//create table event handler object
        BackButtonListener backButtonListener = new BackButtonListener();//create back button listener object
        backButton.addMouseListener(backButtonListener);//add back button listener to the button
        nameSortButton.addActionListener(tableEventHandler);//add table event listener to the name sort by name button
        surnameSortButton.addActionListener(tableEventHandler);//add table event listener to the name sort by surname button
        defaultSortButton.addActionListener(tableEventHandler);//add table event listener to the name default sort button

        //set preferred sizes for the buttons in the window
        nameSortButton.setPreferredSize(new Dimension(200,50));
        surnameSortButton.setPreferredSize(new Dimension(200,50));
        defaultSortButton.setPreferredSize(new Dimension(200,50));

        //add components to panel and frame
        buttonPanel.add(new JLabel(), SwingConstants.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        //set preferred size for the components
        buttonPanel.setPreferredSize(new Dimension(200,200));
        buttonPanel.setBackground(new Color(219, 243, 220));
        scrollPane.getViewport().setBackground(new Color(219, 243, 220));
        ImageIcon imageIconLogo = new ImageIcon("src/com/OOP/w19127880_Coursework/GUI/Images/BackButton.png");//set back button image icon
        Image imageLogo = imageIconLogo.getImage();
        Image newImageLogo = imageLogo.getScaledInstance(45, 45, Image.SCALE_SMOOTH);//set the size of the image to appear in window
        backButton.setLocation(0,0);//set location of the back button in the window
        backButton.setIcon(new ImageIcon(newImageLogo));//set icon to the back button JLabel

        //remove focus from the buttons which is stated focus by default
        defaultSortButton.setFocusable(false);
        nameSortButton.setFocusable(false);
        surnameSortButton.setFocusable(false);

        //set the window frame size and properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setVisible(true);
    }
    
    public class TableEventHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //trigger sort functionality according to the source of the action event
            if (actionEvent.getSource() == nameSortButton) {//name sort functionality
                table.getRowSorter().toggleSortOrder(0);
            } else if (actionEvent.getSource() == surnameSortButton) {//surname sort functionality
                table.getRowSorter().toggleSortOrder(1);
            } else if (actionEvent.getSource() == defaultSortButton) {//default sort functionality
                RowSorter rowSorter = table.getRowSorter();
                rowSorter.setSortKeys(null);
            }
        }
    }
    public class BackButtonListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            //switch to home screen window when back button is clicked
            GUIApplication guiApplication = new GUIApplication();
            Component source = (Component) mouseEvent.getSource();
            DisplayDoctorInformationList frame = (DisplayDoctorInformationList) SwingUtilities.windowForComponent(source);
            frame.dispose();//dispose the current window when switch to home screen window
        }
    }

}
