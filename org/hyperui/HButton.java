package org.hyperui;

import javax.swing.JButton;

public class HButton extends JButton {

    private Options options;

    public HButton(Options options) {
        super();
        this.options = options;
        loadOptions();
    }

    public HButton addID(String ID) {
        HManager.addComponent(ID, this);
        return this;
    }
    private void loadOptions() {
        if (options != null) {
            // Load common options from the base class
            if (options.getBackground() != null)
                setBackground(options.getBackground());
            if (options.getForeground() != null)
                setForeground(options.getForeground());
            if (options.getFont() != null)
                setFont(options.getFont());
            setEnabled(options.isEnabled());
            if (options.getBorder() != null)
                setBorder(options.getBorder());
            if (options.getToolTipText() != null)
                setToolTipText(options.getToolTipText());
            if (options.getSize() != null)
                setSize(options.getSize());
            if (options.getLocation() != null)
                setLocation(options.getLocation());
            if (options.getActionListener() != null)
                addActionListener(options.getActionListener());

            // Load JButton specific options
            if (options.getText() != null)
                setText(options.getText());

            // Load listeners
            if (options.getMouseListener() != null)
                addMouseListener(options.getMouseListener());
            if (options.getKeyListener() != null)
                addKeyListener(options.getKeyListener());
            if (options.getFocusListener() != null)
                addFocusListener(options.getFocusListener());
            if (options.getItemListener() != null)
                addItemListener(options.getItemListener());
            if (options.getMouseMotionListener() != null)
                addMouseMotionListener(options.getMouseMotionListener());
        }
    }

}
