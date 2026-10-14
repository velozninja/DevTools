package org.DevTools.Env.envReader;

import org.DevTools.Env.exceptions.NotFound;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class envReader {

    public Map<String, String> ReaderEnv(Path path) throws IOException {
        parser parser = new parser();
        Map<String, String> Envs = parser.parse(path);

        return Envs;
    }

    public String readByKey(String key, Map<String, String> Envs) throws IOException {
        String value = Envs.get(key);
        if (value == null) {
            throw new NotFound("Not found: " + key);
        }

        return value;


    }
    public String readByValue(String value, Map<String, String> Envs) throws IOException {
        return Envs.entrySet().stream().filter(e -> e.getValue().equals(value)).findFirst().orElseThrow(() -> new NotFound("Not found " + value)).getKey();


    }
}

