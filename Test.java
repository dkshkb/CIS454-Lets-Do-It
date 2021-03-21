package SU.CIS454;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Test {

    private static JFrame frame = new JFrame();
    private static JPanel mainPanel;

    public static void landing_page (String name) {

        mainPanel = new JPanel();
        frame.setSize(800,800);
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

        JTextArea textArea = new JTextArea(20, 20);
        taskScrollPanel = new JScrollPane(textArea);
        taskScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        taskScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JLabel taskLabel = new JLabel("some suggestions");
        JPanel taskPanel = new JPanel();
        taskPanel.add(taskLabel);
        taskPanel.setLayout(null);
        taskScrollPanel.add(taskPanel);
        c.gridwidth = 1;
        c.gridheight = 3;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.ipady = 60;
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

        frame.pack();
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
                String name = userText.getText();
                frame.remove(mainPanel);
                landing_page(name);
            }
        });

        button.setBounds(30, 110, 80, 25);
        mainPanel.add(button);

        frame.setVisible(true);
    }

    public static void main(String[] args) {

        //landing_page();
        welcome();
    }
}
