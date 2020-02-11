import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Vigenere
 */
public class Vigenere {

    // Initialisation statique de l'alphabet
    private static final Map<Integer, Character> alphabet;
    static {
        Map<Integer, Character> map = new HashMap<>();
        map.put(0, 'A');
        map.put(1, 'B');
        map.put(2, 'C');
        map.put(3, 'D');
        map.put(4, 'E');
        map.put(5, 'F');
        map.put(6, 'G');
        map.put(7, 'H');
        map.put(8, 'I');
        map.put(9, 'J');
        map.put(10, 'K');
        map.put(11, 'L');
        map.put(12, 'M');
        map.put(13, 'N');
        map.put(14, 'O');
        map.put(15, 'P');
        map.put(16, 'Q');
        map.put(17, 'R');
        map.put(18, 'S');
        map.put(19, 'T');
        map.put(20, 'U');
        map.put(21, 'V');
        map.put(22, 'W');
        map.put(23, 'X');
        map.put(24, 'Y');
        map.put(25, 'Z');

        alphabet = Collections.unmodifiableMap(map);
    }

    // Notes à moi-même
    // Travailler avec entiers plutot que lettres ?
    // Liste avec clef ?
    // Uniquement majuscules
    

    /**
     * Méthode pour chiffrer un texte clair avec une clef selon la méthode de Vigenere
     * @param clearText : texte à chiffrer, sans espace
     * @param key : texte utilisé comme clef
     * @return String : le texte chiffré
     */
    public static String encrypt(String clearText, String key){
        String encryptedText = "";

        // On ne travaille qu'avec les majuscules
        clearText = clearText.toUpperCase();
        key = key.toUpperCase();

        // Pour utiliser les for plus bas
        char[] letters =  clearText.toCharArray();
        char[] lettersKey = key.toCharArray();
        
        int i = 0;
        for (char c : letters) {
            // Pour chaque lettre, on récupère la lettre correspondant à celle-ci,
            // additionnée à son décalage selon la clef
            // Pour la clef, on utilise le modulo afin de revenir au début à chaque fois
            encryptedText += alphabet.get((char) (c + lettersKey[i % lettersKey.length]) % 26);
            i++;
        }

        return encryptedText;
        
    }

    /**
     * Méthode pour déchiffrer un texte chiffré avec une clef selon la méthode de Vigenere
     * @param encryptedText : texte à déchiffrer, sans espace
     * @param key : texte utilisé comme clef
     * @return String : le texte dechiffré
     */
    public static String decrypt(String encryptedText, String key){
        String clearText = "";

        // On ne travaille qu'avec les majuscules
        encryptedText = encryptedText.toUpperCase();
        key = key.toUpperCase();

        // Pour utiliser les for plus bas
        char[] letters =  encryptedText.toCharArray();
        char[] lettersKey = key.toCharArray();
        
        int i = 0;
        for (char c : letters) {
            // Pour chaque lettre, on récupère la lettre correspondant à celle-ci,
            // dont on soustrait son décalage selon la clef
            // Pour la clef, on utilise le modulo afin de revenir au début à chaque fois
            // Cette fois-ci, on ajoute 26 pour éviter les nombres négatifs
            clearText += alphabet.get((char) ((c - lettersKey[i % lettersKey.length]) + 26) % 26);
            i++;
        }

        return clearText;
        
    }
    
}