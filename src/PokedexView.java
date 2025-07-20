import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

// Displays all pokemon in the game and highlights those the user owns
public class PokedexView extends JFrame {
    private int currentFrame = 1; // Variable to keep track of the current pokedex page
    public boolean stayPokedex = true; // Variable to determine if user chooses to back out of pokedex view

    // Constructor to call the pokedex
    public PokedexView() {
    }

    public void display() {
        stayPokedex = true;
        // Colour
        Color lightRed = new Color(255, 102, 102);
        Color lightBlue = new Color(31, 190, 214);
        Color lightGreen = new Color(102, 255, 102);

        // Panel 1 of pokedex (Page 1) - contains 6 pokemon
        JPanel pokedexPanel1 = new JPanel();
        pokedexPanel1.setLayout(new GridLayout(4, 2));
        pokedexPanel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Panel 2 of pokedex (Page 2) - contains 6 pokemon
        JPanel pokedexPanel2 = new JPanel();
        pokedexPanel2.setLayout(new GridLayout(4, 2));
        pokedexPanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Panel 3 of pokedex (Page 3) - contains 6 pokemon
        JPanel pokedexPanel3 = new JPanel();
        pokedexPanel3.setLayout(new GridLayout(4, 2));
        pokedexPanel3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Panel 4 of pokedex (Page 4) - contains 6 pokemon
        JPanel pokedexPanel4 = new JPanel();
        pokedexPanel4.setLayout(new GridLayout(4, 2));
        pokedexPanel4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Panel for panel 5 row 2 (Page 5 row 2 split into 2 columns)
        JPanel panel5Row2 = new JPanel();
        panel5Row2.setLayout(new GridLayout(1, 2));

        // Panel 5 of pokedex (Page 5) - Page 5 has only 1 pokemon
        JPanel pokedexPanel5 = new JPanel();
        pokedexPanel5.setLayout(new GridLayout(2, 1));
        pokedexPanel5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Sets labels with the pokemon's grade and name
        JLabel entry1 = new JLabel(PokedexModel.allPokemon.get(0).toString());
        entry1.setFont((new Font("Courier", Font.BOLD, 12))); // Changes the font style
        entry1.setIcon(PokemonImages.miloticIcon); // Sets the pokemon's icon
        entry1.setBorder(BorderFactory.createMatteBorder(0, 0,3, 3, Color.BLACK)); // Sets the border
        // Determines if user owns this pokemon then highlights it green
        if (TrainerModel.trainerModel.checkOwned("Milotic")) {
            entry1.setOpaque(true);
            entry1.setBackground(lightGreen);
        }

        JLabel entry2 = new JLabel(PokedexModel.allPokemon.get(1).toString());
        entry2.setFont((new Font("Courier", Font.BOLD, 12)));
        entry2.setIcon(PokemonImages.squirtleIcon);
        entry2.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.BLACK));
         if (TrainerModel.trainerModel.checkOwned("Squirtle")) {
            entry2.setOpaque(true);
            entry2.setBackground(lightGreen);
        }

        JLabel entry3 = new JLabel(PokedexModel.allPokemon.get(2).toString());
        entry3.setFont((new Font("Courier", Font.BOLD, 12)));
        entry3.setIcon(PokemonImages.seelIcon);
        entry3.setBorder(BorderFactory.createMatteBorder(0, 0,3, 3, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Seel")) {
            entry3.setOpaque(true);
            entry3.setBackground(lightGreen);
        }

        JLabel entry4 = new JLabel(PokedexModel.allPokemon.get(3).toString());
        entry4.setFont((new Font("Courier", Font.BOLD, 12)));
        entry4.setIcon(PokemonImages.gyaradosIcon);
        entry4.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Gyarados")) {
            entry4.setOpaque(true);
            entry4.setBackground(lightGreen);
        }

        JLabel entry5 = new JLabel(PokedexModel.allPokemon.get(4).toString());
        entry5.setFont((new Font("Courier", Font.BOLD, 12)));
        entry5.setIcon(PokemonImages.suicuneIcon);
        entry5.setBorder(BorderFactory.createMatteBorder(0, 0,3, 3, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Suicune")) {
            entry5.setOpaque(true);
            entry5.setBackground(lightGreen);
        }

        JLabel entry6 = new JLabel(PokedexModel.allPokemon.get(5).toString());
        entry6.setFont((new Font("Courier", Font.BOLD, 12)));
        entry6.setIcon(PokemonImages.charizardIcon);
        entry6.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Charizard")) {
            entry6.setOpaque(true);
            entry6.setBackground(lightGreen);
        }

        JLabel entry7 = new JLabel(PokedexModel.allPokemon.get(6).toString());
        entry7.setFont((new Font("Courier", Font.BOLD, 12)));
        entry7.setIcon(PokemonImages.fennekinIcon);
        entry7.setBorder(BorderFactory.createMatteBorder(0, 0,3, 3, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Fennekin")) {
            entry7.setOpaque(true);
            entry7.setBackground(lightGreen);
        }

        JLabel entry8 = new JLabel(PokedexModel.allPokemon.get(7).toString());
        entry8.setFont((new Font("Courier", Font.BOLD, 12)));
        entry8.setIcon(PokemonImages.coalossalIcon);
        entry8.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Coalossal")) {
            entry8.setOpaque(true);
            entry8.setBackground(lightGreen);
        }

        JLabel entry9 = new JLabel(PokedexModel.allPokemon.get(8).toString());
        entry9.setFont((new Font("Courier", Font.BOLD, 12)));
        entry9.setIcon(PokemonImages.volcanionIcon);
        entry9.setBorder(BorderFactory.createMatteBorder(0, 0,3, 3, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Volcanion")) {
            entry9.setOpaque(true);
            entry9.setBackground(lightGreen);
        }

        JLabel entry10 = new JLabel(PokedexModel.allPokemon.get(9).toString());
        entry10.setFont((new Font("Courier", Font.BOLD, 12)));
        entry10.setIcon(PokemonImages.flareonIcon);
        entry10.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Flareon")) {
            entry10.setOpaque(true);
            entry10.setBackground(lightGreen);
        }

        JLabel entry11 = new JLabel(PokedexModel.allPokemon.get(10).toString());
        entry11.setFont((new Font("Courier", Font.BOLD, 12)));
        entry11.setIcon(PokemonImages.meganiumIcon);
        entry11.setBorder(BorderFactory.createMatteBorder(0, 0,3, 3, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Meganium")) {
            entry11.setOpaque(true);
            entry11.setBackground(lightGreen);
        }

        JLabel entry12 = new JLabel(PokedexModel.allPokemon.get(11).toString());
        entry12.setFont((new Font("Courier", Font.BOLD, 12)));
        entry12.setIcon(PokemonImages.sceptileIcon);
        entry12.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Sceptile")) {
            entry12.setOpaque(true);
            entry12.setBackground(lightGreen);
        }

        JLabel entry13 = new JLabel(PokedexModel.allPokemon.get(12).toString());
        entry13.setFont((new Font("Courier", Font.BOLD, 12)));
        entry13.setIcon(PokemonImages.cherubiIcon);
        entry13.setBorder(BorderFactory.createMatteBorder(0, 0,3, 3, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Cherubi")) {
            entry13.setOpaque(true);
            entry13.setBackground(lightGreen);
        }

        JLabel entry14 = new JLabel(PokedexModel.allPokemon.get(13).toString());
        entry14.setFont((new Font("Courier", Font.BOLD, 12)));
        entry14.setIcon(PokemonImages.snivyIcon);
        entry14.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Snivy")) {
            entry14.setOpaque(true);
            entry14.setBackground(lightGreen);
        }

        JLabel entry15 = new JLabel(PokedexModel.allPokemon.get(14).toString());
        entry15.setFont((new Font("Courier", Font.BOLD, 12)));
        entry15.setIcon(PokemonImages.shayminIcon);
        entry15.setBorder(BorderFactory.createMatteBorder(0, 0,3, 3, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Shaymin")) {
            entry15.setOpaque(true);
            entry15.setBackground(lightGreen);
        }

        JLabel entry16 = new JLabel(PokedexModel.allPokemon.get(15).toString());
        entry16.setFont((new Font("Courier", Font.BOLD, 12)));
        entry16.setIcon(PokemonImages.ho_ohIcon);
        entry16.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Ho-Oh")) {
            entry16.setOpaque(true);
            entry16.setBackground(lightGreen);
        }

        JLabel entry17 = new JLabel(PokedexModel.allPokemon.get(16).toString());
        entry17.setFont((new Font("Courier", Font.BOLD, 12)));
        entry17.setIcon(PokemonImages.talonflameIcon);
        entry17.setBorder(BorderFactory.createMatteBorder(0, 0,3, 3, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Talonflame")) {
            entry17.setOpaque(true);
            entry17.setBackground(lightGreen);
        }

        JLabel entry18 = new JLabel(PokedexModel.allPokemon.get(17).toString());
        entry18.setFont((new Font("Courier", Font.BOLD, 12)));
        entry18.setIcon(PokemonImages.rowletIcon);
        entry18.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Rowlet")) {
            entry18.setOpaque(true);
            entry18.setBackground(lightGreen);
        }

        JLabel entry19 = new JLabel(PokedexModel.allPokemon.get(18).toString());
        entry19.setFont((new Font("Courier", Font.BOLD, 12)));
        entry19.setIcon(PokemonImages.skiploomIcon);
        entry19.setBorder(BorderFactory.createMatteBorder(0, 0,3, 3, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Skiploom")) {
            entry19.setOpaque(true);
            entry19.setBackground(lightGreen);
        }

        JLabel entry20 = new JLabel(PokedexModel.allPokemon.get(19).toString());
        entry20.setFont((new Font("Courier", Font.BOLD, 12)));
        entry20.setIcon(PokemonImages.peliperIcon);
        entry20.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Pelipper")) {
            entry20.setOpaque(true);
            entry20.setBackground(lightGreen);
        }

        JLabel entry21 = new JLabel(PokedexModel.allPokemon.get(20).toString());
        entry21.setFont((new Font("Courier", Font.BOLD, 12)));
        entry21.setIcon(PokemonImages.sudowoodoIcon);
        entry21.setBorder(BorderFactory.createMatteBorder(0, 0,3, 3, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Sudowoodo")) {
            entry21.setOpaque(true);
            entry21.setBackground(lightGreen);
        }

        JLabel entry22 = new JLabel(PokedexModel.allPokemon.get(21).toString());
        entry22.setFont((new Font("Courier", Font.BOLD, 12)));
        entry22.setIcon(PokemonImages.lileepIcon);
        entry22.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Lileep")) {
            entry22.setOpaque(true);
            entry22.setBackground(lightGreen);
        }

        JLabel entry23 = new JLabel(PokedexModel.allPokemon.get(22).toString());
        entry23.setFont((new Font("Courier", Font.BOLD, 12)));
        entry23.setIcon(PokemonImages.bonslyIcon);
        entry23.setBorder(BorderFactory.createMatteBorder(0, 0,3, 3, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Bonsly")) {
            entry23.setOpaque(true);
            entry23.setBackground(lightGreen);
        }

        JLabel entry24 = new JLabel(PokedexModel.allPokemon.get(23).toString());
        entry24.setFont((new Font("Courier", Font.BOLD, 12)));
        entry24.setIcon(PokemonImages.archeopsIcon);
        entry24.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.BLACK));
        if (TrainerModel.trainerModel.checkOwned("Archeops")) {
            entry24.setOpaque(true);
            entry24.setBackground(lightGreen);
        }

        JLabel entry25 = new JLabel(PokedexModel.allPokemon.get(24).toString());
        entry25.setFont((new Font("Courier", Font.BOLD, 24)));
        entry25.setIcon(PokemonImages.regirockIcon);
        entry25.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.BLACK));
        entry25.setHorizontalAlignment(JLabel.CENTER);
        if (TrainerModel.trainerModel.checkOwned("Regirock")) {
            entry25.setOpaque(true);
            entry25.setBackground(lightGreen);
        }

        //Back button
        JButton back = new JButton("Back");
        back.setFont((new Font("Courier", Font.BOLD, 50)));
        back.setBackground(lightBlue);
        back.setName("Back");
        back.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.BLACK));

        //Next button
        JButton next = new JButton("Next");
        next.setFont((new Font("Courier", Font.BOLD, 50)));
        next.setBackground(lightRed);
        next.setName("Next");

        //Add the pokemon to panel 1
        pokedexPanel1.add(entry1);
        pokedexPanel1.add(entry2);
        pokedexPanel1.add(entry3);
        pokedexPanel1.add(entry4);
        pokedexPanel1.add(entry5);
        pokedexPanel1.add(entry6);

        //Add the pokemon to panel 2
        pokedexPanel2.add(entry7);
        pokedexPanel2.add(entry8);
        pokedexPanel2.add(entry9);
        pokedexPanel2.add(entry10);
        pokedexPanel2.add(entry11);
        pokedexPanel2.add(entry12);

        //Add the pokemon to panel 3
        pokedexPanel3.add(entry13);
        pokedexPanel3.add(entry14);
        pokedexPanel3.add(entry15);
        pokedexPanel3.add(entry16);
        pokedexPanel3.add(entry17);
        pokedexPanel3.add(entry18);

        //Add the pokemon to panel 4
        pokedexPanel4.add(entry19);
        pokedexPanel4.add(entry20);
        pokedexPanel4.add(entry21);
        pokedexPanel4.add(entry22);
        pokedexPanel4.add(entry23);
        pokedexPanel4.add(entry24);

        //Add the pokemon to panel 5
        pokedexPanel5.add(entry25);

        // Creates action listener for the next and back button to go through the pokedex pages or return to profile screen
        ActionListener buttonAction = e -> {
            JButton button = (JButton) e.getSource();
            // Enters when user clicks the back button
            if (Objects.equals(button.getName(), "Back")) {
                currentFrame -= 1;
                switch (currentFrame) {
                    case 0: // Goes back to profile screen
                        dispose();
                        stayPokedex = false;
                        break;
                    case 1: // Opens page 1 from page 2
                        pokedexPanel2.setVisible(false);
                        pokedexPanel1.add(back); // Adds back button to bottom row
                        pokedexPanel1.add(next); // adds next button to bottom row
                        add(pokedexPanel1);
                        pokedexPanel1.setVisible(true);
                        break;
                    case 2: // Opens page 2 from page 3
                        pokedexPanel3.setVisible(false);
                        pokedexPanel2.add(back);
                        pokedexPanel2.add(next);
                        add(pokedexPanel2);
                        pokedexPanel2.setVisible(true);
                        break;
                    case 3: // Opens page 3 from page 4
                        pokedexPanel4.setVisible(false);
                        pokedexPanel3.add(back);
                        pokedexPanel3.add(next);
                        add(pokedexPanel3);
                        pokedexPanel3.setVisible(true);
                        break;
                    default: // Opens page 4 from page 5
                        pokedexPanel5.setVisible(false);
                        pokedexPanel4.add(back);
                        pokedexPanel4.add(next);
                        add(pokedexPanel4);
                        pokedexPanel4.setVisible(true);
                }
            }
            // When user clicks next
            else {
                currentFrame += 1;
                switch (currentFrame) {
                    case 2: // Opens page 2
                        pokedexPanel1.setVisible(false);
                        pokedexPanel2.add(back);
                        pokedexPanel2.add(next);
                        add(pokedexPanel2);
                        pokedexPanel2.setVisible(true);
                        break;
                    case 3: // Opens page 3
                        pokedexPanel2.setVisible(false);
                        pokedexPanel3.add(back);
                        pokedexPanel3.add(next);
                        add(pokedexPanel3);
                        pokedexPanel3.setVisible(true);
                        break;
                    case 4: // Opens page 4
                        pokedexPanel3.setVisible(false);
                        pokedexPanel4.add(back);
                        pokedexPanel4.add(next);
                        add(pokedexPanel4);
                        pokedexPanel4.setVisible(true);
                        break;
                    case 5: // Opens page 5
                        pokedexPanel4.setVisible(false);
                        panel5Row2.add(back);
                        panel5Row2.add(next);
                        pokedexPanel5.add(panel5Row2);
                        add(pokedexPanel5);
                        pokedexPanel5.setVisible(true);
                        break;
                    default: // Goes back to profile screen
                        dispose();
                        stayPokedex = false;
                }
            }
        };

        // Add action listener to the back and next buttons
        next.addActionListener(buttonAction);
        back.addActionListener(buttonAction);
        // Adds the back and next buttons to page 1
        pokedexPanel1.add(back);
        pokedexPanel1.add(next);
        // Adds page 1 to the main frame
        add(pokedexPanel1);

        // Sets main frame size, position, visibility, title, background colour and exit operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(1800, 580);
        getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
        setTitle("Pokedex");
        setLocationRelativeTo(null);
        setVisible(true);
    }
}