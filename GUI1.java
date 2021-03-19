package SU.CIS454;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI1{

    private static JPanel panel;
    private static JFrame frame = new JFrame();

    public static void login(){

        panel = new JPanel();
        //frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        JLabel letsDoIt = new JLabel("Let's Do It!");
        letsDoIt.setBounds(100, 20, 80, 25);
        panel.add(letsDoIt);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(30, 50, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(120, 50, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(30, 80, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(120, 80, 165, 25);
        panel.add(passwordText);

        JLabel success = new JLabel("");
        success.setBounds(30, 140, 300, 25);
        panel.add(success);

        JButton button = new JButton(new AbstractAction("Login") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = passwordText.getText();

                if (user.equals("Team24") && password.equals("1234")) {
                    //success.setText("Login successful!");
                    frame.remove(panel);
                    uploadFile();
                }
                else {
                    success.setText("Login fail");
                }
            }
        });
        button.setBounds(30, 110, 80, 25);
        panel.add(button);


        frame.setVisible(true);
    }


    public static void uploadFile() {

        panel = new JPanel();
        //frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        JLabel letsDoIt2 = new JLabel("Let's Do It!");
        letsDoIt2.setBounds(200, 20, 80, 25);
        panel.add(letsDoIt2);

        JButton uploadButton = new JButton(new AbstractAction("Upload") {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Use file chooser to upload a file
                //https://mkyong.com/swing/java-swing-jfilechooser-example/

                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                int returnValue = jfc.showOpenDialog(null);
                // int returnValue = jfc.showSaveDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jfc.getSelectedFile();
                    System.out.println(selectedFile.getAbsolutePath());
                }

            }
        });
        uploadButton.setBounds(175, 200, 150, 25);
        panel.add(uploadButton);

        JButton exitButton = new JButton(new AbstractAction("Exit to Login") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel);
                login();
            }
        });
        exitButton.setBounds(175, 230, 150, 25);
        panel.add(exitButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {

        login();
    }
}
