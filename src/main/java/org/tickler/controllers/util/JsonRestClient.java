package org.tickler.controllers.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jasper on 26/10/18.
 */
public class JsonRestClient {
    private final static Map<String, String> DEFAULT_PROPERTIES;

    static {
        DEFAULT_PROPERTIES = new HashMap<>(1);
        DEFAULT_PROPERTIES.put("Accept", "application/json");
    }

    public String get(URI uri, Integer expectedResponseCode) throws IOException {
        return this.get(uri, expectedResponseCode, new HashMap<>(0), new HashMap<>(0));
    }

    public String get(URI uri, Integer expectedResponseCode, Map<String, String> urlParameters, Map<String, String> bodyParameters) throws IOException {
        // Declare connection and method
        HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
        connection.setRequestMethod("GET");
        // Set properties
        for (String nextProperty: DEFAULT_PROPERTIES.keySet()) {
            connection.setRequestProperty(nextProperty, DEFAULT_PROPERTIES.get(nextProperty));
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        if (connection.getResponseCode() != expectedResponseCode) {
            throw new ConnectException("Operation failed on endpoint " + uri.toURL().toExternalForm() + ": Response code " + connection.getResponseCode());
        }
        // Retrieve response
        String nextLine;
        String result = "";
        nextLine = reader.readLine();
        while (nextLine != null) {
            result += nextLine;
        }
        return result;
    }
}
