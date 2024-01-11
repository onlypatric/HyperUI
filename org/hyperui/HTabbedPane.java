package org.hyperui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HTabbedPane extends JTabbedPane {

    private ContainerOptions options;

    public HTabbedPane(ContainerOptions options) {
        super();
        this.options = options;
        loadOptions();
    }

    public HTabbedPane addID(String ID) {
        HManager.addComponent(ID, this);
        return this;
    }

    public HTabbedPane setClasses(String[] classes) {
        for (Options options : HCSS.getClasses(classes))
            loadOptions(options);
        this.revalidate();
        this.repaint();
        return this;
    }

    private void loadOptions(Options customOptions) {
        if (customOptions != null) {
            if (customOptions instanceof ContainerOptions) {
                ContainerOptions customContainerOptions = (ContainerOptions) customOptions;
                loadTabs(customContainerOptions.getComponents());
                setLayoutBasedOnOption(customContainerOptions.getLayoutOption());
            }
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
            if (options.getMouseListener() != null)
                addMouseListener(options.getMouseListener());
            if (options.getKeyListener() != null)
                addKeyListener(options.getKeyListener());
            if (options.getFocusListener() != null)
                addFocusListener(options.getFocusListener());
            if (options.getMouseMotionListener() != null)
                addMouseMotionListener(options.getMouseMotionListener());
            loadTabs(options.getComponents());
            setLayoutBasedOnOption(options.getLayoutOption());
        }
    }

    private void loadTabs(ArrayList<HComponent> components) {
        if (components != null) {
            for (HComponent component : components) {
                if (component.getiD() != null && component.getComponent() != null) {
                    addTab(component.getiD(), component.getComponent());
                }
            }
        }
    }

    private void setLayoutBasedOnOption(LayoutOption layoutOption) {
        if (layoutOption != null) {
            switch (layoutOption) {
                case HORIZONTAL:
                    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
                    break;
                case VERTICAL:
                    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                    break;
                case FLOW_LAYOUT:
                    setLayout(new FlowLayout());
                    break;
                case BORDER_LAYOUT:
                    setLayout(new BorderLayout());
                    break;
                case GRID_LAYOUT:
                    setLayout(new GridLayout());
                    break;
                default:
                    // Default layout (FlowLayout) in case of unsupported layout option
                    setLayout(new FlowLayout());
                    break;
            }
        }
    }
}
