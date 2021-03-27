package SU.CIS454;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Object;

public class Release4 {
    private static JFrame frame = new JFrame();
    private static JPanel mainPanel;
    private static String usr_name;
    private static String[] to_do_string = {"Task1", "Task2", "Task3"};
    private static JList to_do_list;


    public static void landing_page (String name) {

        mainPanel = new JPanel();
        frame.setSize(500,500);
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

        String str = "Hello, " + name + "!"; //We can change user here from input
        helloLabel= new JLabel(str);
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

        JButton suggestionButton = new JButton("Suggestion");
        c.ipady = 50;
        //c.weighty= 0;
        c.gridheight = 1;
        c.gridx = 1;
        c.gridy = 2;
        mainPanel.add(suggestionButton, c);

        JButton uploadButton = new JButton("Upload");
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
        frame.setSize(500, 500);
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
                landing_page(usr_name);
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
                landing_page(usr_name);
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
                landing_page(usr_name);
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
                landing_page(usr_name);
            }
        });
        empty.setBounds(210, 110, 130, 25);
        mainPanel.add(empty);

        frame.setVisible(true);
    }

    public static void main(String[] args) {

        //landing_page();
        welcome();
    }
}
