import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainGraphics {
    public static GamePanel gamePanel;
    public MainGraphics(GamePanel GP) {
        new CameraView();
        gamePanel = GP;
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        GP.setBorder(border);
        GP.setBounds(0, 0, GameWindow.width, GameWindow.height);
        GP.setPreferredSize(new Dimension(GameWindow.width, GameWindow.height));
        GP.setBackground(Color.DARK_GRAY);
        GP.setFocusable(true);
    }

    public void renderAllEntities(Graphics2D g2d) {
        for (int i = 0; i< GameModel.allEntities.size(); i++) {
            GameModel.allEntities.get(i).drawHitbox(g2d);
            GameModel.allEntities.get(i).render(g2d);
            GameModel.allEntities.get(i).renderVelocity(g2d);
        }
        CameraView.updateCam();
    }
}
