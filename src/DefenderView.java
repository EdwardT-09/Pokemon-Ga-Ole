import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DefenderView extends JFrame {
    private int value;
    private Image backgroundImage;
    public int tempDefPower;
    private String attackedName;

    public DefenderView() {
    }

    public void display (int defPower, String AttackedName) {
        DefenderModel defenderModel = new DefenderModel();
        Color lightBlue = new Color(31, 190, 214);

        attackedName = AttackedName;
        tempDefPower = defPower;
        try {
            backgroundImage = ImageIO.read(new File("defend.jpg"));
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

        JLabel topLabel = new JLabel("Click Stop to Buff Your Pokemon's Defense!");
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

        Timer timer = new Timer(100, e -> {
            value = defenderModel.getRandomSTATBUFF()/2;
            valueLabel.setText("+" + value + " Defence");
        });

        stopButton.addActionListener(e -> {
            System.out.println("Defence Power Increased by " + value + "!");
            tempDefPower = tempDefPower + value;
            System.out.println(attackedName + "'s Defence Rose to " + tempDefPower +"!\n");
            timer.stop();
            dispose();
        });

        timer.start();

        backgroundPanel.add(topLabel, BorderLayout.NORTH);
        backgroundPanel.add(valueLabel);
        backgroundPanel.add(stopButton, BorderLayout.SOUTH);

        add(backgroundPanel);

        setSize(500, 300);
        setTitle("Defense Roulette");
        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
