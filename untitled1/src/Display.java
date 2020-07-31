import javax.swing.*;
import java.awt.*;

public class Display {

    public JFrame frame;
    public ShroomNet shroomNet;
    public ScreenPanel screenPanel;
    public ButtonPanel buttonPanel;

    public Display(ShroomNet shroomNet) {
        this.shroomNet = shroomNet;
        configureJFrame();
    }

    public void configureJFrame() {
        frame = new JFrame("ShroomServ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        //configureScreenPanel();
        screenPanel = new ScreenPanel(shroomNet);
        buttonPanel = new ButtonPanel(this, shroomNet);
        frame.add(screenPanel);
        frame.add(buttonPanel);
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.validate();

    }
}
