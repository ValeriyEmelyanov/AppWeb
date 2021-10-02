package com.example.appweb.util;

import org.reflections.Reflections;

import java.util.Set;

/**
 * Get set of classes form the package which is instance the class.
 */
public class PackageScannerForClasses {

    private PackageScannerForClasses() {
    }

    public static <T> Set<Class<? extends T>> getClasses(String packageName, Class<T> T) {
        Reflections reflections = new Reflections(packageName);
        return reflections.getSubTypesOf(T);
    }

}
