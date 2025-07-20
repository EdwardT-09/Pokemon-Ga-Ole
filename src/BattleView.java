import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class BattleView extends JFrame {
    private Image backgroundImage;
    private Timer enemyGauge;
    public boolean moveOccurred;
    public int attackerOrDefender;
    private String stageOption;

    public BattleView() {
    }

    public void display(String StageOption) {
        stageOption = StageOption;
        BattleController.pokemonBattleModel.setSpirit(50);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        //Colours
        Color lightRed = new Color(255, 102, 102);
        Color lightBlue = new Color(31, 190, 214);
        Color lightOrange = new Color(255, 165, 0);
        Color lightGreen = new Color(102, 255, 102);

        JLabel emptyPanel1 = new JLabel();
        JLabel emptyPanel2 = new JLabel();

        JLabel enemyName1 = new JLabel("Wild: " + BattleController.pokemonBattleModel.getEnemy1().getName() + BattleController.pokemonBattleModel.getEnemy1().printGrade());
        enemyName1.setHorizontalAlignment(JLabel.CENTER);
        enemyName1.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel enemyDefType1 = new JLabel("DefType: " + BattleController.pokemonBattleModel.getEnemy1().getDefType1() + " | " + BattleController.pokemonBattleModel.getEnemy1().getDefType2());
        enemyDefType1.setHorizontalAlignment(JLabel.CENTER);
        enemyDefType1.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel enemyAtkType1 = new JLabel("AtkType: " + BattleController.pokemonBattleModel.getEnemy1().getAtkType());
        enemyAtkType1.setHorizontalAlignment(JLabel.CENTER);
        enemyAtkType1.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel enenemyCatchgauge1 = new JLabel("Catch gauge: " + decimalFormat.format(BattleController.pokemonBattleModel.getCatchgauge1()) + "%");
        enenemyCatchgauge1.setHorizontalAlignment(JLabel.CENTER);
        enenemyCatchgauge1.setFont(new Font("Courier", Font.BOLD, 14));

        JPanel enemyPanel1 = new JPanel();
        enemyPanel1.setLayout(new GridLayout(4, 1));
        enemyPanel1.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, Color.BLACK));
        enemyPanel1.setBackground(lightRed);
        enemyPanel1.add(enemyName1);
        enemyPanel1.add(enemyDefType1);
        enemyPanel1.add(enemyAtkType1);
        enemyPanel1.add(enenemyCatchgauge1);

        JLabel enemyName2 = new JLabel("Wild: " + BattleController.pokemonBattleModel.getEnemy2().getName() + BattleController.pokemonBattleModel.getEnemy2().printGrade());
        enemyName2.setText("Wild: " + BattleController.pokemonBattleModel.getEnemy2().getName() + BattleController.pokemonBattleModel.getEnemy2().printGrade());
        enemyName2.setHorizontalAlignment(JLabel.CENTER);
        enemyName2.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel enemyDefType2 = new JLabel("DefType: " + BattleController.pokemonBattleModel.getEnemy2().getDefType1() + " | " + BattleController.pokemonBattleModel.getEnemy2().getDefType2());
        enemyDefType2.setHorizontalAlignment(JLabel.CENTER);
        enemyDefType2.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel enemyAtkType2 = new JLabel("AtkType: " + BattleController.pokemonBattleModel.getEnemy2().getAtkType());
        enemyAtkType2.setHorizontalAlignment(JLabel.CENTER);
        enemyAtkType2.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel enenemyCatchgauge2 = new JLabel("Catch Gauge: " + decimalFormat.format(BattleController.pokemonBattleModel.getCatchgauge1()) + "%");
        enenemyCatchgauge2.setHorizontalAlignment(JLabel.CENTER);
        enenemyCatchgauge2.setFont(new Font("Courier", Font.BOLD, 14));

        JPanel enemyPanel2 = new JPanel();
        enemyPanel2.setLayout(new GridLayout(4, 1));
        enemyPanel2.setBorder(BorderFactory.createMatteBorder(0, 4, 4, 0, Color.BLACK));
        enemyPanel2.setBackground(lightRed);
        enemyPanel2.add(enemyName2);
        enemyPanel2.add(enemyDefType2);
        enemyPanel2.add(enemyAtkType2);
        enemyPanel2.add(enenemyCatchgauge2);

        JLabel allyName1 = new JLabel("Ally: " + BattleController.pokemonBattleModel.getAlly1().getName() + BattleController.pokemonBattleModel.getAlly1().printGrade());
        allyName1.setHorizontalAlignment(JLabel.CENTER);
        allyName1.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel allyDefType1 = new JLabel("DefType: " + BattleController.pokemonBattleModel.getAlly1().getDefType1() + " | " + BattleController.pokemonBattleModel.getAlly1().getDefType2());
        allyDefType1.setHorizontalAlignment(JLabel.CENTER);
        allyDefType1.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel allyAtkType1 = new JLabel("AtkType: " + BattleController.pokemonBattleModel.getAlly1().getAtkType());
        allyAtkType1.setHorizontalAlignment(JLabel.CENTER);
        allyAtkType1.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel allyHp1 = new JLabel("HP: " + BattleController.pokemonBattleModel.getAllyHp1() + "/" + BattleController.pokemonBattleModel.getAlly1().getHp());
        allyHp1.setHorizontalAlignment(JLabel.CENTER);
        allyHp1.setFont(new Font("Courier", Font.BOLD, 14));

        JPanel allyPanel1 = new JPanel();
        allyPanel1.setLayout(new GridLayout(4, 1));
        allyPanel1.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 4, Color.BLACK));
        allyPanel1.setBackground(lightGreen);
        allyPanel1.add(allyName1);
        allyPanel1.add(allyDefType1);
        allyPanel1.add(allyAtkType1);
        allyPanel1.add(allyHp1);

        JLabel allyName2 = new JLabel("Ally: " + BattleController.pokemonBattleModel.getAlly2().getName() + BattleController.pokemonBattleModel.getAlly2().printGrade());
        allyName2.setHorizontalAlignment(JLabel.CENTER);
        allyName2.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel allyDefType2 = new JLabel("DefType: " + BattleController.pokemonBattleModel.getAlly2().getDefType1() + " | " + BattleController.pokemonBattleModel.getAlly2().getDefType2());
        allyDefType2.setHorizontalAlignment(JLabel.CENTER);
        allyDefType2.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel allyAtkType2 = new JLabel("AtkType: " + BattleController.pokemonBattleModel.getAlly2().getAtkType());
        allyAtkType2.setHorizontalAlignment(JLabel.CENTER);
        allyAtkType2.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel allyHp2 = new JLabel("HP: " + BattleController.pokemonBattleModel.getAllyHp2() + "/" + BattleController.pokemonBattleModel.getAlly2().getHp());
        allyHp2.setHorizontalAlignment(JLabel.CENTER);
        allyHp2.setFont(new Font("Courier", Font.BOLD, 14));

        JPanel allyPanel2 = new JPanel();
        allyPanel2.setLayout(new GridLayout(4, 1));
        allyPanel2.setBorder(BorderFactory.createMatteBorder(4, 4, 0, 0, Color.BLACK));
        allyPanel2.setBackground(lightGreen);
        allyPanel2.add(allyName2);
        allyPanel2.add(allyDefType2);
        allyPanel2.add(allyAtkType2);
        allyPanel2.add(allyHp2);

        JLabel enemyAtkgauge1 = new JLabel("Wild " + BattleController.pokemonBattleModel.getEnemy1().getName() + "'s Attack Gauge: " + BattleController.pokemonBattleModel.getAtkgaugeEnemy1() + "%");
        enemyAtkgauge1.setForeground(Color.BLACK);
        enemyAtkgauge1.setHorizontalAlignment(JLabel.CENTER);
        enemyAtkgauge1.setForeground(Color.BLACK);
        enemyAtkgauge1.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.BLACK));
        enemyAtkgauge1.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel enemyAtkgauge2 = new JLabel("Wild " + BattleController.pokemonBattleModel.getEnemy2().getName() + "'s Attack Gauge: " + BattleController.pokemonBattleModel.getAtkgaugeEnemy2() + "%");
        enemyAtkgauge2.setForeground(Color.BLACK);
        enemyAtkgauge2.setHorizontalAlignment(JLabel.CENTER);
        enemyAtkgauge2.setForeground(Color.BLACK);
        enemyAtkgauge2.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.BLACK));
        enemyAtkgauge2.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel allyAtkgauge1 = new JLabel("Ally " + BattleController.pokemonBattleModel.getAlly1().getName() + "'s Attack Gauge[A]: " + BattleController.pokemonBattleModel.getAtkgaugeAlly1() + "%");
        allyAtkgauge1.setForeground(Color.BLACK);
        allyAtkgauge1.setHorizontalAlignment(JLabel.CENTER);
        allyAtkgauge1.setForeground(Color.BLACK);
        allyAtkgauge1.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel allyAtkgauge2 = new JLabel("Ally " + BattleController.pokemonBattleModel.getAlly2().getName() + "'s Attack Gauge[L]: " + BattleController.pokemonBattleModel.getAtkgaugeAlly2() + "%");
        allyAtkgauge2.setForeground(Color.BLACK);
        allyAtkgauge2.setHorizontalAlignment(JLabel.CENTER);
        allyAtkgauge2.setForeground(Color.BLACK);
        allyAtkgauge2.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel instruction1 = new JLabel("Fill Attack Gauge to 100 to Attack!");
        instruction1.setForeground(Color.BLACK);
        instruction1.setHorizontalAlignment(JLabel.CENTER);
        instruction1.setVerticalAlignment(JLabel.BOTTOM);
        instruction1.setForeground(Color.BLACK);
        instruction1.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.BLACK));
        instruction1.setFont(new Font("Courier", Font.BOLD, 14));

        JLabel instruction2 = new JLabel("Press A and L to Fill Attack Gauge!");
        instruction2.setForeground(Color.BLACK);
        instruction2.setHorizontalAlignment(JLabel.CENTER);
        instruction2.setVerticalAlignment(JLabel.TOP);
        instruction2.setForeground(Color.BLACK);
        instruction2.setFont(new Font("Courier", Font.BOLD, 14));


        enemyAtkgauge1.setText("Wild " + BattleController.pokemonBattleModel.getEnemy1().getName() + "'s Attack Gauge: " + BattleController.pokemonBattleModel.getAtkgaugeEnemy1() + "%");
        enemyAtkgauge2.setText("Wild " + BattleController.pokemonBattleModel.getEnemy2().getName() + "'s Attack Gauge: " + BattleController.pokemonBattleModel.getAtkgaugeEnemy2() + "%");


        allyAtkgauge1.setText("Ally " + BattleController.pokemonBattleModel.getAlly1().getName() + "'s Attack Gauge[A]: " + BattleController.pokemonBattleModel.getAtkgaugeAlly1() + "%");
        allyAtkgauge2.setText("Ally " + BattleController.pokemonBattleModel.getAlly2().getName() + "'s Attack Gauge[L]: " + BattleController.pokemonBattleModel.getAtkgaugeAlly2() + "%");

        if (BattleController.pokemonBattleModel.getRound1()) {
            System.out.println("-------------------------------------------------------------------\nStage: " + StageController.stageModel.getStageOption());
            System.out.println("\nA Wild " + BattleController.pokemonBattleModel.getEnemy1().getName() + BattleController.pokemonBattleModel.getEnemy1().printGrade() + " Appeared!");
            System.out.println("A Wild " + BattleController.pokemonBattleModel.getEnemy2().getName() + BattleController.pokemonBattleModel.getEnemy2().printGrade() + " Appeared!\n");
            System.out.println("Trainer: \nSent Out " + BattleController.pokemonBattleModel.getAlly1().getName() + BattleController.pokemonBattleModel.getAlly1().printGrade() + "!");
            System.out.println("Sent Out " + BattleController.pokemonBattleModel.getAlly2().getName() + BattleController.pokemonBattleModel.getAlly2().printGrade() + "!");
        }
        else {
            moveOccurred = false;
            if (BattleController.pokemonBattleModel.getAllyHp1() < 1) {
                allyHp1.setText("Fainted!");
                BattleController.pokemonBattleModel.setAllyHp1(0);
            } else {
                allyHp1.setText("HP: " + BattleController.pokemonBattleModel.getAllyHp1() + "/" + BattleController.pokemonBattleModel.getAlly1().getHp());
            }
            if (BattleController.pokemonBattleModel.getAllyHp2() < 1) {
                allyHp2.setText("Fainted!");
                BattleController.pokemonBattleModel.setAllyHp2(0);
            } else {
                allyHp2.setText("HP: " + BattleController.pokemonBattleModel.getAllyHp2() + "/" + BattleController.pokemonBattleModel.getAlly2().getHp());
            }
            if (BattleController.pokemonBattleModel.getCatchgauge1() >= 100) {
                BattleController.pokemonBattleModel.setCatchgauge1(100);
            }
            if (BattleController.pokemonBattleModel.getCatchgauge2() >= 100) {
                BattleController.pokemonBattleModel.setCatchgauge2(100);
            }
            switch (attackerOrDefender) {
                case 1:
                    System.out.println("The Wild " + BattleController.pokemonBattleModel.getEnemy1().getName() + " Dealt " + BattleController.pokemonBattleModel.getDamage() + " Damage to " + BattleController.pokemonBattleModel.getPokemonAttacked().getName());
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Ally " + BattleController.pokemonBattleModel.getAlly1().getName() + "'s HP: " + BattleController.pokemonBattleModel.getAllyHp1() + "/" + BattleController.pokemonBattleModel.getAlly1().getHp());
                    System.out.println("Ally " + BattleController.pokemonBattleModel.getAlly2().getName() + "'s HP: " + BattleController.pokemonBattleModel.getAllyHp2() + "/" + BattleController.pokemonBattleModel.getAlly2().getHp());
                    break;
                case 2:
                    System.out.println("The Wild " + BattleController.pokemonBattleModel.getEnemy2().getName() + " Dealt " + BattleController.pokemonBattleModel.getDamage() + " Damage to " + BattleController.pokemonBattleModel.getPokemonAttacked().getName());
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Ally " + BattleController.pokemonBattleModel.getAlly1().getName() + "'s HP: " + BattleController.pokemonBattleModel.getAllyHp1() + "/" + BattleController.pokemonBattleModel.getAlly1().getHp());
                    System.out.println("Ally " + BattleController.pokemonBattleModel.getAlly2().getName() + "'s HP: " + BattleController.pokemonBattleModel.getAllyHp2() + "/" + BattleController.pokemonBattleModel.getAlly2().getHp());
                    break;
                default:
                    System.out.println("The Wild " + BattleController.pokemonBattleModel.getPokemonAttacked().getName() + "'s Catch Gauge Increased by " + decimalFormat.format(((double) BattleController.pokemonBattleModel.getDamage() / (double) BattleController.pokemonBattleModel.getPokemonAttacked().getHp()) * 100) + "%");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Wild " + BattleController.pokemonBattleModel.getEnemy1().getName() + "'s Catch Gauge: " + decimalFormat.format(BattleController.pokemonBattleModel.getCatchgauge1()) + "%");
                    System.out.println("Wild " + BattleController.pokemonBattleModel.getEnemy2().getName() + "'s Catch Gauge: " + decimalFormat.format(BattleController.pokemonBattleModel.getCatchgauge2()) + "%");
            }
            enenemyCatchgauge1.setText("Catch Gauge: " + decimalFormat.format(BattleController.pokemonBattleModel.getCatchgauge1()) + "%");
            enenemyCatchgauge2.setText("Catch Gauge: " + decimalFormat.format(BattleController.pokemonBattleModel.getCatchgauge2()) + "%");
            attackerOrDefender = 0;
        }

        enemyGauge = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (BattleController.pokemonBattleModel.getAtkgaugeEnemy1() < 100 && BattleController.pokemonBattleModel.getAtkgaugeEnemy2() < 100) {
                    BattleController.pokemonBattleModel.increaseAtkgaugeEnemy();
                    enemyAtkgauge1.setText("Wild " + BattleController.pokemonBattleModel.getEnemy1().getName() + "'s Attack Gauge: " + BattleController.pokemonBattleModel.getAtkgaugeEnemy1() + "%");
                    enemyAtkgauge2.setText("Wild " + BattleController.pokemonBattleModel.getEnemy2().getName() + "'s Attack Gauge: " + BattleController.pokemonBattleModel.getAtkgaugeEnemy2() + "%");
                } else {
                    if (BattleController.pokemonBattleModel.getAtkgaugeEnemy1() > 99) {
                        enemyGauge.stop();
                        UIManager.put("OptionPane.background", lightRed);
                        UIManager.put("Panel.background", lightRed);
                        UIManager.put("OptionPane.messageFont", new Font("Courier", Font.BOLD, 15));
                        JOptionPane.showMessageDialog(null, "The Wild " + BattleController.pokemonBattleModel.getEnemy1().getName() + " is Preparing to Attack!", "Wild Pokemon's Turn!",
                                JOptionPane.PLAIN_MESSAGE);
                        moveOccurred = true;
                        attackerOrDefender = 1;
                        BattleController.pokemonBattleModel.setAtkgaugeEnemy1(0);
                    } else {
                        enemyGauge.stop();
                        UIManager.put("OptionPane.background", lightRed);
                        UIManager.put("Panel.background", lightRed);
                        UIManager.put("OptionPane.messageFont", new Font("Courier", Font.BOLD, 15));
                        JOptionPane.showMessageDialog(null, "The Wild " + BattleController.pokemonBattleModel.getEnemy2().getName() + " is Preparing to Attack!", "Wild Pokemon's Turn!",
                                JOptionPane.PLAIN_MESSAGE);
                        moveOccurred = true;
                        attackerOrDefender = 2;
                        BattleController.pokemonBattleModel.setAtkgaugeEnemy2(0);
                    }
                }
            }
        });

        Action increaseAllyGauge1 = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                BattleController.pokemonBattleModel.increaseAtkgaugeAlly1();
                allyAtkgauge1.setText("Ally " + BattleController.pokemonBattleModel.getAlly1().getName() + "'s Attack Gauge[A]: " + BattleController.pokemonBattleModel.getAtkgaugeAlly1() + "%");
                if (BattleController.pokemonBattleModel.getAtkgaugeAlly1() > 99) {
                    enemyGauge.stop();
                    UIManager.put("OptionPane.background", lightGreen);
                    UIManager.put("Panel.background", lightGreen);
                    UIManager.put("OptionPane.messageFont", new Font("Courier", Font.BOLD, 15));
                    JOptionPane.showMessageDialog(null, BattleController.pokemonBattleModel.getAlly1().getName() + "'s Attack Gauge is Fully Charged!", "Your Turn!",
                            JOptionPane.PLAIN_MESSAGE);
                    moveOccurred = true;
                    attackerOrDefender = 3;
                    BattleController.pokemonBattleModel.setAtkgaugeAlly1(0);
                }
            }
        };

        Action increaseAllyGauge2 = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                BattleController.pokemonBattleModel.increaseAtkgaugeAlly2();
                allyAtkgauge2.setText("Ally " + BattleController.pokemonBattleModel.getAlly2().getName() + "'s Attack Gauge[L]: " + BattleController.pokemonBattleModel.getAtkgaugeAlly2() + "%");
                if (BattleController.pokemonBattleModel.getAtkgaugeAlly2() > 99) {
                    enemyGauge.stop();
                    UIManager.put("OptionPane.background", lightGreen);
                    UIManager.put("Panel.background", lightGreen);
                    UIManager.put("OptionPane.messageFont", new Font("Courier", Font.BOLD, 15));
                    JOptionPane.showMessageDialog(null, BattleController.pokemonBattleModel.getAlly2().getName() + "'s Attack Gauge is Fully Charged!", "Your Turn!",
                            JOptionPane.PLAIN_MESSAGE);
                    moveOccurred = true;
                    attackerOrDefender = 4;
                    BattleController.pokemonBattleModel.setAtkgaugeAlly2(0);
                }
            }
        };

        allyAtkgauge1.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "allyAtkGauge1");
        allyAtkgauge1.getActionMap().put("allyAtkGauge1", increaseAllyGauge1);
        allyAtkgauge2.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0, true), "allyAtkGauge2");
        allyAtkgauge2.getActionMap().put("allyAtkGauge2", increaseAllyGauge2);

        try {
            backgroundImage = ImageIO.read(new File(stageOption + ".jpg"));
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
        backgroundPanel.setLayout(new GridLayout(4, 3));

        backgroundPanel.add(enemyPanel1);
        backgroundPanel.add(emptyPanel1);
        backgroundPanel.add(enemyPanel2);
        backgroundPanel.add(enemyAtkgauge1);
        backgroundPanel.add(instruction1);
        backgroundPanel.add(enemyAtkgauge2);
        backgroundPanel.add(allyAtkgauge1);
        backgroundPanel.add(instruction2);
        backgroundPanel.add(allyAtkgauge2);
        backgroundPanel.add(allyPanel1);
        backgroundPanel.add(emptyPanel2);
        backgroundPanel.add(allyPanel2);

        add(backgroundPanel);
        setTitle(stageOption);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
        setSize(900, 550);
        setLocationRelativeTo(null);
        setVisible(true);

        if (BattleController.pokemonBattleModel.getAllyHp1() < 1 && BattleController.pokemonBattleModel.getAllyHp2() < 1) {
            System.out.println("-------------------------------------------------------------------\nBoth of Your Pokemon Have Fainted!");
            System.out.println("The Wild Pokemon Are Still Able to Fight!");
            System.out.println("You Can Attempt to Catch Them but it Will be Much Harder!");
            UIManager.put("OptionPane.background", Color.LIGHT_GRAY);
            UIManager.put("Panel.background", Color.LIGHT_GRAY);
            UIManager.put("OptionPane.messageFont", new Font("Courier", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, "Both Your Pokemon Have Fainted!", "Unable to Continue Battle!",
                    JOptionPane.PLAIN_MESSAGE);
        }
        if (BattleController.pokemonBattleModel.getCatchgauge1() >= 100 && BattleController.pokemonBattleModel.getCatchgauge2() >= 100) {
            System.out.println("-------------------------------------------------------------------\nThe Wild Pokemon are Weak!");
            System.out.println("They Should be Easier to Catch!");
            System.out.println("Now Throw a Ball to Try and Catch Them!");
            UIManager.put("OptionPane.background", Color.LIGHT_GRAY);
            UIManager.put("Panel.background", Color.LIGHT_GRAY);
            UIManager.put("OptionPane.messageFont", new Font("Courier", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, "Now is the Perfect Time to Catch Them!", "The Wild Pokemon are Weak!",
                    JOptionPane.PLAIN_MESSAGE);
        }
        if (BattleController.pokemonBattleModel.getBattleEnd()) {
            setVisible(false);
            dispose();
        } else {
            UIManager.put("OptionPane.background", Color.LIGHT_GRAY);
            UIManager.put("Panel.background", Color.LIGHT_GRAY);
            UIManager.put("OptionPane.messageFont", new Font("Courier", Font.BOLD, 20));
            JOptionPane.showMessageDialog(null, "Get Ready to Mash A and L!", "New Round!",
                    JOptionPane.PLAIN_MESSAGE);
            enemyGauge.start();
        }
    }
}
