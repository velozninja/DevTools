package org.DevTools.Env;

import org.DevTools.Env.exceptions.NotFound;

import java.util.HashMap;
import java.util.Map;

public class varAmbient {
    Map<String, String> ReadAll() {
        Map<String, String> vars = System.getenv();
        if (vars == null) {
            throw new NotFound("Env variables not found");
        }

        return vars;

    }
    String Read(String key) {
        String var  = System.getenv(key);
        if (var == null) {
            throw new NotFound("Not found: " + key);
        }
        return var;
    }
}