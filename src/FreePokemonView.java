import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

// Displays the 3 generated pokemon for user to choose
public class FreePokemonView extends JFrame {
    public boolean stayFreePokemon = true;

    // Constructor to be called to display the free pokemon options
    public FreePokemonView() {
    }

    public void display() {
        stayFreePokemon = true;
        // Colours
        Color lightBlue = new Color(31, 190, 214);
        Color lightOrange = new Color(255, 165, 0);
        Color lightRed = new Color(255, 102, 102);
        Color lightGreen = new Color(102, 255, 102);

        // Displays a popup message to prompt the user to choose a pokemon
        // Customises the image
        ImageIcon choose = new ImageIcon("chooseFree.png"); // load the image to an imageIcon
        Image choosei = choose.getImage(); // transform it
        Image chooseii = choosei.getScaledInstance(400, 360, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon chooseIcon = new ImageIcon(chooseii);  // transform it back
        // Changes the background colour of the popup message
        UIManager.put("OptionPane.background", Color.LIGHT_GRAY);
        UIManager.put("Panel.background", Color.LIGHT_GRAY);
        // The popup message
        JOptionPane.showMessageDialog(null, null,
                "Please Choose a Pokemon to Join Your Party!", JOptionPane.PLAIN_MESSAGE, chooseIcon);

        // Creates a panel with 3 rows to display the 3 options of free pokemon
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));

        // Creates action listener for the buttons(each button shows 1 pokemon) for user to choose a free pokemon
        ActionListener buttonAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                // Changes the background colour of the popup message
                UIManager.put("OptionPane.background", button.getBackground());
                UIManager.put("Panel.background", button.getBackground());
                // Displays a popup message informing them that the pokemon they chose has joined their party
                JOptionPane.showMessageDialog(null, null, button.getName() +
                        " Has Joined Your Party!", JOptionPane.PLAIN_MESSAGE, button.getIcon());
                dispose(); // Close the frame

                // Adds the pokemon the user chose into their party(Text file)
                if (Objects.equals(button.getName(), FreePokemonModel.poke1.getName())) {
                    TrainerModel.trainerModel.addToParty(FreePokemonModel.poke1);
                } else if (Objects.equals(button.getName(), FreePokemonModel.poke2.getName())) {
                    TrainerModel.trainerModel.addToParty(FreePokemonModel.poke2);
                } else {
                    TrainerModel.trainerModel.addToParty(FreePokemonModel.poke3);
                }
                stayFreePokemon = false;
            }
        };

        // Runs through each name of the 3 randomly generated pokemon to link it to an image and display their stats
        for (String pokeName : FreePokemonModel.free.getPokeNames()) {
            switch (pokeName) {
                case "Seel":
                    JButton Seel = new JButton( "         " + PokedexModel.allPokemon.get(2).toString(), PokemonImages.seelIcon); // Creates a button with the pokemon's stats and icon
                    Seel.setName("Seel"); // Sets the name of the button to match the pokemon's name
                    Seel.setBackground(lightBlue); // Changes background colour to match pokemon type
                    buttonPanel.add(Seel); // Adds this button to the 3 row panel previously created
                    Seel.addActionListener(buttonAction); // Adds the action listener to the button so event occurs when user clicks it
                    Seel.setFont(new Font("Courier", Font.BOLD, 18)); // Changes the font style
                    Seel.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.BLACK)); // Adds a border to the button
                    Seel.setHorizontalAlignment(JButton.LEFT);
                    break;
                case "Rowlet":
                    JButton Rowlet = new JButton("         " + PokedexModel.allPokemon.get(17).toString(), PokemonImages.rowletIcon);
                    Rowlet.setName("Rowlet");
                    Rowlet.setBackground(lightGreen);
                    buttonPanel.add(Rowlet);
                    Rowlet.addActionListener(buttonAction);
                    Rowlet.setFont(new Font("Courier", Font.BOLD, 18));
                    Rowlet.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.BLACK));
                    Rowlet.setHorizontalAlignment(JButton.LEFT);
                    break;
                case "Skiploom":
                    JButton Skiploom = new JButton("         " + PokedexModel.allPokemon.get(18).toString(), PokemonImages.skiploomIcon);
                    Skiploom.setName("Skiploom");
                    Skiploom.setBackground(lightGreen);
                    buttonPanel.add(Skiploom);
                    Skiploom.addActionListener(buttonAction);
                    Skiploom.setFont(new Font("Courier", Font.BOLD, 18));
                    Skiploom.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.BLACK));
                    Skiploom.setHorizontalAlignment(JButton.LEFT);
                    break;
                case "Bonsly":
                    JButton Bonsly = new JButton("         " + PokedexModel.allPokemon.get(22).toString(), PokemonImages.bonslyIcon);
                    Bonsly.setName("Bonsly");
                    Bonsly.setBackground(lightOrange);
                    buttonPanel.add(Bonsly);
                    Bonsly.addActionListener(buttonAction);
                    Bonsly.setFont(new Font("Courier", Font.BOLD, 18));
                    Bonsly.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.BLACK));
                    Bonsly.setHorizontalAlignment(JButton.LEFT);
                    break;
                case "Cherubi":
                    JButton Cherubi = new JButton("         " + PokedexModel.allPokemon.get(12).toString(), PokemonImages.cherubiIcon);
                    Cherubi.setName("Cherubi");
                    Cherubi.setBackground(lightGreen);
                    buttonPanel.add(Cherubi);
                    Cherubi.addActionListener(buttonAction);
                    Cherubi.setFont(new Font("Courier", Font.BOLD, 18));
                    Cherubi.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.BLACK));
                    Cherubi.setHorizontalAlignment(JButton.LEFT);
                    break;
                case "Snivy":
                    JButton Snivy = new JButton("         " + PokedexModel.allPokemon.get(13).toString(), PokemonImages.snivyIcon);
                    Snivy.setName("Snivy");
                    Snivy.setBackground(lightGreen);
                    buttonPanel.add(Snivy);
                    Snivy.addActionListener(buttonAction);
                    Snivy.setFont(new Font("Courier", Font.BOLD, 18));
                    Snivy.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.BLACK));
                    Snivy.setHorizontalAlignment(JButton.LEFT);
                    break;
                default:
                    JButton Flareon = new JButton("         " + PokedexModel.allPokemon.get(9).toString(), PokemonImages.flareonIcon);
                    Flareon.setName("Flareon");
                    Flareon.setBackground(lightRed);
                    buttonPanel.add(Flareon);
                    Flareon.addActionListener(buttonAction);
                    Flareon.setFont(new Font("Courier", Font.BOLD, 18));
                    Flareon.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.BLACK));
                    Flareon.setHorizontalAlignment(JButton.LEFT);
            }
        }

        // Add the 3 row panel to the main frame
        add(buttonPanel, BorderLayout.CENTER);

        // Sets main frame size, position, visibility, title, border and exit operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 460);
        setTitle("Free Ally Pokemon");
        setVisible(true);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 0, 4, Color.BLACK));
        setLocationRelativeTo(null);
    }
}
