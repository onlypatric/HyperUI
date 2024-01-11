package org.hyperui;

import javax.swing.*;

public class HScrollPane extends JScrollPane {

    public HScrollPane(JComponent view, Options options,boolean vertical,boolean horizontal) {
        super(view);
        setOptions(options);
        if (vertical) {
            setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        } 
        if (horizontal) {
            setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        }
    }

    public HScrollPane setClasses(String[] classes) {
        for (Options options : HCSS.getClasses(classes))
            loadOptions(options);
        this.revalidate();
        this.repaint();
        return this;
    }

    public HScrollPane setClasses(String classOptionKey) {
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
            if (customOptions.getFocusListener() != null)
                addFocusListener(customOptions.getFocusListener());
            if (customOptions.getMouseMotionListener() != null)
                addMouseMotionListener(customOptions.getMouseMotionListener());
        }
    }
    public HScrollPane addID(String ID) {
        HManager.addComponent(ID, this);
        return this;
    }
    public void setOptions(Options options) {
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
