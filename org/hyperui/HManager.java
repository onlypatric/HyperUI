package org.hyperui;

import javax.swing.JComponent;
import java.util.HashMap;
import java.util.Map;

public class HManager {
    private static final Map<String, JComponent> componentMap = new HashMap<>();

    public static void addComponent(String id, JComponent component) {
        componentMap.put(id, component);
    }

    public static JComponent getComponent(String id) {
        return componentMap.get(id);
    }
    public static boolean removeComponent(String id){
        return componentMap.remove(id)!=null;
    }
}
