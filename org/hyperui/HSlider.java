package org.hyperui;

import javax.swing.*;

public class HSlider extends JSlider { 

    private Options options;

    public HSlider addID(String ID) {
        HManager.addComponent(ID, this);
        return this;
    }
    public HSlider(Options options) {
        super();
        this.options = options;
        loadOptions();
    }

    public HSlider Minimum(int min) {
        setMinimum(min);
        return this;
    }

    public HSlider Maximum(int max) {
        setMaximum(max);
        return this;
    }

    public HSlider Value(int value) {
        setValue(value);
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

