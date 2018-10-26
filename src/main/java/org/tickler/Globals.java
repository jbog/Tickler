package org.tickler;

import java.net.URI;

/**
 * Created by jasper on 26/10/18.
 *
 * LATER Make even more flexible by reading out the values as part of a configuration file
 */
public abstract class Globals {
    private static Globals active;
    public static void set(Globals configuration) {
        active = configuration;
    }
    public static Globals get() {
        return active;
    }
    public static final Globals TEST = new Globals() {
        @Override
        public URI getURI() {
            return null; // TODO
        }
    };
    public static final Globals PRODUCTION = new Globals() {
        @Override
        public URI getURI() {
            return null; // TODO
        }
    };

    static {
        // By default, set the configuration to production.
        set(PRODUCTION);
    }

    // Common methods
    public String getPingPage() {
        return "/ping";
    }
    public Integer getPingResponseCode() {
        return 200;
    }
    public String getAddTicklePage() {
        return "/tickle";
    }
    public Integer getAddTickleResponseCode() {
        return 201;
    }
    public String getGetTicklePage() {
        return "/tickle";
    }
    public Integer getGetTickleResponseCode() {
        return 200;
    }
    public String getRemoveTicklePage() {
        return "/tickle";
    }
    public Integer getRemoveTickleResponseCode() {
        return 200;
    }

    // Specific methods
    public abstract URI getURI();

}
