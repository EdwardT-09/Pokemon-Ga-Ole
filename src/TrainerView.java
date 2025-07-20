import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

// Displays the trainers profile
public class TrainerView extends JFrame {
    public boolean stayMainMenu = true; // Variable to determine if user chooses to back out of profile page
    public boolean switchPokedex; // Variable to determine if user chooses to enter pokedex page

    // Constructor to be called to display the trainers profile (Medals, Name, Highscore, Golden Chips)
    public TrainerView(){
    }

    public void display() {
        switchPokedex = false;
        stayMainMenu = true;
        // Colours
        Color lightRed = new Color(255, 102, 102);
        Color lightBlue = new Color(31, 190, 214);

        // Creates label for a welcome message at the top of the main frame
        JLabel welcome = new JLabel("Welcome Trainer " + TrainerModel.trainerModel.getUsername() + "!");
        welcome.setOpaque(true);
        welcome.setBackground(Color.LIGHT_GRAY);
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setVerticalAlignment(JLabel.TOP);
        welcome.setBorder(BorderFactory.createMatteBorder(6, 6, 6, 6, Color.BLACK));
        welcome.setFont((new Font("Courier", Font.BOLD, 54)));

        // Image for trainer profile
        ImageIcon profilePic = new ImageIcon("profile.png"); // load the image to a imageIcon
        Image profileImg1 = profilePic.getImage(); // transform it
        Image profileImg2 = profileImg1.getScaledInstance(400, 200, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon profileIcon = new ImageIcon(profileImg2);  // transform it back

        // Creates button for trainer profile
        JButton profile = new JButton(profileIcon); // Adds trainer profile image to the button
        profile.setBackground(lightBlue);
        profile.setBorder(BorderFactory.createMatteBorder(0, 6, 6, 6, Color.BLACK));
        profile.setName("Profile");

        //Image for battle
        ImageIcon battlePic = new ImageIcon("battle.png"); // load the image to a imageIcon
        Image battleImg1 = battlePic.getImage(); // transform it
        Image battleImg2 = battleImg1.getScaledInstance(400, 200, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon battleIcon = new ImageIcon(battleImg2);  // transform it back

        // Creates button for battle
        JButton battle = new JButton(battleIcon); // Adds battle image to the button
        battle.setBackground(lightRed);
        battle.setBorder(BorderFactory.createMatteBorder(0, 0, 6, 6, Color.BLACK));
        battle.setName("Battle");

        // Button panel to contain the 2 buttons (Profile and Battle)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(profile);
        buttonPanel.add(battle);

        // Image for pokedex
        ImageIcon pokedexPic = new ImageIcon("pokedex.png"); // load the image to a imageIcon
        Image pokedexImg1 = pokedexPic.getImage(); // transform it
        Image pokedexImg2 = pokedexImg1.getScaledInstance(140, 140, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon pokedexIcon = new ImageIcon(pokedexImg2);  // transform it back

        // Creates button for pokedex
        JButton pokedexButton = new JButton("Pokedex", pokedexIcon); // Adds pokedex image to the button
        pokedexButton.setFont((new Font("Courier", Font.BOLD, 50)));
        pokedexButton.setBackground(lightRed);
        pokedexButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.BLACK));

        // Creates back button
        JButton back = new JButton("Back");
        back.setFont((new Font("Courier", Font.BOLD, 50)));
        back.setBackground(lightBlue);
        back.setName("Back");


        //Medal images
        ImageIcon medalPic1 = new ImageIcon("medal1.png"); // load the image to a imageIcon
        Image medalImg1 = medalPic1.getImage(); // transform it
        Image medalImg2 = medalImg1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon medalIcon1 = new ImageIcon(medalImg2);  // transform it back

        ImageIcon medalPic2 = new ImageIcon("medal2.png"); // load the image to a imageIcon
        Image medalImg3 = medalPic2.getImage(); // transform it
        Image medalImg4 = medalImg3.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon medalIcon2 = new ImageIcon(medalImg4);  // transform it back

        ImageIcon medalPic3 = new ImageIcon("medal3.png"); // load the image to a imageIcon
        Image medalImg5 = medalPic3.getImage(); // transform it
        Image medalImg6 = medalImg5.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon medalIcon3 = new ImageIcon(medalImg6);  // transform it back

        ImageIcon medalPic4 = new ImageIcon("medal4.png"); // load the image to a imageIcon
        Image medalImg7 = medalPic4.getImage(); // transform it
        Image medalImg8 = medalImg7.getScaledInstance(105, 105, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon medalIcon4 = new ImageIcon(medalImg8);  // transform it back

        ImageIcon medalPic5 = new ImageIcon("medal5.png"); // load the image to a imageIcon
        Image medalImg9 = medalPic5.getImage(); // transform it
        Image medalImg10 = medalImg9.getScaledInstance(105, 105, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon medalIcon5 = new ImageIcon(medalImg10);  // transform it back

        // Creates label for medal text
        JLabel medal = new JLabel();
        medal.setText("Medals: ");
        medal.setFont((new Font("Courier", Font.BOLD, 48)));
        medal.setVerticalAlignment(JLabel.CENTER);
        medal.setHorizontalAlignment(JLabel.CENTER);
        JLabel medal1 = new JLabel(medalIcon1); // Creates label for the first medal
        medal1.setHorizontalAlignment(JLabel.LEFT);
        JLabel medal2 = new JLabel(medalIcon2); // Creates label for the second medal
        medal2.setHorizontalAlignment(JLabel.LEFT);
        JLabel medal3 = new JLabel(medalIcon3); // Creates label for the third medal
        medal3.setHorizontalAlignment(JLabel.LEFT);
        JLabel medal4 = new JLabel(medalIcon4); // Creates label for the fourth medal
        medal4.setHorizontalAlignment(JLabel.LEFT);
        JLabel medal5 = new JLabel(medalIcon5); // Creates label for the fifth medal
        medal5.setHorizontalAlignment(JLabel.LEFT);

        // Creates label for the other info in trainer profile (Username, Highscore and Golden Chips)
        JLabel row2 = new JLabel();
        row2.setFont((new Font("Courier", Font.BOLD, 22)));
        row2.setHorizontalAlignment(JLabel.CENTER);
        row2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.BLACK));
        row2.setText("<html>Username: <html>" + TrainerModel.trainerModel.getUsername() +
                "<html><br>Golden Chips: <html>" + TrainerModel.trainerModel.getGoldenChip() + "/10");

        TrainerModel.trainerModel.determineScorePlacement();

        JLabel scoreLabel = new JLabel("Top 5 Battle Scores:");
        scoreLabel.setHorizontalAlignment(JLabel.RIGHT);
        scoreLabel.setFont(new Font("Courier", Font.BOLD, 26));

        JLabel score1 = new JLabel();
        score1.setText("1) " + TrainerModel.trainerModel.getHighscores().get(5));
        score1.setHorizontalAlignment(JLabel.CENTER);
        score1.setFont(new Font("Courier", Font.BOLD, 32));

        JLabel score2and3 = new JLabel();
        score2and3.setText("<html>2) <html>" + TrainerModel.trainerModel.getHighscores().get(4) +
                "<html><br><br>3) <html>" + TrainerModel.trainerModel.getHighscores().get(3));
        score2and3.setFont(new Font("Courier", Font.BOLD, 28));

        JLabel score4and5 = new JLabel();
        score4and5.setText("<html>4) <html>" + TrainerModel.trainerModel.getHighscores().get(2) +
                "<html><br><br>5) <html>" + TrainerModel.trainerModel.getHighscores().get(1));
        score4and5.setFont(new Font("Courier", Font.BOLD, 28));

        JPanel middleRowContent = new JPanel();
        middleRowContent.setLayout(new GridLayout(1, 5));
        middleRowContent.setBorder(BorderFactory.createMatteBorder(3, 0, 3, 0, Color.BLACK));
        middleRowContent.setOpaque(false);
        middleRowContent.add(row2);
        middleRowContent.add(scoreLabel);
        middleRowContent.add(score1);
        middleRowContent.add(score2and3);
        middleRowContent.add(score4and5);

        // Creates panel to contain the 5 medals in the top row of trainer profile
        JPanel row1 = new JPanel();
        row1.setLayout(new GridLayout(1, 6));
        row1.setBackground(Color.LIGHT_GRAY);
        row1.add(medal);
        if (TrainerModel.trainerModel.getGaOleMedal() > 0) {
            row1.add(medal1);
        }
        if (TrainerModel.trainerModel.getGaOleMedal() > 1) {
            row1.add(medal2);
        }
        if (TrainerModel.trainerModel.getGaOleMedal() > 2) {
            row1.add(medal3);
        }
        if (TrainerModel.trainerModel.getGaOleMedal() > 3) {
            row1.add(medal4);
        }
        if (TrainerModel.trainerModel.getGaOleMedal() > 4) {
            row1.add(medal5);
        }

        // Creates panel to contain the pokedex button and back button in the bottom row of trainer profile
        JPanel row3 = new JPanel();
        row3.setLayout(new GridLayout(1, 2));
        row3.add(pokedexButton); // Adds pokedex button to the panel
        row3.add(back); // Adds back button to the panel

        // Creates panel to contain the contents of trainer profile page (Medals, Other info, Pokedex & Back button)
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 1));

        contentPanel.setBackground(Color.LIGHT_GRAY);
        contentPanel.add(row1); // Adds medal panel to top row
        contentPanel.add(middleRowContent); // Adds other info panel
        contentPanel.add(row3); // Adds pokedex & back button panel to bottom row

        // Creates frame to contain the panel for the trainer profile contents
        JFrame trainerProfile = new JFrame();
        trainerProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        trainerProfile.setSize(1330, 500);
        trainerProfile.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
        trainerProfile.setTitle("Trainer Profile");
        trainerProfile.setLocationRelativeTo(null);
        trainerProfile.add(contentPanel);

        // Creates action listener for profile, battle and back button
        ActionListener buttonAction = e -> {
            JButton button = (JButton) e.getSource();
            // Enters trainer proifile page
            if (Objects.equals(button.getName(), "Profile")) {
                setVisible(false);
                dispose();
                trainerProfile.setVisible(true);
            }
            // Enters battle (Stage select)
            else if (Objects.equals(button.getName(), "Battle")) {
                setVisible(false);
                stayMainMenu = false;
                dispose();
            }
            // Backtracks to previous page
            else if (Objects.equals(button.getName(), "Back")) {
                dispose();
                trainerProfile.setVisible(false);
                setVisible(true);
            }
            // Enters pokedex page
            else {
                dispose();
                UIManager.put("OptionPane.background", lightRed);
                UIManager.put("Panel.background", lightRed);
                UIManager.put("OptionPane.messageFont", new Font("Courier", Font.BOLD, 18));
                // Popup that informs user that the pokemon they own are highlighted green in the pokedex
                JOptionPane.showMessageDialog(null, "Pokemon You Own \nAre Highlighted \nIn Green!",
                        "Entering Pokedex...", JOptionPane.PLAIN_MESSAGE, pokedexIcon);
                UIManager.put("Panel.background", Color.LIGHT_GRAY);
                trainerProfile.setVisible(false);
                stayMainMenu = false;
                switchPokedex = true;
            }
        };

        // Add the action listener to the back, pokedex, profile and battle buttons
        back.addActionListener(buttonAction);
        pokedexButton.addActionListener(buttonAction);
        profile.addActionListener(buttonAction);
        battle.addActionListener(buttonAction);

        add(welcome, BorderLayout.NORTH); // Adds the welcome message panel to the top of the main frame
        add(buttonPanel); // Adds the panel that contains the trainer profile and battle buttons to the main frame

        // Sets main frame size, position, visibility, title, border, background colour and exit operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setTitle("Main Menu");
        setSize(1320, 480);
        setLocationRelativeTo(null);
        setVisible(true);



    }
}