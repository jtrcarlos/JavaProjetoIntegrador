package org.proj.utils;

import java.time.format.DateTimeFormatter;

public class Constants {
    public static final String DATE_FORMAT = "M/d/y H:m";
    public static final int MAX_LIST_LENGTH = 720;
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);

}
