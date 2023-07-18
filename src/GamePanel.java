import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements ActionListener {
    public static GameModel model;
    public static Field field;
    public static MainGraphics mainGFX;
    public static Hero hero;
    static final int FRAMES_PER_SECOND = 60;
    static Timer timer;
    long startTime;
    public GamePanel() {
        startTime = System.currentTimeMillis();
        model = new GameModel();
        field = new Field();
        mainGFX = new MainGraphics(this);
        Matrix_hitbox MyMatrix = new Matrix_hitbox();
    }

    public void start() {
        timer = new Timer((1000 / FRAMES_PER_SECOND), this);
        timer.start();
    }

    public static void drawMap(Graphics g) {
        field.background.render((Graphics2D) g);
        mainGFX.renderAllEntities((Graphics2D) g);
    }

    public void updateModel() {
        model.updateEntities();
    }

    public void checkControls() {
        if (WindowKeyListener.a) {
            GamePanel.hero.accelerate('W');
        }
        if (WindowKeyListener.d) {
            GamePanel.hero.accelerate('E');
        }
        if (WindowKeyListener.w) {
            GamePanel.hero.accelerate('N');
        }
        if (WindowKeyListener.s) {
            GamePanel.hero.accelerate('S');
        }
        if (WindowKeyListener.space) {
            GamePanel.hero.boost();
            System.out.println("BOOST!!");
            WindowKeyListener.space = false;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawMap(g);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == timer) {
            checkControls();
            updateModel();
            repaint();
        }
    }



}
