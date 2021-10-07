package com.example.appweb.util;

import com.example.appweb.command.Command;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Build the map of user`s command.
 */
public class CommandMapBuilder {
    private CommandMapBuilder() {
    }

    public static Map<String, Command> getCommandMap() {
        Set<Class<? extends Command>> classes = PackageScannerForClasses.getClasses(
                "com.example.appweb.command.impl", Command.class);

        Map<String, Command> commandMap = new HashMap<>();

        for (Class<? extends Command> type : classes) {
            try {
                Command command = type.getDeclaredConstructor().newInstance();
                commandMap.put(command.getActionPath(), command);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        commandMap.forEach((k, v) -> System.out.println(k + " -> " + v.getClass().getSimpleName()));

        return commandMap;
    }
}
