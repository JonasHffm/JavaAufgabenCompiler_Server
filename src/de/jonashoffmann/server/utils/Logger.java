package de.jonashoffmann.server.utils;

public class Logger {

    public static final String PREFIX = "JavaAufgabenCompiler | ";
    public static final String PREFIX_ERR = PREFIX + "*ERR*";
    public static final String PREFIX_WARN = PREFIX + "*WARNING*";

    public static void sendLogMessage(String message) {
        System.out.println(PREFIX + message);
    }
    public static void sendLogErr(String message) {
        System.out.println(PREFIX_ERR + message);
    }
    public static void sendLogWarning(String message) {
        System.out.println(PREFIX_WARN + message);
    }
}
