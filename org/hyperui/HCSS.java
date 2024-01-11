package org.hyperui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HCSS {
    private static final Map<String, Options> componentMap = new HashMap<>();

    public static void addClass(String classString, Options component) {
        componentMap.put(classString, component);
    }
    public static Options[] getClasses(String[] classStrings){
        Options[] options = new Options[classStrings.length];
        for (int i = 0; i < options.length; i++) {
            options[i]=getClassOption(classStrings[i]);
        }
        return options;
    }
    public static Options getClassOption(String classString) {
        return componentMap.get(classString);
    }
    public static boolean removeClassOption(String classString){
        return componentMap.remove(classString)!=null;
    }
}
