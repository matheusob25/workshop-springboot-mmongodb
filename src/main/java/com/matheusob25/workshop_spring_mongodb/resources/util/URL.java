package com.matheusob25.workshop_spring_mongodb.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {

    public static String decodeParams(String url) {
        return URLDecoder.decode(url, StandardCharsets.UTF_8);
    }
    public static LocalDate convertDate(String date, LocalDate defaultDate) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       try {
           return LocalDate.parse(date, dateFormat);

       }catch (DateTimeParseException e) {
           return defaultDate;
       }
    }


}
