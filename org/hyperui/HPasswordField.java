package org.hyperui;

import javax.swing.*;

public class HPasswordField extends JPasswordField {

    private Options options;

    public HPasswordField(Options options) {
        super();
        this.options = options;
        loadOptions();
    }

    public HPasswordField addID(String ID) {
        HManager.addComponent(ID, this);
        return this;
    }

    public HPasswordField setClasses(String[] classes) {
        for (Options options : HCSS.getClasses(classes))
            loadOptions(options);
        this.revalidate();
        this.repaint();
        return this;
    }

    public HPasswordField setClasses(String classOptionKey) {
        loadOptions(HCSS.getClassOption(classOptionKey));
        this.revalidate();
        this.repaint();
        return this;
    }
    private void loadOptions(Options customOptions) {
        if (customOptions != null) {
            // Load common options from the base class
            if (customOptions.getBackground() != null)
                setBackground(customOptions.getBackground());
            if (customOptions.getForeground() != null)
                setForeground(customOptions.getForeground());
            if (customOptions.getFont() != null)
                setFont(customOptions.getFont());
            setEnabled(customOptions.isEnabled());
            if (customOptions.getBorder() != null)
                setBorder(customOptions.getBorder());
            if (customOptions.getToolTipText() != null)
                setToolTipText(customOptions.getToolTipText());
            if (customOptions.getSize() != null)
                setSize(customOptions.getSize());
            if (customOptions.getLocation() != null)
                setLocation(customOptions.getLocation());
            if (customOptions.getActionListener() != null)
                addActionListener(customOptions.getActionListener());

            // Load JButton specific options
            if (customOptions.getText() != null)
                setText(customOptions.getText());

            // Load listeners
            if (customOptions.getMouseListener() != null)
                addMouseListener(options.getMouseListener());
            if (customOptions.getKeyListener() != null)
                addKeyListener(options.getKeyListener());
            if (customOptions.getFocusListener() != null)
                addFocusListener(customOptions.getFocusListener());
            if (customOptions.getMouseMotionListener() != null)
                addMouseMotionListener(customOptions.getMouseMotionListener());
        }
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
            if (options.getActionListener() != null) addActionListener(options.getActionListener());
            if (options.getText() != null) setText(options.getText());
            if (options.getMouseListener() != null)
                addMouseListener(options.getMouseListener());
            if (options.getKeyListener() != null)
                addKeyListener(options.getKeyListener());
            if (options.getFocusListener() != null)
                addFocusListener(options.getFocusListener());
            if (options.getMouseMotionListener() != null)
                addMouseMotionListener(options.getMouseMotionListener());
        }
    }
}

