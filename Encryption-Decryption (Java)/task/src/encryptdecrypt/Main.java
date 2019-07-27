package encryptdecrypt;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String input = "";
        String output = "";
        Parser parse = new Parser(args);  // instantiate the parser
        parse.map();  // parse the command line arguments
        ArrayList commands = parse.findCommands();  // extract corresponding arguments in array
        String mode = (String) commands.get(0);
        int shiftNumber = Integer.parseInt((String) commands.get(1));
        String data = (String) commands.get(2);
        String in = (String) commands.get(3);
        String out = (String) commands.get(4);
        String algo = (String) commands.get(5);
        Crypto crypto = new Crypto();  // instantiate the action object
        if (mode.equals("enc")) {
            if (!data.equals("fromFile")) {
                if (out.equals("printOut")) {
                    if (algo.equals("unicode")) {
                        System.out.println(crypto.encryptLetters(data, shiftNumber));
                    }
                    else {
                        System.out.println(crypto.shift(data, shiftNumber));
                    }
                }
                else {
                    if (algo.equals("unicode")) {
                        output = crypto.encryptLetters(data, shiftNumber);
                        parse.writeFileExceptionHandling(out, output);
                    }
                    else {
                        output = crypto.shift(data, shiftNumber);
                        parse.writeFileExceptionHandling(out, output);
                    }
                }
            }
            else {
                input = parse.readFileExceptionHandling(in);
                if (out.equals("printOut")) {
                    if (algo.equals("unicode")) {
                        System.out.println(crypto.encryptLetters(input, shiftNumber));
                    }
                    else {
                        System.out.println(crypto.shift(input, shiftNumber));
                    }
                }
                else {
                    if (algo.equals("unicode")) {
                        output = crypto.encryptLetters(input, shiftNumber);
                        parse.writeFileExceptionHandling(out, output);
                    }
                    else {
                        output = crypto.shift(input, shiftNumber);
                        parse.writeFileExceptionHandling(out, output);
                    }
                }
                }
            }
        else {
            if (!data.equals("fromFile")) {
                if (out.equals("printOut")) {
                    if (algo.equals("unicode")) {
                        System.out.println(crypto.decryptLetters(data, shiftNumber));
                    }
                    else {
                        System.out.println(crypto.deshift(data, shiftNumber));
                    }
                }
                else {
                    if (algo.equals("unicode")) {
                        output = crypto.decryptLetters(data, shiftNumber);
                        parse.writeFileExceptionHandling(out, output);
                    }
                   else {
                        output = crypto.deshift(data, shiftNumber);
                        parse.writeFileExceptionHandling(out, output);
                    }
                }
            }
            else {
                input = parse.readFileExceptionHandling(in);
                if (out.equals("printOut")) {
                    if (algo.equals("unicode")) {
                        System.out.println(crypto.decryptLetters(input, shiftNumber));
                    }
                    else {
                        System.out.println(crypto.deshift(input, shiftNumber));
                    }
                }
                else {
                    if (algo.equals("unicode")) {
                        output = crypto.decryptLetters(input, shiftNumber);
                        parse.writeFileExceptionHandling(out, output);
                    }
                    else {
                        output = crypto.deshift(input, shiftNumber);
                        parse.writeFileExceptionHandling(out, output);
                    }
                }
            }
        }
    }
}