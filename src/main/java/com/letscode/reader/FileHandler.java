package com.letscode.reader;
import java.io.*;
import java.util.*;

public class FileHandler {

    public static Set<String> importedResult;
    public static  Set<String> elReader(File newFile) throws IOException {
        Set<String> result = new TreeSet<String>();
        FileReader file = new FileReader(newFile);
        BufferedReader readFile = new BufferedReader(file);
        String line = readFile.readLine();

        try {
           while (line!= null){
              result.add(line);
              line = readFile.readLine();
            }
            readFile.close();
            System.out.println(result);

        }
        catch(IOException e) {
            e.printStackTrace();
        }
        importedResult = result;
        return importedResult;
    }
}
