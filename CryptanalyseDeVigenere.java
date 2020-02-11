/**
 * tp1
 */
public class CryptanalyseDeVigenere {

    public static void main(String[] args) {

        String clearText = "texteClair";
        String key = "clef";

        String crypted = Vigenere.encrypt(clearText, key);
        
        System.out.println("chiffrement : " + crypted);

        System.out.println("déchiffrement : " + Vigenere.decrypt(crypted, key));

    }
}