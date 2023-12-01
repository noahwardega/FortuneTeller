import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JLabel titleLabel;
    private JTextArea fortuneTextArea;
    private JButton readFortuneButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //top
        titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        ImageIcon fortuneTellerIcon = new ImageIcon("fortuneteller.jpg");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 36));
        titleLabel.setIcon(fortuneTellerIcon);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        add(titleLabel, BorderLayout.NORTH);

        //mid
        fortuneTextArea = new JTextArea();
        fortuneTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);
        scrollPane.setPreferredSize(new Dimension(400, 200));
        add(scrollPane, BorderLayout.CENTER);

        //bot
        JPanel bottomPanel = new JPanel();
        readFortuneButton = new JButton("Read My Fortune!");
        quitButton = new JButton("Quit");
        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        //fonts
        readFortuneButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        quitButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        fortuneTextArea.setFont(new Font("Monospaced", Font.PLAIN, 16));

        //fortunes
        fortunes = new ArrayList<>();
        fortunes.add("Come back later… I am sleeping.");
        fortunes.add("Your reality check is about to bounce.");
        fortunes.add("Ignore the previous fortune.");
        fortunes.add("Two days from now, tomorrow will be yesterday.");
        fortunes.add("Error 404: Fortune not found.");
        fortunes.add("I see money in your future… it is not yours though.");
        fortunes.add("Your inferiority complex is not good enough. Try harder.");
        fortunes.add("You are cleverly disguised as a responsible adult.");
        fortunes.add("You will soon have an out-of-money experience. ");
        fortunes.add("To truly find yourself you should play hide and seek alone.");
        fortunes.add("It’s okay to look at the past and future. Just don’t stare.");
        fortunes.add("Be cautious while walking in the darkness alone.");

        // Add action listeners using Java 8 Lambda Expressions
        readFortuneButton.addActionListener((ActionEvent e) -> readFortune());
        quitButton.addActionListener((ActionEvent e) -> System.exit(0));

        // Set the frame size and position
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int screenWidth = toolkit.getScreenSize().width;
        int screenHeight = toolkit.getScreenSize().height;
        setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
        setLocation((screenWidth - getWidth()) / 4, (screenHeight - getHeight()) / 4);
    }

    private void readFortune() {
        Random random = new Random();
        int newFortuneIndex;
        do {
            newFortuneIndex = random.nextInt(fortunes.size());
        } while (newFortuneIndex == lastFortuneIndex);

        String fortune = fortunes.get(newFortuneIndex);
        fortuneTextArea.append(fortune + "\n");
        lastFortuneIndex = newFortuneIndex;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();
            frame.setVisible(true);
        });
    }
}

