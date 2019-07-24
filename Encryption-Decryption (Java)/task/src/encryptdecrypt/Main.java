package encryptdecrypt;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        Parser parse = new Parser(args);  // instantiate the parser
        parse.map();  // parse the command line arguments
        ArrayList commands = parse.findCommands();  // extract corresponding arguments in array
        String mode = (String) commands.get(0);
        int shiftNumber = Integer.parseInt((String) commands.get(1));
        String data = (String) commands.get(2);
        Crypto crypto = new Crypto();  // instantiate the action object
        if (mode.equals("enc")) {
            System.out.println(crypto.encryptLetters(data, shiftNumber));
        }
        else {
            System.out.println(crypto.decryptLetters(data, shiftNumber));
        }
    }
}
