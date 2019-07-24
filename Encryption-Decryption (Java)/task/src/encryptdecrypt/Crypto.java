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
}
