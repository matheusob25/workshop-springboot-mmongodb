package com.matheusob25.workshop_spring_mongodb.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {

    public static String decodeParams(String url) {
        return URLDecoder.decode(url, StandardCharsets.UTF_8);
    }


}
