package org.hyperui;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.border.Border;

/**
 * The Options class represents a set of customizable options for UI elements.
 * It provides methods for configuring various properties such as background color,
 * foreground color, font, and event listeners.
 */
public class Options {

    private Color background, foreground;
    private boolean borderPainted, contentAreaFilled, focusPainted,opaque;
    private Font font;
    private boolean enabled;
    private Border border;
    private String toolTipText;
    private Dimension size;
    private Point location;
    private ActionListener actionListener;
    private MouseListener mouseListener;
    private KeyListener keyListener;
    private FocusListener focusListener;
    private ItemListener itemListener;
    private MouseMotionListener mouseMotionListener;
    private String text;
    
    public boolean isOpaque() {
        return opaque;
    }

    public Options Opaque(boolean opaque) {
        this.opaque = opaque;
        return this;
    }
    
    public boolean isFocusPainted() {
        return focusPainted;
    }

    public Options FocusPainted(boolean focusPainted) {
        this.focusPainted = focusPainted;
        return this;
    }
    /**
     * @return
     */
    public boolean isBorderPainted() {
        return borderPainted;
    }

    /**
     * @param borderPainted
     * @return
     */
    public Options BorderPainted(boolean borderPainted) {
        this.borderPainted = borderPainted;
        return this;
    }

    /**
     * @return
     */
    public boolean isContentAreaFilled() {
        return contentAreaFilled;
    }

    /**
     * @param contentAreaFilled
     * @return
     */
    public Options ContentAreaFilled(boolean contentAreaFilled) {
        this.contentAreaFilled = contentAreaFilled;
        return this;
    }

    /**
     * Gets the text associated with the options.
     *
     * @return The text value.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text for the options.
     *
     * @param text The text value to set.
     * @return The Options instance for method chaining.
     */
    public Options Text(String text) {
        this.text = text;
        return this;
    }

    /**
     * Gets the mouse listener associated with the options.
     *
     * @return The mouse listener.
     */
    public MouseListener getMouseListener() {
        return mouseListener;
    }

    /**
     * Sets the mouse listener for the options.
     *
     * @param mouseListener The mouse listener to set.
     * @return The Options instance for method chaining.
     */
    public Options MouseListener(MouseListener mouseListener) {
        this.mouseListener = mouseListener;
        return this;
    }

    /**
     * Gets the key listener associated with the options.
     *
     * @return The key listener.
     */
    public KeyListener getKeyListener() {
        return keyListener;
    }

    /**
     * Sets the key listener for the options.
     *
     * @param keyListener The key listener to set.
     * @return The Options instance for method chaining.
     */
    public Options KeyListener(KeyListener keyListener) {
        this.keyListener = keyListener;
        return this;
    }

    /**
     * Gets the focus listener associated with the options.
     *
     * @return The focus listener.
     */
    public FocusListener getFocusListener() {
        return focusListener;
    }

    /**
     * Sets the focus listener for the options.
     *
     * @param focusListener The focus listener to set.
     * @return The Options instance for method chaining.
     */
    public Options FocusListener(FocusListener focusListener) {
        this.focusListener = focusListener;
        return this;
    }

    /**
     * Gets the item listener associated with the options.
     *
     * @return The item listener.
     */
    public ItemListener getItemListener() {
        return itemListener;
    }

    /**
     * Sets the item listener for the options.
     *
     * @param itemListener The item listener to set.
     * @return The Options instance for method chaining.
     */
    public Options ItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
        return this;
    }

    /**
     * Gets the mouse motion listener associated with the options.
     *
     * @return The mouse motion listener.
     */
    public MouseMotionListener getMouseMotionListener() {
        return mouseMotionListener;
    }

    /**
     * Sets the mouse motion listener for the options.
     *
     * @param mouseMotionListener The mouse motion listener to set.
     * @return The Options instance for method chaining.
     */
    public Options MouseMotionListener(MouseMotionListener mouseMotionListener) {
        this.mouseMotionListener = mouseMotionListener;
        return this;
    }

    /**
     * Gets the background color associated with the options.
     *
     * @return The background color.
     */
    public Color getBackground() {
        return background;
    }

    /**
     * Gets the foreground color associated with the options.
     *
     * @return The foreground color.
     */
    public Color getForeground() {
        return foreground;
    }

    /**
     * Gets the font associated with the options.
     *
     * @return The font.
     */
    public Font getFont() {
        return font;
    }

    /**
     * Checks if the options are enabled.
     *
     * @return True if enabled, false otherwise.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Gets the border associated with the options.
     *
     * @return The border.
     */
    public Border getBorder() {
        return border;
    }

    /**
     * Gets the tool tip text associated with the options.
     *
     * @return The tool tip text.
     */
    public String getToolTipText() {
        return toolTipText;
    }

    /**
     * Gets the size associated with the options.
     *
     * @return The size.
     */
    public Dimension getSize() {
        return size;
    }

    /**
     * Gets the location associated with the options.
     *
     * @return The location.
     */
    public Point getLocation() {
        return location;
    }

    /**
     * Gets the action listener associated with the options.
     *
     * @return The action listener.
     */
    public ActionListener getActionListener() {
        return actionListener;
    }

    /**
     * Default constructor for Options.
     * Initializes the options with default values, and sets them as enabled.
     */
    public Options() {
        enabled = true;
        borderPainted = true;
        contentAreaFilled = true;
        focusPainted = true;
    }

    /**
     * Static method to create an instance of Options.
     *
     * @return A new instance of Options.
     */
    public static Options create() {
        return new Options();
    }

    /**
     * Sets the background color for the options.
     *
     * @param background The background color to set.
     * @return The Options instance for method chaining.
     */
    public Options Background(Color background) {
        this.background = background;
        return this;
    }
    public Options FlatButton(){
        return ContentAreaFilled(false).FocusPainted(false).BorderPainted(false).Opaque(false);
    }
    /**
     * Sets the foreground color for the options.
     *
     * @param foreground The foreground color to set.
     * @return The Options instance for method chaining.
     */
    public Options Foreground(Color foreground) {
        this.foreground = foreground;
        return this;
    }

    /**
     * Sets the font for the options.
     *
     * @param font The font to set.
     * @return The Options instance for method chaining.
     */
    public Options Font(Font font) {
        this.font = font;
        return this;
    }

    /**
     * Sets the enabled status for the options.
     *
     * @param enabled The enabled status to set.
     * @return The Options instance for method chaining.
     */
    public Options Enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Sets the border for the options.
     *
     * @param border The border to set.
     * @return The Options instance for method chaining.
     */
    public Options Border(Border border) {
        this.border = border;
        return this;
    }

    /**
     * Sets the tool tip text for the options.
     *
     * @param toolTipText The tool tip text to set.
     * @return The Options instance for method chaining.
     */
    public Options ToolTipText(String toolTipText) {
        this.toolTipText = toolTipText;
        return this;
    }

    /**
     * Sets the size for the options.
     *
     * @param size The size to set.
     * @return The Options instance for method chaining.
     */
    public Options Size(Dimension size) {
        this.size = size;
        return this;
    }

    /**
     * Sets the location for the options.
     *
     * @param location The location to set.
     * @return The Options instance for method chaining.
     */
    public Options Location(Point location) {
        this.location = location;
        return this;
    }

    /**
     * Sets the action listener for the options.
     *
     * @param actionListener The action listener to set.
     * @return The Options instance for method chaining.
     */
    public Options ActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
        return this;
    }
}





