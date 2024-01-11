package org.hyperui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HPanel extends JPanel {

    private ContainerOptions options;

    public HPanel(ContainerOptions options) {
        super();
        this.options = options;
        loadOptions();
    }
    public HPanel(HComponent[] components, ContainerOptions options){
        super();
        this.options=options;
        options.add(components);
        loadOptions();
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

            setLayoutBasedOnOption(options.getLayoutOption());

            loadComponents(options.getComponents());
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
                    if (this.options.getGridSize() != null)
                        setLayout(new GridLayout(this.options.getGridSize()[0], this.options.getGridSize()[1]));
                    else
                        setLayout(new GridLayout());
                    break;
                case GRIDBAG_LAYOUT:
                    setLayout(new GridBagLayout());
                    break;
                case CARD_LAYOUT:
                    if (this.options.getGridSize() != null)
                        setLayout(new CardLayout(this.options.getHVgaps()[0], this.options.getHVgaps()[1]));
                    else
                        setLayout(new CardLayout());
                    break;
                case GROUP_LAYOUT:
                    setLayout(new GroupLayout(this));
                    break;
                case SPRING_LAYOUT:
                    setLayout(new SpringLayout());
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
                    if (component.getConstraints() != null)
                        add(component.getComponent(), component.getConstraints());
                    else
                        add(component.getComponent());
                }
            }
        }
    }

    public HPanel addID(String ID) {
        HManager.addComponent(ID, this);
        return this;
    }
    public static void main(String[] args) {
        // Example usage
        HLabel label1 = new HLabel(Options.create().Text("Label 1"));
        HLabel label2 = new HLabel(Options.create().Text("Label 2"));
        HTextField textField = new HTextField(Options.create().Text("Type here"));
        HTextArea textArea = new HTextArea(Options.create().Text("Text Area"));

        ContainerOptions panelOptions = ContainerOptions.create()
                .Title("Panel Example")
                .Resizable(true)
                .LayoutOption(LayoutOption.VERTICAL)  // Set your desired layout option
                .add(new HComponent(label1, "label1", null))
                .add(new HComponent(label2, "label2", null))
                .add(new HComponent(textField, "textField", null))
                .add(new HComponent(textArea, "textArea", null));

        HPanel panel = new HPanel(panelOptions);

        JFrame frame = new JFrame("HPanel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}