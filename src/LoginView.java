import javax.swing.*;
import java.awt.*;
import java.util.Objects;

// Displays the start screen and login page
public class LoginView extends JFrame {
    public boolean stayTitleScreen = true; // Variable to determine if user has clicked to start the game
    private String userInput; // Variable to store the username the user enters

    // Constructor to be called to display the start screen followed by login
    public LoginView() {
    }
    public void display() {
        stayTitleScreen = true;
        // Colours
        Color lightRed = new Color(255, 102, 102);
        Color lightOrange = new Color(255, 165, 0);

        // Creates frame for the login page
        JFrame login = new JFrame();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.getContentPane().setBackground(Color.LIGHT_GRAY);
        login.setTitle("Enter Username");

        // Creatse textfield to be used in the login page
        JTextField textField = new JTextField(1); // Create a text field
        textField.setFont(new Font("Courier", Font.PLAIN, 20));
        login.add(textField); // Add it to the frame

        // Background image for login
        ImageIcon trainer1 = new ImageIcon("trainer.png");
        Image trainer1i = trainer1.getImage(); // transform it
        Image trainer1ii = trainer1i.getScaledInstance(300, 600, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon TrainerIcon = new ImageIcon(trainer1ii);  // transform it back
        JLabel trainer = new JLabel();
        trainer.setIcon(TrainerIcon);
        login.add(trainer, BorderLayout.NORTH);

        // Creates continue button for login page
        JButton cont = new JButton("Continue");
        cont.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.BLACK));
        cont.setBackground(Color.LIGHT_GRAY);
        cont.setFont((new Font("Courier", Font.BOLD, 22)));
        // Adds action listener to continue button to send username entered to Trainer class to create/login to an account
        cont.addActionListener(e -> {
            userInput = textField.getText(); // Gets the input from the textfield
            if (Objects.equals(userInput, "")) {
                System.out.println("No Username Entered, Logging In to Guest Account...");
                userInput = "Guest";
            }
            TrainerModel.trainerModel.setUsername(userInput); // Creates Trainer object with userinput
            TrainerModel.trainerModel.createProfile();
            dispose();
            login.setVisible(false);
            stayTitleScreen = false; // Closes login and proceeds to next frame
        });

        // Adds continue button to the bottom of login page
        login.add(cont, BorderLayout.SOUTH);
        login.pack(); // Fits the login frame to the contents
        login.getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
        login.setLocationRelativeTo(null); // Centers the login frame

        //Image for start screen
        ImageIcon start = new ImageIcon("title.png");
        Image starti = start.getImage(); // transform it
        Image startii = starti.getScaledInstance(700, 230, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon startIcon = new ImageIcon(startii);  // transform it back

        // Creates label to contain start screen image and start button
        JLabel startScreen = new JLabel();
        startScreen.setIcon(startIcon);
        add(startScreen, BorderLayout.NORTH); // Adds start screen label to the top of the main frame

        // Creates start button
        JButton button = new JButton("Start Game!");
        button.setBackground(lightOrange);
        button.setFont((new Font("Courier", Font.BOLD, 22)));
        button.setBackground(lightOrange);
        button.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.BLACK));
        // Adds action listener to start button to continue to next frame when user clicks
        button.addActionListener(e -> {
            dispose();
            login.setVisible(true);

        });
        add(button, BorderLayout.SOUTH); // Adds the start button to the bottom of the main frame

        // Sets main frame size, position, visibility, title, background colour and exit operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Start Screen");
        getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
        pack();
        getContentPane().setBackground(lightRed);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

