import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

// Displays the 3 stages the user may choose
public class StageView extends JFrame {
    public String stage = "";  // Variable to store the choice of stage made by the user

    // Constructor to call the stage options for user to choose
    public StageView() {
    }
    public void display() {
        stage = "";
        //Colours
        Color lightRed = new Color(255, 102, 102);
        Color lightBlue = new Color(31, 190, 214);
        Color lightOrange = new Color(255, 165, 0);

        // Popup to inform the user that they need to choose a stage to battle
        ImageIcon stagePic = new ImageIcon("stage.jpg"); // load the image to a imageIcon
        Image stageImg1 = stagePic.getImage(); // transform it
        Image stageImg2 = stageImg1.getScaledInstance(560, 360, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon stageIcon = new ImageIcon(stageImg2);  // transform it back
        // Changes the background colour of the popup
        UIManager.put("OptionPane.background", lightBlue);
        UIManager.put("Panel.background", lightBlue);
        // The popup message
        JOptionPane.showMessageDialog(null, null, "Choose a Stage for Battle!",
                JOptionPane.PLAIN_MESSAGE, stageIcon);

        //Lakeside stage option button
        ImageIcon lake = new ImageIcon("Lakeside.jpg"); // load the image to a imageIcon
        Image lakei = lake.getImage(); // transform it
        Image lakeii = lakei.getScaledInstance(350, 170, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon lakeIcon = new ImageIcon(lakeii);  // transform it back
        JButton Lake = new JButton(StageController.lake.toString(), lakeIcon); // Creates button with info of the likely pokemon to spawn with an icon
        Lake.setName("Lakeside");
        Lake.setBackground(lightBlue); // Changes background of button to match the type of pokemon that are likely to spawn there
        Lake.setFont(new Font("Courier", Font.BOLD, 12)); // Changes the font style
        Lake.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK)); // Adds a border to the button
        Lake.setHorizontalAlignment(JButton.LEFT);

        //Volcano stage option button
        ImageIcon volcano = new ImageIcon("Volcano.jpg"); // load the image to a imageIcon
        Image volcanoi = volcano.getImage(); // transform it
        Image volcanoii = volcanoi.getScaledInstance(350, 170, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon volcanoIcon = new ImageIcon(volcanoii);  // transform it back
        JButton Volcano = new JButton(StageController.volcano.getVolcano().toString(), volcanoIcon);
        Volcano.setName("Volcano");
        Volcano.setBackground(lightRed);
        Volcano.setFont(new Font("Courier", Font.BOLD, 12));
        Volcano.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
        Volcano.setHorizontalAlignment(JButton.LEFT);

        //Desert stage option button
        ImageIcon desert = new ImageIcon("Desert.jpg"); // load the image to a imageIcon
        Image deserti = desert.getImage(); // transform it
        Image desertii = deserti.getScaledInstance(350, 170, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon desertIcon = new ImageIcon(desertii);  // transform it back
        JButton Desert = new JButton(StageController.desert.getDesert().toString(), desertIcon);
        Desert.setName("Desert");
        Desert.setBackground(lightOrange);
        Desert.setFont(new Font("Courier", Font.BOLD, 12));
        Desert.setHorizontalAlignment(JButton.LEFT);



        // Create a panel to display the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1)); // Sets the panel with 3 rows to fit the 3 stage buttons
        // Adds the stage buttons to the panel
        buttonPanel.add(Lake);
        buttonPanel.add(Volcano);
        buttonPanel.add(Desert);


        // Creates action listener for the stage buttons to set the stageOption variable based on the users choice
        ActionListener buttonAction = e -> {
            JButton button = (JButton) e.getSource();

            if (Objects.equals(button.getName(), "Lakeside")) {
                UIManager.put("OptionPane.background", lightBlue);
                UIManager.put("Panel.background", lightBlue);
                // Popup message informing the user of the selected stage
                JOptionPane.showMessageDialog(null, null, "Lakeside Stage Selected!",
                        JOptionPane.PLAIN_MESSAGE, lakeIcon);
                stage = "Lakeside"; // Lakeside stage
            } else if (Objects.equals(button.getName(), "Volcano")) {
                UIManager.put("OptionPane.background", lightRed);
                UIManager.put("Panel.background", lightRed);
                JOptionPane.showMessageDialog(null, null, "Volcano Stage Selected!",
                        JOptionPane.PLAIN_MESSAGE, volcanoIcon);
                stage = "Volcano"; // Volcano stage
            } else {
                UIManager.put("OptionPane.background", lightOrange);
                UIManager.put("Panel.background", lightOrange);
                JOptionPane.showMessageDialog(null, null, "Desert Stage Selected!",
                        JOptionPane.PLAIN_MESSAGE, desertIcon);
                stage = "Desert"; // Desert stage
            }
            dispose(); // Close the frame
        };

        // Adds the action listener to the 3 stage buttons
        Lake.addActionListener(buttonAction);
        Volcano.addActionListener(buttonAction);
        Desert.addActionListener(buttonAction);

        // Add the panel with the 3 stage buttons to the main frame
        add(buttonPanel);

        // Sets main frame size, position, title, visibility and exit operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1320, 550);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
        setTitle("Stages");
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
