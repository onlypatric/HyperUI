# HyperUI

A blazingly fast and easy to learn superset of `javax.swing`, uses HTML-like syntax and CSS-like styling to make it very easy for the developer to build applications.

## Options

The `Options` class represents a set of customizable options for UI elements.
It provides methods for configuring various properties such as background color,
foreground color, font, and event listeners.

**Methods:**

* `Background(Color background)`: Sets the background color for the options.
* `Foreground(Color foreground)`: Sets the foreground color for the options.
* `Font(Font font)`: Sets the font for the options.
* `Enabled(boolean enabled)`: Sets the enabled status of the options.
* `Border(Border border)`: Sets the border for the options.
* `ToolTipText(String toolTipText)`: Sets the tool tip text for the options.
* `Size(Dimension size)`: Sets the size for the options.
* `Location(Point location)`: Sets the location for the options.
* `ActionListener(ActionListener actionListener)`: Sets the action listener for the options.
* `MouseListener(MouseListener mouseListener)`: Sets the mouse listener for the options.
* `KeyListener(KeyListener keyListener)`: Sets the key listener for the options.
* `FocusListener(FocusListener focusListener)`: Sets the focus listener for the options.
* `MouseMotionListener(MouseMotionListener mouseMotionListener)`: Sets the mouse motion listener for the options.
* `Text(String text)`: Sets the text for the options.

**Examples:**

```java
Options buttonOptions = Options.create()
  .Background(Color.BLACK)
  .Foreground(Color.WHITE)
  .Text("Convalidate")
  .ActionListener(e->{
    System.out.println("Button has been pressed");
  });
```

## ContainerOptions

The `ContainerOptions` class represents a set of customizable options specific to containers.
It extends the `Options` class and adds properties such as title, resizable status, components,
layout options, grid size, and horizontal/vertical gaps.

**Methods:**

* `Title(String title)`: Sets the title for the container.
* `Resizable(boolean resizable)`: Sets the resizable status of the container.
* `Components(ArrayList<HComponent> components)`: Sets the list of components for the container.
* `add(HComponent component)`: Adds a single component to the container.
* `add(HComponent[] components)`: Adds an array of components to the container.
* `LayoutOption(LayoutOption layoutOption)`: Sets the layout option for the container.
* `setHVgaps(int[] hVgaps)`: Sets the horizontal and vertical gaps for the container.
* `setGridSize(int[] gridSize)`: Sets the grid size for the container.

**Examples:**

```java
ContainerOptions frameOptions = ContainerOptions.create()
  .Title("My Frame")
  .Components(new ArrayList<HComponent>(){{
    add(new Button("Button 1"));
    add(new Label("Label 1"));
    add(new TextField("Text Field 1"));
  }})
  .LayoutOption(LayoutOption.GRID_LAYOUT)
  .setGridSize(new int[]{3, 1});
```

## Components

Syntax example for a non-container:

```java
new HLabel(
  Options.create()
    .Foreground(Color.RED)
    .Text("My Hyper UI Label")
)
```

Syntax example for a container:

```java
new HPanel(
  ContainerOptions frameOptions = ContainerOptions.create()
    .Components(new ArrayList<HComponent>(){{
      add(new Button("Button 1"));
      add(new Label("Label 1"));
      add(new TextField("Text Field 1"));
    }})
    .LayoutOption(LayoutOption.GRID_LAYOUT)
    .setGridSize(new int[]{3, 1});
)
```

or you could also build an HFrame

```java
new HFrame(
  ContainerOptions frameOptions = ContainerOptions.create()
    .Title("My Frame")
    .Components(new ArrayList<HComponent>(){{
      add(new Button("Button 1"));
      add(new Label("Label 1"));
      add(new TextField("Text Field 1"));
    }})
    .LayoutOption(LayoutOption.GRID_LAYOUT)
    .GridSize(new int[]{3, 1});
)
```

## Layout options

The `LayoutOption` enum can be passed in a `ContainerOption` object along with some other methods such as `GridSize` or `setHVgaps` to customize further the `Container`, here are the supported layouts:

* `HORIZONTAL`,
* `VERTICAL`,
* `FLOW_LAYOUT`,
* `BORDER_LAYOUT`,
* `GRID_LAYOUT`,
* `GRIDBAG_LAYOUT`,
* `CARD_LAYOUT`,
* `GROUP_LAYOUT`,
* `SPRING_LAYOUT`
* `DEFAULT` reverts to `FLOW_LAYOUT`,

## Listeners and changing components

Each component, apart from HFrame, has a `addID` method, when passing any `String` the component will be added to a `HashMap` accessible through `HManager` class, you can get an element by ID using `HManager.getComponent(String ID)` it will return a `JComponent` that you can cast to any component apart from `JFrame` or `HFrame`.

You can also remove ID's by using `HManager.removeComponent(String ID)`, it will return a `boolean` indicating wether or not it has been removed

## Component List

* `HFrame` main frame of an Application
* `HPanel` panel inside of another panel or frame
* `HTabbedPane` a tabbed pane that supports multiple panel tabs (only `HPanel` can be passed as element to add)
* `HScrollPane` scrollable pane container, can contain only one panel
* `HButton`
* `HCheckBox`
* `HLabel`
* `HComboBox<T>`
* `HComponent` wraps an hyper ui component, allows to have a default ID and pack constraints
* `HPasswordField` textfield with password-ready options
* `HProgressBar`
* `HRadioButton`
* `HTextArea`
* `HTextField`
* `HSlider`

## Real world examples

Simple application with a Label, Button and TextArea

```java
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import org.hyperui.*;
/**
 * MainApp
 */
public class MainApp {

    public static void main(String[] args) {
        Options textareaOptions = Options.create()
            .Border(new TitledBorder("Text input"));
        Options buttonOptions = Options.create()
            .Text("Convalidate")
            .ActionListener(e->{
                HTextArea field = (HTextArea)HManager.getComponent("textarea");
                System.out.println(field.getText());
            });


        HFrame frame = new HFrame(
            ContainerOptions.create(
                new HComponent[]{
                    new HComponent(
                        new HTextArea(textareaOptions).addID("textarea"),BorderLayout.CENTER
                    ),
                    new HComponent(
                        new HButton(buttonOptions),BorderLayout.SOUTH
                    ),
                    new HComponent(
                        new JLabel("Im a swing label"),BorderLayout.NORTH
                    )
                }
            ).LayoutOption(LayoutOption.BORDER_LAYOUT)
        );
        frame.setVisible(true);
    }
}
```

## Author

Pintescul Patric

email: [patric.personal99@gmail.com](mailto:patric.personal99@gmail.com)