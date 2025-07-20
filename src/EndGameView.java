import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class EndGameView extends JFrame {
    public boolean summaryPage = true;
    public boolean continueGame;
    private Image backgroundImage;

    public EndGameView() {
    }

    public void display() {
        summaryPage = true;
        continueGame = false;

        Color lightRed = new Color(255, 102, 102);
        Color lightGreen = new Color(102, 255, 102);

        JLabel battleSummary = new JLabel("BATTLE SUMMARY");
        battleSummary.setFont(new Font("Courier", Font.BOLD, 44));
        battleSummary.setHorizontalAlignment(JLabel.CENTER);
        battleSummary.setForeground(Color.WHITE);

        TrainerModel.trainerModel.determineScorePlacement();

        JLabel highScore = new JLabel("Highest Score: " + TrainerModel.trainerModel.getHighscores().get(5));
        highScore.setFont(new Font("Courier", Font.BOLD, 25));
        highScore.setHorizontalAlignment(JLabel.CENTER);
        highScore.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, Color.BLACK));
        highScore.setForeground(Color.WHITE);

        JLabel battleScore = new JLabel("Battle Score: " + BattleController.pokemonBattleModel.calculateBattleScore());
        battleScore.setFont(new Font("Courier", Font.BOLD, 25));
        battleScore.setHorizontalAlignment(JLabel.CENTER);
        battleScore.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, Color.BLACK));
        battleScore.setForeground(Color.WHITE);

        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(2, 1));
        scorePanel.setOpaque(false);
        scorePanel.add(highScore);
        scorePanel.add(battleScore);

        JLabel pokemonCaptured = new JLabel("Pokemon Caught: x" + CatchController.catchModelPokemon.getPokemonCaught() + " (+" + BattleController.pokemonBattleModel.calculateCaughtScore() + ")");
        pokemonCaptured.setFont(new Font("Courier", Font.BOLD, 22));
        pokemonCaptured.setHorizontalAlignment(JLabel.CENTER);
        pokemonCaptured.setForeground(Color.WHITE);

        JLabel capturedGrades = new JLabel("Total Grade(Caught): x" + CatchController.catchModelPokemon.getPokemonGradeCaught() + "✮ (+" + BattleController.pokemonBattleModel.calculateGradeScore() + ")");
        capturedGrades.setForeground(Color.WHITE);
        capturedGrades.setFont(new Font("Courier", Font.BOLD, 22));
        capturedGrades.setHorizontalAlignment(JLabel.CENTER);

        JLabel fullCatchGauge = new JLabel("Filled Catch Gauge: x0 (+0)");
        if (BattleController.pokemonBattleModel.getCatchgauge1() == 100 && BattleController.pokemonBattleModel.getCatchgauge2() == 100) {
            fullCatchGauge.setText("Filled Catch Gauge: x2 (+" + BattleController.pokemonBattleModel.calculateGaugeScore() + ")");
        }
        else if (BattleController.pokemonBattleModel.getCatchgauge1() == 100 || BattleController.pokemonBattleModel.getCatchgauge2() == 100) {
            fullCatchGauge.setText("Filled Catch Gauge: x1 (+" + BattleController.pokemonBattleModel.calculateGaugeScore() + ")");
        }
        fullCatchGauge.setFont(new Font("Courier", Font.BOLD, 22));
        fullCatchGauge.setHorizontalAlignment(JLabel.CENTER);
        fullCatchGauge.setForeground(Color.WHITE);

        JLabel allyFainted = new JLabel("Ally Fainted: x2 (+0)");
        allyFainted.setFont(new Font("Courier", Font.BOLD, 22));
        allyFainted.setHorizontalAlignment(JLabel.CENTER);
        if (BattleController.pokemonBattleModel.getAllyHp2() > 0 && BattleController.pokemonBattleModel.getAllyHp1() > 0) {
            allyFainted.setText("Ally Fainted: x0 (+" + BattleController.pokemonBattleModel.calculateHpScore() + ")");
        }
        else if (BattleController.pokemonBattleModel.getAllyHp1() > 0 || BattleController.pokemonBattleModel.getAllyHp2() > 0) {
            allyFainted.setText("Ally Fainted: x1 (+" + BattleController.pokemonBattleModel.calculateHpScore() + ")");
        }
        allyFainted.setForeground(Color.WHITE);

        JPanel breakdownPanel = new JPanel();
        breakdownPanel.setLayout(new GridLayout(4, 1));
        breakdownPanel.setOpaque(false);
        breakdownPanel.add(pokemonCaptured);
        breakdownPanel.add(capturedGrades);
        breakdownPanel.add(fullCatchGauge);
        breakdownPanel.add(allyFainted);

        JLabel goldenChips = new JLabel("Current Golden Chips: " + TrainerModel.trainerModel.getGoldenChip() + " (+" + CatchController.catchModelPokemon.getPokemonCaught() + ")");
        goldenChips.setBorder(BorderFactory.createMatteBorder(4, 0, 4, 0, Color.BLACK));
        goldenChips.setFont(new Font("Courier", Font.BOLD, 22));
        goldenChips.setHorizontalAlignment(JLabel.CENTER);
        goldenChips.setForeground(Color.WHITE);

        JLabel continuePrompt = new JLabel("Continue Playing?");
        continuePrompt.setFont(new Font("Courier", Font.BOLD, 22));
        continuePrompt.setHorizontalAlignment(JLabel.CENTER);
        continuePrompt.setForeground(Color.WHITE);

        JButton yesButton = new JButton("Yes");
        yesButton.setFont(new Font("Courier", Font.BOLD, 38));
        yesButton.setName("Yes");
        yesButton.setBackground(lightGreen);
        yesButton.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, Color.BLACK));

        JButton noButton = new JButton("No");
        noButton.setFont(new Font("Courier", Font.BOLD, 38));
        noButton.setName("No");
        noButton.setBackground(lightRed);
        noButton.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 4, Color.BLACK));

        JPanel continueSelect = new JPanel();
        continueSelect.setLayout(new GridLayout(1, 2));
        continueSelect.setOpaque(false);
        continueSelect.add(noButton);
        continueSelect.add(yesButton);

        ActionListener buttonAction = e -> {
            JButton button = (JButton) e.getSource();
            if (Objects.equals(button.getName(), "Yes")) {
                dispose();
                summaryPage = false;
                continueGame = true;
            }
            else {
                dispose();
                summaryPage = false;
            }
        };

        yesButton.addActionListener(buttonAction);
        noButton.addActionListener(buttonAction);

        try {
            backgroundImage = ImageIO.read(new File("summary.jpg"));
        } catch (IOException e) {
        }
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };


        mainPanel.setLayout(new GridLayout(6, 1));
        mainPanel.add(battleSummary);
        mainPanel.add(scorePanel);
        mainPanel.add(breakdownPanel);
        mainPanel.add(goldenChips);
        mainPanel.add(continuePrompt);
        mainPanel.add(continueSelect);

        add(mainPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Battle Summary");
        setSize(600, 780);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 0, 4, Color.BLACK));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
