package org.hyperui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.border.Border;

/**
 * The ContainerOptions class represents a set of customizable options specific to containers.
 * It extends the Options class and adds properties such as title, resizable status, components,
 * layout options, grid size, and horizontal/vertical gaps.
 */
public class ContainerOptions extends Options {

    private String title;
    private boolean resizable;
    private ArrayList<HComponent> components;
    private LayoutOption layoutOption;
    private int[] gridSize;
    private int[] HVgaps;

    /**
     * Gets the horizontal and vertical gaps for the container.
     *
     * @return An array containing horizontal and vertical gaps.
     */
    public int[] getHVgaps() {
        return HVgaps;
    }

    /**
     * Sets the horizontal and vertical gaps for the container.
     *
     * @param hVgaps An array containing horizontal and vertical gaps.
     * @return The ContainerOptions instance for method chaining.
     */
    public ContainerOptions setHVgaps(int[] hVgaps) {
        HVgaps = hVgaps;
        return this;
    }

    /**
     * Gets the grid size for the container.
     *
     * @return An array containing grid size.
     */
    public int[] getGridSize() {
        return gridSize;
    }

    /**
     * Sets the grid size for the container.
     *
     * @param gridSize An array containing grid size.
     * @return The ContainerOptions instance for method chaining.
     */
    public ContainerOptions setGridSize(int[] gridSize) {
        this.gridSize = gridSize;
        return this;
    }

    /**
     * Gets the layout option for the container.
     *
     * @return The layout option.
     */
    public LayoutOption getLayoutOption() {
        return layoutOption;
    }

    /**
     * Sets the layout option for the container.
     *
     * @param layoutOption The layout option to set.
     * @return The ContainerOptions instance for method chaining.
     */
    public ContainerOptions LayoutOption(LayoutOption layoutOption) {
        this.layoutOption = layoutOption;
        return this;
    }

    /**
     * Gets the list of components added to the container.
     *
     * @return The list of components.
     */
    public ArrayList<HComponent> getComponents() {
        return components;
    }

    /**
     * Sets the list of components for the container.
     *
     * @param components The list of components to set.
     * @return The ContainerOptions instance for method chaining.
     */
    public ContainerOptions Components(ArrayList<HComponent> components) {
        this.components = components;
        return this;
    }

    /**
     * Adds a single component to the container.
     *
     * @param component The component to add.
     * @return The ContainerOptions instance for method chaining.
     */
    public ContainerOptions add(HComponent component) {
        this.components.add(component);
        return this;
    }

    /**
     * Adds an array of components to the container.
     *
     * @param components An array of components to add.
     * @return The ContainerOptions instance for method chaining.
     */
    public ContainerOptions add(HComponent[] components) {
        for (HComponent component : components)
            this.components.add(component);
        return this;
    }

    /**
     * Gets the title of the container.
     *
     * @return The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Checks if the container is resizable.
     *
     * @return True if resizable, false otherwise.
     */
    public boolean isResizable() {
        return resizable;
    }

    /**
     * Default constructor for ContainerOptions.
     * Initializes the container options with default values and sets it as resizable.
     */
    public ContainerOptions() {
        super();
        this.components = new ArrayList<>();
        this.resizable = true;
    }

    /**
     * Static method to create an instance of ContainerOptions.
     *
     * @return A new instance of ContainerOptions.
     */
    public static ContainerOptions create() {
        return new ContainerOptions();
    }

    /**
     * Static method to create an instance of ContainerOptions with an array of components.
     *
     * @param components An array of components to add.
     * @return A new instance of ContainerOptions with the specified components.
     */
    public static ContainerOptions create(HComponent[] components) {
        ContainerOptions opt = new ContainerOptions();
        for (HComponent component : components)
            opt.add(component);
        return opt;
    }

    /**
     * Overrides the Background method from the parent class and sets the background color for the container.
     *
     * @param background The background color to set.
     * @return The ContainerOptions instance for method chaining.
     */
    @Override
    public ContainerOptions Background(Color background) {
        super.Background(background);
        return this;
    }

    /**
     * Overrides the Foreground method from the parent class and sets the foreground color for the container.
     *
     * @param foreground The foreground color to set.
     * @return The ContainerOptions instance for method chaining.
     */
    @Override
    public ContainerOptions Foreground(Color foreground) {
        super.Foreground(foreground);
        return this;
    }

    /**
     * Overrides the Font method from the parent class and sets the font for the container.
     *
     * @param font The font to set.
     * @return The ContainerOptions instance for method chaining.
     */
    @Override
    public ContainerOptions Font(Font font) {
        super.Font(font);
        return this;
    }

    /**
     * Overrides the Enabled method from the parent class and sets the enabled status for the container.
     *
     * @param enabled The enabled status to set.
     * @return The ContainerOptions instance for method chaining.
     */
    @Override
    public ContainerOptions Enabled(boolean enabled) {
        super.Enabled(enabled);
        return this;
    }

    /**
     * Overrides the Border method from the parent class and sets the border for the container.
     *
     * @param border The border to set.
     * @return The ContainerOptions instance for method chaining.
     */
    @Override
    public ContainerOptions Border(Border border) {
        super.Border(border);
        return this;
    }

    /**
     * Overrides the ToolTipText method from the parent class and sets the tool tip text for the container.
     *
     * @param toolTipText The tool tip text to set.
     * @return The ContainerOptions instance for method chaining.
     */
    @Override
    public ContainerOptions ToolTipText(String toolTipText) {
        super.ToolTipText(toolTipText);
        return this;
    }

    /**
     * Overrides the Size method from the parent class and sets the size for the container.
     *
     * @param size The size to set.
     * @return The ContainerOptions instance for method chaining.
     */
    @Override
    public ContainerOptions Size(Dimension size) {
        super.Size(size);
        return this;
    }

    /**
     * Overrides the Location method from the parent class and sets the location for the container.
     *
     * @param location The location to set.
     * @return The ContainerOptions instance for method chaining.
     */
    @Override
    public ContainerOptions Location(Point location) {
        super.Location(location);
        return this;
    }

    /**
     * Sets the title for the container.
     *
     * @param title The title to set.
     * @return The ContainerOptions instance for method chaining.
     */
    public ContainerOptions Title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the resizable status for the container.
     *
     * @param resizable The resizable status to set.
     * @return The ContainerOptions instance for method chaining.
     */
    public ContainerOptions Resizable(boolean resizable) {
        this.resizable = resizable;
        return this;
    }
}
