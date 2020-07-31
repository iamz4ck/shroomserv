import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ScreenPanel extends JPanel {

    public ShroomNet shroomNet;

    public ScreenPanel(ShroomNet shroomNet) {
        this.shroomNet = shroomNet;
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.yellow);
        graphics2D.fill(new Rectangle(0, 0, 400, 300));

        graphics2D.setColor(Color.blue);
        for(int i = 0; i < 20; i++) {
            graphics2D.drawString(shroomNet.fullTableValues.get(i) + "", 10, i * 16);
        }
        graphics2D.dispose();
        repaint(10000);
    }

    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }
}
