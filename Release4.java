package SU.CIS454;  //Please comment out this line when testing

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Object;
import java.util.*;
import java.time.*;
import java.time.format.*;
import java.text.SimpleDateFormat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.io.File;
import java.io.*;
import java.util.Map;

public class Release4 {
    private static JFrame frame = new JFrame();
    private static JPanel mainPanel;
    private static String usr_name;
    private static String[] to_do_string = {"Task1", "Task2", "Task3"};
    private static JList to_do_list;
    private static String suggestion;

    //creates hashmap to store all the assignments in and a count to denote the different sllyabi that have been parsed
    public static int sllyCount = 0;
    static HashMap assignments = new HashMap<String , String[]>();
    static int numAssignments;


    public static void landing_page () {

        mainPanel = new JPanel();
        frame.setSize(700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        //mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel titleLabel;
        JLabel helloLabel;
        JScrollPane taskScrollPanel;
        JPanel suggestionPanel = new JPanel();
        //JButton uploadButton = new JButton("upload");
        JPanel calendarPanel = new JPanel();

        // ************************************************

        //JButton button;
        //mainPanel.setLayout(new GridBagLayout());
        //GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        titleLabel = new JLabel("LET'S DO IT!");
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 40));

        //suggestion = "Hello, " + usr_name + "!"; //We can change user here from input
        helloLabel= new JLabel(suggestion);
        helloLabel.setFont(new Font("Serif", Font.PLAIN, 20) );

        //button = new JButton("Button 1");
        c.weighty = 0.5;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(titleLabel, c);

        //button = new JButton("Button 2");
        //c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(helloLabel, c);

        //JButton button = new JButton("Here is suggestion list");

        to_do_list = new JList(to_do_string);
        JTextArea textArea = new JTextArea(20, 20);
        taskScrollPanel = new JScrollPane(to_do_list);
        taskScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        taskScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //JLabel taskLabel = new JLabel("some suggestions");
        //JPanel taskPanel = new JPanel();
        //taskPanel.add(taskLabel);
        //taskPanel.setLayout(null);

        //taskScrollPanel.add(taskPanel);
        //taskScrollPanel.add(to_do_list);
        c.gridwidth = 1;
        c.gridheight = 4;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.ipady = 100;
        //c.weightx = 0.5;
        mainPanel.add(taskScrollPanel, c);

        JButton suggestionButton = new JButton(new AbstractAction("Suggestion") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(mainPanel);
                suggestion_page();
            }
        });
        c.ipady = 50;
        //c.weighty= 0;
        c.gridheight = 1;
        c.gridx = 1;
        c.gridy = 2;
        mainPanel.add(suggestionButton, c);

        JButton uploadButton = new JButton(new AbstractAction("Upload") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(mainPanel);
                upload_page();
            }
        });
        c.gridx = 1;
        c.gridy = 3;
        mainPanel.add(uploadButton, c);

        JButton calendarButton = new JButton("Calendar");
        c.gridx = 1;
        c.gridy = 4;
        mainPanel.add(calendarButton, c);

        JButton add_delete_task = new JButton(new AbstractAction("Add/Delete Task") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(mainPanel);
                add_delete_task_page();
            }
        });
        c.gridx = 1;
        c.gridy = 5;
        mainPanel.add(add_delete_task, c);

        //frame.pack();
        frame.setVisible(true);

    }

    public static void welcome () {
        mainPanel = new JPanel();
        //frame = new JFrame();
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);

        mainPanel.setLayout(null);

        JLabel letsDoIt = new JLabel("Let's Do It!");
        letsDoIt.setBounds(100, 20, 80, 25);
        mainPanel.add(letsDoIt);

        JLabel userLabel = new JLabel("Your name?");
        userLabel.setBounds(30, 50, 80, 25);
        mainPanel.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(120, 50, 165, 25);
        mainPanel.add(userText);

        JButton button = new JButton(new AbstractAction("Next") {
            @Override
            public void actionPerformed(ActionEvent e) {
                usr_name = userText.getText();
                frame.remove(mainPanel);
                suggestion = "Hello, " + usr_name + "!";
                landing_page();
            }
        });

        button.setBounds(30, 110, 80, 25);
        mainPanel.add(button);

        frame.setVisible(true);
    }

    public static void add_delete_task_page() {
        mainPanel = new JPanel();
        //frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);

        mainPanel.setLayout(null);

        JLabel letsDoIt = new JLabel("Please enter a task to be added or deleted");
        letsDoIt.setBounds(100, 20, 300, 25);
        mainPanel.add(letsDoIt);

        JLabel userLabel = new JLabel("Task Name");
        userLabel.setBounds(30, 50, 80, 25);
        mainPanel.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(120, 50, 165, 25);
        mainPanel.add(userText);

        JButton add = new JButton(new AbstractAction("Add") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = userText.getText();
                ArrayList<String> lst = new ArrayList<String>(Arrays.asList(to_do_string));
                lst.add(task);
                to_do_string = lst.toArray(new String[0]);
                frame.remove(mainPanel);
                //suggestion = "Hello, " + usr_name + "!";
                landing_page();
            }
        });
        add.setBounds(30, 110, 80, 25);
        mainPanel.add(add);

        JButton delete = new JButton(new AbstractAction("Delete") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = userText.getText();
                ArrayList<String> lst = new ArrayList<String>(Arrays.asList(to_do_string));
                lst.remove(task);
                to_do_string = lst.toArray(new String[0]);
                frame.remove(mainPanel);
                //suggestion = "Hello, " + usr_name + "!";
                landing_page();
            }
        });
        delete.setBounds(120, 110, 80, 25);
        mainPanel.add(delete);

        JButton empty = new JButton(new AbstractAction("Empty all tasks") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String task = userText.getText();
                //ArrayList<String> lst = new ArrayList<String>(Arrays.asList(to_do_string));
                //lst.add(task);
                to_do_string = new String[] {};
                frame.remove(mainPanel);
                //suggestion = "Hello, " + usr_name + "!";
                landing_page();
            }
        });
        empty.setBounds(210, 110, 130, 25);
        mainPanel.add(empty);

        frame.setVisible(true);
    }

    public static void suggestion_page() {
        mainPanel = new JPanel();
        //frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);

        mainPanel.setLayout(null);

        JLabel letsDoIt = new JLabel("Please enter the task name");
        letsDoIt.setBounds(100, 20, 300, 25);
        mainPanel.add(letsDoIt);

        JLabel userLabel = new JLabel("Task Name");
        userLabel.setBounds(30, 50, 80, 25);
        mainPanel.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(120, 50, 165, 25);
        mainPanel.add(userText);

        JLabel timeToBeReminded = new JLabel("Start time (XX:XX AM/PM DD/MM/YYYY)");
        timeToBeReminded.setBounds(100, 80, 300, 25);
        mainPanel.add(timeToBeReminded);

        JLabel timeLabel = new JLabel("Time");
        timeLabel.setBounds(30, 110, 80, 25);
        mainPanel.add(timeLabel);

        JTextField timeText = new JTextField();
        timeText.setBounds(120, 110, 165, 25);
        mainPanel.add(timeText);

        JButton createButton = new JButton(new AbstractAction("Create Suggestion") {
            @Override
            public void actionPerformed(ActionEvent e) {
                suggestion = usr_name + ", your task (" + userText.getText() + ") starts at " + timeText.getText();
                frame.remove(mainPanel);

                landing_page();
            }
        });
        createButton.setBounds(210, 140, 140, 25);
        mainPanel.add(createButton);

        JButton exitButton = new JButton(new AbstractAction("exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(mainPanel);
                //suggestion = "Hello, " + usr_name + "!";
                landing_page();
            }
        });
        exitButton.setBounds(210, 170, 120, 25);
        mainPanel.add(exitButton);

        frame.setVisible(true);
    }

    public static void getLocation(String loc) throws FileNotFoundException{
        //function to get the string
        //take the location from the user entry and then parse the file specified at the location
        try
        {
            //do all this manually because Im lazy
            //create a new file with the location entered by the user
            File fileLoc = new File(loc);
            Scanner scan = new Scanner(fileLoc);
            String className = scan.nextLine();
            //get the number of assignments from the top of the sllyabus
            numAssignments = Integer.parseInt(scan.nextLine());
            String assignmentName;
            String assignmentDesc;
            String assignmentDueDate;

            //the path of my C:\Users\trelo\OneDrive\Desktop\sllyabusExample.txt
            // for loop to parse the sllyabus
            for (int i = 0; i < numAssignments; i++){
                //name of the key for the hashmap
                String dicName = "hw" + (sllyCount + i);
                sllyCount++;
                //Name of the assignment stored in the
                assignmentName = scan.nextLine();
                //Description of the assignment
                assignmentDesc = scan.nextLine();
                //The due date of the assignment
                assignmentDueDate = scan.nextLine();
                //Put the aspects of the assignment into an array of strings
                String[] hwMap = {assignmentName,assignmentDesc,assignmentDueDate};
                //Place the name, desc and due date of the assignment into the assignment hashmap entry respectively
                assignments.put(dicName, hwMap);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void upload_page(){

        mainPanel = new JPanel();
        //frame = new JFrame();
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        mainPanel.setLayout(null);

        JLabel letsDoIt = new JLabel("Enter file path of sllyabus to get assignemnt");
        letsDoIt.setBounds(100, 20, 300, 25);
        mainPanel.add(letsDoIt);

        JLabel pathLabel = new JLabel("Path");
        pathLabel.setBounds(30, 50, 80, 25);
        mainPanel.add(pathLabel);

        JTextField userText = new JTextField();
        userText.setBounds(120, 50, 300, 25);
        mainPanel.add(userText);

        JButton uploadButton = new JButton(new AbstractAction("Upload") {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignments.clear();
                String path = userText.getText();
                try {
                    getLocation(path);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                frame.remove(mainPanel);
                show_syllabus_page();
            }

        });
        uploadButton.setBounds(30, 110, 80, 25);
        mainPanel.add(uploadButton);

        JButton exit = new JButton(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.remove(mainPanel);
                landing_page();
            }
        });
        exit.setBounds(120, 110, 80, 25);
        mainPanel.add(exit);



        frame.setVisible(true);
    }

    public static void show_syllabus_page(){

        mainPanel = new JPanel();
        //frame = new JFrame();
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel letsDoIt = new JLabel("List of assignments scanned from the syllabus is shown below");
        letsDoIt.setBounds(60, 20, 400, 25);
        mainPanel.add(letsDoIt);

        c.weighty = 0.5;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(letsDoIt, c);

        JScrollPane taskScrollPanel;

        //String[] assignment_string = {};
        ArrayList<String> lst = new ArrayList<String>();
        //assignments.forEach((Key, Value) ->
        // System.out.println( "Name: " + ((String[])(Value))[0]
        // + " \n Desc: " + ((String[])(Value))[1]
        // + " \n Due Date: " + ((String[])(Value))[2]));
        Iterator<Map.Entry<String, String[]>> it = assignments.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String[]> set = (Map.Entry<String, String[]>) it.next();
            String str = "Name: " + set.getValue()[0]
                    + " (" + set.getValue()[1] + ") Due: "
                    + set.getValue()[2];
            lst.add(str); // Need to modify
        }
        String[] assignment_string = lst.toArray(new String[0]);

        JList assignment_list = new JList(assignment_string);
        taskScrollPanel = new JScrollPane(assignment_list);
        taskScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        taskScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        c.gridwidth = 1;
        c.gridheight = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.ipady = 100;
        c.ipadx = 100;
        mainPanel.add(taskScrollPanel, c);

        JButton addButton = new JButton(new AbstractAction("Add to task-list") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //append assignment_string to to_do_string

                ArrayList<String> lst = new ArrayList<String>(Arrays.asList(to_do_string));
                for (int i = 0; i < assignment_string.length; i++) {
                    lst.add(assignment_string[i]);
                }
                to_do_string = lst.toArray(new String[0]);
                frame.remove(mainPanel);
                landing_page();
            }
        });
        c.ipady = 50;
        //c.weighty= 0;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(addButton, c);

        JButton backButton = new JButton(new AbstractAction("Back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(mainPanel);
                upload_page();
            }
        });
        c.gridx = 0;
        c.gridy = 3;
        mainPanel.add(backButton, c);


        frame.setVisible(true);
    }

    public static void main(String[] args) {

        //landing_page();
        welcome();
    }
}
