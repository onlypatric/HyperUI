package org.hyperui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.prefs.Preferences;

public class HFrame extends JFrame {

    private ContainerOptions options;

    public HFrame setClasses(String[] classes) {
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
                loadComponents(customContainerOptions.getComponents());
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
            if (customOptions.getSize() != null)
                setSize(customOptions.getSize());
            if (customOptions.getLocation() != null)
                setLocation(customOptions.getLocation());

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
    public HFrame(ContainerOptions options) {
        super();
        this.options = options;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        loadOptions();
        loadWindowState();
        addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                saveWindowState();
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
            
        });
    }
    public HFrame(HComponent[] components,ContainerOptions options) {
        super();
        this.options = options;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        loadOptions();
        loadWindowState();
        addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                saveWindowState();
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
            
        });
        for(HComponent component : components)
            this.options.add(component);
    }
    

    private void loadOptions() {
        if (options != null) {
            // Load common options from the base class
            if (options.getBackground() != null) setBackground(options.getBackground());
            if (options.getForeground() != null) setForeground(options.getForeground());
            if (options.getFont() != null) setFont(options.getFont());
            setEnabled(options.isEnabled());
            if (options.getSize() != null) setSize(options.getSize());
            if (options.getLocation() != null) setLocation(options.getLocation());
            if (options.getTitle() != null) setTitle(options.getTitle());
            if (options.getMouseListener()!=null) addMouseListener(options.getMouseListener());
            if (options.getKeyListener()!=null) addKeyListener(options.getKeyListener());
            if (options.getFocusListener()!=null) addFocusListener(options.getFocusListener());
            if (options.getMouseMotionListener()!=null) addMouseMotionListener(options.getMouseMotionListener());
            setResizable(options.isResizable());
            // Set layout based on LayoutOption
            setLayoutBasedOnOption(options.getLayoutOption());

            // Load components to the frame
            loadComponents(options.getComponents());
        }
    }

    private void setLayoutBasedOnOption(LayoutOption layoutOption) {
        if (layoutOption != null) {
            switch (layoutOption) {
                case HORIZONTAL:
                    setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
                    break;
                case VERTICAL:
                    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
                    break;
                case FLOW_LAYOUT:
                    setLayout(new FlowLayout());
                    break;
                case BORDER_LAYOUT:
                    setLayout(new BorderLayout());
                    break;
                case GRID_LAYOUT:
                    if(this.options.getGridSize()!=null)
                        setLayout(new GridLayout(this.options.getGridSize()[0], this.options.getGridSize()[1]));
                    else
                        setLayout(new GridLayout());
                    break;
                default:
                    // Default layout (FlowLayout) in case of unsupported layout option
                    setLayout(new FlowLayout());
                    break;
            }
        }
    }

    private void loadComponents(ArrayList<HComponent> components) {
        if (components != null) {
            for (HComponent component : components) {
                if (component.getComponent() != null) {
                    if(component.getConstraints()!=null)
                        add(component.getComponent(),component.getConstraints());
                    else
                        add(component.getComponent());
                }
            }
        }
    }
    private void loadWindowState() {
        Preferences prefs = Preferences.userNodeForPackage(HFrame.class);

        int x = prefs.getInt("windowX", -1);
        int y = prefs.getInt("windowY", -1);
        int width = prefs.getInt("windowWidth", getWidth());
        int height = prefs.getInt("windowHeight", getHeight());

        if (x >= 0 && y >= 0 && width > 0 && height > 0) {
            setBounds(x, y, width, height);
        }
    }

    private void saveWindowState() {
        Preferences prefs = Preferences.userNodeForPackage(HFrame.class);

        Rectangle bounds = getBounds();
        prefs.putInt("windowX", (int) bounds.getX());
        prefs.putInt("windowY", (int) bounds.getY());
        prefs.putInt("windowWidth", (int) bounds.getWidth());
        prefs.putInt("windowHeight", (int) bounds.getHeight());
    }
}