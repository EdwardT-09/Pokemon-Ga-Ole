import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class AttackerView extends JFrame {
    private int value;
    private Image backgroundImage, backgroundImage2;
    public int tempAtkPower;
    private Timer spiritTimer;
    private int counter = 10;
    private String pokeName;

    public AttackerView() {
    }

    public void display(int atkPower, String name) {
        AttackerModel attackerModel = new AttackerModel();
        Color lightBlue = new Color(31, 190, 214);
        pokeName = name;
        tempAtkPower = atkPower;

        try {
            backgroundImage = ImageIO.read(new File("attack.jpg"));
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

        try {
            backgroundImage2 = ImageIO.read(new File("spirit.jpg"));
        } catch (IOException e) {
        }
        JPanel spiritPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage2 != null) {
                    g.drawImage(backgroundImage2, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        JLabel topLabel = new JLabel("Click Stop to Buff Your Pokemon's Attack");
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        topLabel.setVerticalAlignment(JLabel.CENTER);
        topLabel.setFont(new Font("Courier", Font.BOLD, 18));

        JLabel valueLabel = new JLabel();
        valueLabel.setHorizontalAlignment(JLabel.CENTER);
        valueLabel.setVerticalAlignment(JLabel.CENTER);
        valueLabel.setFont(new Font("Courier", Font.BOLD, 40));

        JButton stopButton = new JButton("Stop");
        stopButton.setBackground(lightBlue);
        stopButton.setFont(new Font("Courier", Font.BOLD, 22));
        stopButton.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));

        JLabel spiritGaugeInstruction = new JLabel("Press A and L to Charge Spirit!");
        spiritGaugeInstruction.setHorizontalAlignment(JLabel.CENTER);
        spiritGaugeInstruction.setVerticalAlignment(JLabel.TOP);
        spiritGaugeInstruction.setForeground(Color.WHITE);
        spiritGaugeInstruction.setFont(new Font("Courier", Font.BOLD, 22));

        JLabel spiritGaugeCounter = new JLabel("Spirit: " + BattleController.pokemonBattleModel.getSpirit());
        spiritGaugeCounter.setHorizontalAlignment(JLabel.CENTER);
        spiritGaugeCounter.setVerticalAlignment(JLabel.TOP);
        spiritGaugeCounter.setForeground(Color.WHITE);
        spiritGaugeCounter.setFont(new Font("Courier", Font.BOLD, 44));

        spiritPanel.setLayout(new GridLayout(2, 1));
        spiritPanel.add(spiritGaugeInstruction);
        spiritPanel.add(spiritGaugeCounter);

        JFrame spiritGaugeFrame = new JFrame();
        spiritGaugeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        spiritGaugeFrame.setTitle("Spirit Gauge");
        spiritGaugeFrame.setSize(450, 300);
        spiritGaugeFrame.add(spiritPanel);
        spiritGaugeFrame.setLocationRelativeTo(null);
        spiritGaugeFrame.setVisible(false);

        Action increaseSpiritCounter = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                BattleController.pokemonBattleModel.increaseSpirit();
                spiritGaugeCounter.setText("Spirit: " + BattleController.pokemonBattleModel.getSpirit());
            }
        };

        spiritGaugeCounter.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "increaseSpiritA");
        spiritGaugeCounter.getActionMap().put("increaseSpiritA", increaseSpiritCounter);
        spiritGaugeCounter.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0, true), "increaseSpiritL");
        spiritGaugeCounter.getActionMap().put("increaseSpiritL", increaseSpiritCounter);

        spiritTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter--;
                if (counter <= 0) {
                    spiritGaugeFrame.setVisible(false);
                    spiritGaugeFrame.dispose();
                    spiritTimer.stop();
                    BattleController.pokemonBattleModel.setSpiritCharging(false);
                }
            }
        });

        Timer timer = new Timer(100, e -> {
            value = (int)((double) attackerModel.getRandomSTATBUFF() * 1.5);
            valueLabel.setText("+" + value + " Attack");
        });

        stopButton.addActionListener(e -> {
            System.out.println("\nAttack Roulette: " + value);
            System.out.println("Attack Power Increased by " + value + "!");
            tempAtkPower = tempAtkPower + value;
            System.out.println(pokeName + "'s Attack Rose to " + tempAtkPower +"!\n");
            timer.stop();
            dispose();
            spiritGaugeFrame.setVisible(true);
            counter = 10;
            spiritTimer.start();
        });

        timer.start();

        backgroundPanel.add(topLabel, BorderLayout.NORTH);
        backgroundPanel.add(valueLabel);
        backgroundPanel.add(stopButton, BorderLayout.SOUTH);

        add(backgroundPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setTitle("AttackRoulette");
        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
