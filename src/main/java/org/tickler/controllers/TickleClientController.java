package org.tickler.controllers;

import org.tickler.Globals;
import org.tickler.controllers.util.JsonRestClient;
import org.tickler.model.Tickle;

import java.io.IOException;
import java.net.URI;
import java.util.*;

/**
 * Created by jasper on 25/10/18.
 */
public class TickleClientController {
    public Boolean testConnection(URI endpoint) {
        JsonRestClient client = new JsonRestClient();
        endpoint = endpoint.resolve(Globals.get().getPingPage()); // Concatenate ping page to given uri
        try {
            client.get(endpoint, Globals.get().getPingResponseCode());
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public Collection<Tickle> getTickles(URI endpoint, Date from, Date to) throws IOException {
        JsonRestClient client = new JsonRestClient();
        endpoint = endpoint.resolve(Globals.get().getGetTicklePage()); // Concatenate get page to given uri
        String result = client.get(endpoint, Globals.get().getGetTickleResponseCode());
        // TODO Serialize
        return Collections.EMPTY_LIST; // TODO Return tickles
    }
    public void addTickle() throws IOException {
        // TODO Implement
    }
    protected void cacheTickle(Tickle tickle) throws IOException {
        // TODO Implement
    }
    public void synchronizeTickles() throws IOException {
        // TODO Implement
    }

}
