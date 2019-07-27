package encryptdecrypt;

public class Crypto {

    public Crypto() {}  // initialize class

    public static String encryptLetters(String letter, int shift) {  // method to encrypt
        int i;
        String encrypted = "";
        for (i=0;i<letter.length();i++) {
            encrypted += (char) (((int) letter.charAt(i))+shift);
        }
        return encrypted;
    }

    public static String decryptLetters(String letter, int shift) {  // method to decrypt
        int i;
        String decrypted = "";
        for (i=0;i<letter.length();i++) {
            decrypted += (char) (((int) letter.charAt(i))-shift);
        }
        return decrypted;
    }

    public static String shift(String letter, int shift) {
        int i;
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted = "";
        for (i=0;i<letter.length();i++) {
            Character character = letter.charAt(i);
            if (Character.isLetter(character)) {
                if (Character.isUpperCase(character)) {
                    int indx = upper.indexOf(Character.toString(character));
                    String result = Character.toString(upper.charAt((indx+shift)%26));
                    shifted += result;
                }
                else {
                    int indx = lower.indexOf(Character.toString(character));
                    String result = Character.toString(lower.charAt((indx+shift)%26));
                    shifted += result;
                }
            }
            else {
                shifted += Character.toString(character);
            }
        }
        return shifted;
    }

    public static String deshift(String letter, int shift) {
        int i;
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted = "";
        for (i=0;i<letter.length();i++) {
            Character character = letter.charAt(i);
            if (Character.isLetter(character)) {
                if (Character.isUpperCase(character)) {
                    int indx = upper.indexOf(Character.toString(character));
                    String result = Character.toString(upper.charAt(((indx-shift)+26)%26));
                    shifted += result;
                }
                else {
                    int indx = lower.indexOf(Character.toString(character));
                    System.out.println(indx);
                    String result = Character.toString(lower.charAt(((indx-shift)+26)%26));
                    shifted += result;
                }
            }
            else {
                shifted += Character.toString(character);
            }
        }
        return shifted;
    }
}
