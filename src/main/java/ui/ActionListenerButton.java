package ui;

import javax.swing.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerButton extends JButton {
    private ActionListener actionListener;

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public void init() {
        this.addActionListener(actionListener);
    }
}
