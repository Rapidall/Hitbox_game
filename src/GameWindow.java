import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameWindow extends JFrame {
    static int width = 1200;
    static int height = 800;
    public GameWindow() {
        setTitle("Window Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setLocationRelativeTo(null);
        WindowKeyListener keyLstnr = new WindowKeyListener();
        addKeyListener(keyLstnr);
        setVisible(true);
        width = getSize().width;
        height = getSize().height;
        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        System.out.print("Window size: ");
        System.out.println(getSize());
        gamePanel.start();
    }

    public void closeWindow() {
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to quit?",
                "Quit game",
                JOptionPane.YES_NO_OPTION
        );
        if (choice == JOptionPane.YES_OPTION) {
            dispose();
        } else if (choice == JOptionPane.NO_OPTION) {
            System.out.println("Don't quit.");
        }
    }

}