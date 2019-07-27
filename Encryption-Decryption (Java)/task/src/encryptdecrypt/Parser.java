package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;

public class Parser {

    private String[] args;
    private HashMap<String,String> dict;
    private ArrayList<String> array;

    public Parser(String[] args) {
        this.args = args;
        this.dict = new HashMap<>();
        this.array = new ArrayList<>();
    }

    public void map() {  // returns arguments in hash map
        int i = 0;
        while (i<this.args.length) {
            String arg = this.args[i];
            this.dict.put(arg.substring(1),this.args[i+1]);
            i += 2;
        }
    }

    public ArrayList<String> findCommands() {
        String data;
        String mode;
        String out;
        String in;
        String algo;
        if (!this.dict.containsKey("data")) {
            data = "fromFile";
        }
        else {
            data = this.dict.get("data");
        }
        String shiftNumber = this.dict.get("key");
        if (!this.dict.containsKey("mode")) {
            mode = "enc";
        }
        else {
            mode = this.dict.get("mode");
        }
        if (!this.dict.containsKey("out")) {
            out = "printOut";
        }
        else {
            out = this.dict.get("out");
        }
        if (!this.dict.containsKey("in")) {
            in = "fromCommandLine";
        }
        else {
            in = this.dict.get("in");
        }
        algo = this.dict.get("alg");
        this.array.add(mode);
        this.array.add(shiftNumber);
        this.array.add(data);
        this.array.add(in);
        this.array.add(out);
        this.array.add(algo);
        return this.array;
    }


    public String readFileExceptionHandling(String fileName) {
        String result = "";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            System.out.println("There is no such file, "+e.getMessage());
        }
        return result;
    }

    public void writeFileExceptionHandling(String fileName, String output) {
        File file = new File(fileName);
        try ( FileWriter writer = new FileWriter(file)){
            writer.write(output);
        }
        catch (IOException e) {
            System.out.println("An exception occured while writing "+e.getMessage());
        }
    }
}
