package encryptdecrypt;

import java.util.ArrayList;
import java.util.HashMap;

public class Parser {

    private String[] args;
    private HashMap<String,String> dict;
    private String commands = "";
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
        String mode;
        String data = this.dict.get("data");
        String shiftNumber = this.dict.get("key");

        if (this.dict.size() == 2) {
            mode = "enc";
        }
        else {
            mode = this.dict.get("mode");
        }
        this.array.add(mode);
        this.array.add(shiftNumber);
        this.array.add(data);
        return this.array;
    }
}
