import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ButtonPanel extends JPanel {

    Display display;
    ShroomNet shroomNet;
    JButton updateTableDataButton;

    public ButtonPanel(Display display, ShroomNet shroomNet) {
        this.display = display;
        this.shroomNet = shroomNet;
        createUpdateButton();
        add(updateTableDataButton);
    }

    public void createUpdateButton() {
        updateTableDataButton = new JButton("Update");
        updateTableDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    shroomNet.checkFullTable();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }



}
