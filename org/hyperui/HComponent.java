package org.hyperui;

import javax.swing.JComponent;

public class HComponent {
    private JComponent component;
    private String iD;
    private Object constraints;
    public HComponent(JComponent component, String iD, Object constraints) {
        this.component = component;
        this.iD = iD;
        this.constraints = constraints;
        HManager.addComponent(iD, component);
    }
    public HComponent(JComponent component, Object constraints) {
        this.component = component;
        this.iD = null;
        this.constraints = constraints;
    }
    
    public HComponent(){}
    public JComponent getComponent() {
        return component;
    }
    public HComponent Component(JComponent component) {
        this.component = component;
        return this;
    }
    public String getiD() {
        return iD;
    }
    public HComponent iD(String iD) {
        this.iD = iD;
        return this;
    }
    public Object getConstraints() {
        return constraints;
    }
    public HComponent Constraints(Object constraints) {
        this.constraints = constraints;
        return this;
    }
}
