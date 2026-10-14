package org.DevTools.Env.envReader;

import org.DevTools.Env.exceptions.InvalidLine;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class parser {
    public Map<String,String> parse(Path path) throws IOException {
        try(BufferedReader reader = Files.newBufferedReader(path)){
            Map<String,String> Vars = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null){
                if(line.startsWith("#")){
                    continue;
                }
                if(line.isEmpty()){
                    continue;
                }
                if(line.isBlank()){
                    continue;
                }
                if(line.startsWith("//")){
                    continue;
                }
                if(line.startsWith("/*")){
                    continue;
                }
                if(line.contains("=")){
                    int separator = line.indexOf("=");
                    String key = line.substring(0,separator).trim();
                    String value = line.substring(separator+1).trim();
                    Vars.put(key,value);

                }
                else{
                    throw new InvalidLine("this line is invalid:" + " " + line);
                }


            }
            return Vars;
        } catch (IOException e) {
            throw new IOException(e);
        } catch(InvalidLine e){
            throw e;
        }


    }
}
