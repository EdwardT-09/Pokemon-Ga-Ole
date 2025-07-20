import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class CatchView extends JFrame{
    private int repeat = 0;
    public boolean catchNext;
    private Image backgroundImage, backgroundImage2;
    private String pokeballSelected;
    public int pokemonCaught = 0;
    public int pokemonGradeCaught = 0;

    public CatchView() {
    }

    public void display() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        repaint();
        catchNext = false;

        Color lightGreen = new Color(102, 255, 102);
        Color lightOrange = new Color(255, 165, 0);

        JLabel pokemonName1 = new JLabel(BattleController.pokemonBattleModel.getEnemy1().getName() + BattleController.pokemonBattleModel.getEnemy1().printGrade());
        pokemonName1.setHorizontalAlignment(JLabel.CENTER);
        pokemonName1.setFont(new Font("Courier", Font.BOLD, 22));
        pokemonName1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4, Color.BLACK));

        JLabel pokemonGauge1 = new JLabel("Catch Gauge: " + decimalFormat.format(BattleController.pokemonBattleModel.getCatchgauge1())  + "%");
        pokemonGauge1.setFont(new Font("Courier", Font.BOLD, 22));
        pokemonGauge1.setHorizontalAlignment(JLabel.CENTER);
        pokemonGauge1.setVerticalAlignment(JLabel.TOP);
        pokemonGauge1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4, Color.BLACK));

        JLabel owned1 = new JLabel("");
        owned1.setHorizontalAlignment(JLabel.CENTER);
        owned1.setVerticalAlignment(JLabel.TOP);
        owned1.setFont(new Font("Courier", Font.BOLD, 24));
        owned1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4, Color.BLACK));

        JLabel pokemonName2 = new JLabel(BattleController.pokemonBattleModel.getEnemy2().getName() + BattleController.pokemonBattleModel.getEnemy2().printGrade());
        pokemonName2.setHorizontalAlignment(JLabel.CENTER);
        pokemonName2.setFont(new Font("Courier", Font.BOLD, 22));

        JLabel pokemonGauge2 = new JLabel("Catch Gauge: " + decimalFormat.format(BattleController.pokemonBattleModel.getCatchgauge2()) + "%");
        pokemonGauge2.setHorizontalAlignment(JLabel.CENTER);
        pokemonGauge2.setFont(new Font("Courier", Font.BOLD, 22));
        pokemonGauge2.setVerticalAlignment(JLabel.TOP);

        JLabel owned2 = new JLabel("");
        owned2.setHorizontalAlignment(JLabel.CENTER);
        owned2.setVerticalAlignment(JLabel.TOP);
        owned2.setFont(new Font("Courier", Font.BOLD, 24));

        JPanel pokemonTopRowPanel = new JPanel();
        pokemonTopRowPanel.setLayout(new GridLayout(1, 2));
        pokemonTopRowPanel.setOpaque(false);
        pokemonTopRowPanel.add(pokemonName1);
        pokemonTopRowPanel.add(pokemonName2);

        JPanel pokemonMiddleRow = new JPanel();
        pokemonMiddleRow.setLayout(new GridLayout(1, 2));
        pokemonMiddleRow.setOpaque(false);
        pokemonMiddleRow.add(pokemonGauge1);
        pokemonMiddleRow.add(pokemonGauge2);

        JPanel pokemonBottomRow = new JPanel();
        pokemonBottomRow.setLayout(new GridLayout(1, 2));
        pokemonBottomRow.setOpaque(false);
        pokemonBottomRow.add(owned1);
        pokemonBottomRow.add(owned2);

        JButton throwBall = new JButton("Catch " + BattleController.pokemonBattleModel.getEnemy1().getName() + "!");
        throwBall.setFont(new Font("Courier", Font.BOLD, 38));
        throwBall.setBackground(lightGreen);
        throwBall.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, Color.BLACK));

        try {
            backgroundImage2 = ImageIO.read(new File("throw.jpg"));
        } catch (IOException e) {
        }
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage2 != null) {
                    g.drawImage(backgroundImage2, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        mainPanel.setLayout(new GridLayout(4, 1));
        mainPanel.add(pokemonTopRowPanel);
        mainPanel.add(pokemonMiddleRow);
        mainPanel.add(pokemonBottomRow);
        mainPanel.add(throwBall);

        JLabel instructions = new JLabel("Click Stop to Choose a Ball!");
        instructions.setFont((new Font("Courier", Font.BOLD, 24)));
        instructions.setHorizontalAlignment(JLabel.CENTER);

        JLabel pokeballName = new JLabel("Poke Ball");
        pokeballName.setFont((new Font("Courier", Font.BOLD, 40)));
        pokeballName.setHorizontalAlignment(JLabel.CENTER);


        JButton stopButton = new JButton("Stop");
        stopButton.setFont((new Font("Courier", Font.BOLD, 18)));
        stopButton.setBackground(lightOrange);


        Timer pokeballTimer = new Timer(75, e -> {
            pokeballSelected = CatchController.catchModelPokemon.getPokeballName();
            pokeballName.setText(pokeballSelected);
        });

        try {
            backgroundImage = ImageIO.read(new File("balls.jpg"));
        } catch (IOException e) {
        }
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(instructions, BorderLayout.NORTH);
        backgroundPanel.add(pokeballName);
        backgroundPanel.add(stopButton, BorderLayout.SOUTH);

        JFrame pokeballRoulette = new JFrame();
        pokeballRoulette.add(backgroundPanel);
        pokeballRoulette.setTitle("Poke Ball Roulette");
        pokeballRoulette.setSize(450, 300);
        pokeballRoulette.setLocationRelativeTo(null);

        stopButton.addActionListener(e -> {
            pokemonName1.setText(BattleController.pokemonBattleModel.getEnemy1().getName() + BattleController.pokemonBattleModel.getEnemy1().printGrade());
            pokemonName2.setText(BattleController.pokemonBattleModel.getEnemy2().getName() + BattleController.pokemonBattleModel.getEnemy2().printGrade());
            pokemonGauge1.setText("Catch Gauge: " + BattleController.pokemonBattleModel.getCatchgauge1() + "%");
            pokemonGauge2.setText("Catch Gauge: " + BattleController.pokemonBattleModel.getCatchgauge2() + "%");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("You Threw a " + pokeballSelected + "!");
            if (repeat == 0) {
                if (CatchController.catchModelPokemon.pokemonCaught(pokeballSelected, BattleController.pokemonBattleModel.getCatchgauge1(), BattleController.pokemonBattleModel.getEnemy1().getGrade())) {
                    System.out.println("Gotcha!");
                    System.out.println(BattleController.pokemonBattleModel.getEnemy1().getName() + " Was Caught!");
                    owned1.setText("Captured!");
                    owned1.setForeground(Color.GREEN);
                    TrainerModel.trainerModel.addToParty(BattleController.pokemonBattleModel.getEnemy1());
                    pokemonCaught++;
                    pokemonGradeCaught += BattleController.pokemonBattleModel.getEnemy1().getGrade();
                }
                else {
                    System.out.println("The Pokemon Broke Free!");
                    System.out.println("The Wild " + BattleController.pokemonBattleModel.getEnemy1().getName() + " Ran Away!");
                    owned1.setText("Ran Away!");
                    owned1.setForeground(Color.RED);
                }
                throwBall.setText("Catch " + BattleController.pokemonBattleModel.getEnemy2().getName() + "!");
                repeat++;
            }
            else {
                boolean caught = CatchController.catchModelPokemon.pokemonCaught(pokeballSelected, BattleController.pokemonBattleModel.getCatchgauge2(), BattleController.pokemonBattleModel.getEnemy2().getGrade());
                if (caught) {
                    System.out.println("Gotcha!");
                    System.out.println(BattleController.pokemonBattleModel.getEnemy2().getName() + " Was Caught!");
                    owned2.setText("Captured!");
                    owned2.setForeground(Color.GREEN);
                    TrainerModel.trainerModel.addToParty(BattleController.pokemonBattleModel.getEnemy2());
                    pokemonCaught++;
                    pokemonGradeCaught += BattleController.pokemonBattleModel.getEnemy2().getGrade();
                }
                else {
                    System.out.println("The Pokemon Broke Free!");
                    System.out.println("The Wild " + BattleController.pokemonBattleModel.getEnemy2().getName() + " Ran Away!");
                    owned2.setText("Ran Away!");
                    owned2.setForeground(Color.RED);
                }
                throwBall.setText("Continue");
                repeat++;
            }
            pokeballRoulette.setVisible(false);
            pokeballRoulette.dispose();
            catchNext = true;
        });

        throwBall.addActionListener (e -> {
            dispose();

            if (repeat < 2) {
                pokeballRoulette.setVisible(true);
                pokeballTimer.start();
            }
            else {
                owned1.setText("");
                owned2.setText("");
                repeat = 0;
                catchNext = true;
            }
        });

        add(mainPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Catch");
        setSize(750, 400);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
