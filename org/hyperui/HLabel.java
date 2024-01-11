package org.hyperui;

import javax.swing.*;

public class HLabel extends JLabel {

    private Options options;

    public HLabel(Options options) {
        super();
        this.options = options;
        loadOptions();
    }

    public HLabel addID(String ID) {
        HManager.addComponent(ID, this);
        return this;
    }
    private void loadOptions() {
        if (options != null) {
            // Load common options from the base class
            if (options.getBackground() != null) setBackground(options.getBackground());
            if (options.getForeground() != null) setForeground(options.getForeground());
            if (options.getFont() != null) setFont(options.getFont());
            setEnabled(options.isEnabled());
            if (options.getBorder() != null) setBorder(options.getBorder());
            if (options.getToolTipText() != null) setToolTipText(options.getToolTipText());
            if (options.getSize() != null) setSize(options.getSize());
            if (options.getLocation() != null) setLocation(options.getLocation());

            // Load JLabel specific options
            if (options.getText() != null) setText(options.getText());
        }
    }
}

