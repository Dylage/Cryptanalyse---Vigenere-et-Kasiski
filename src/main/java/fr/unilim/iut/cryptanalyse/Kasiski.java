package fr.unilim.iut.cryptanalyse;

/**
 * Kasiski
 */
public class Kasiski {

    public static int estimateKeySize(String encryptedText) {
        encryptedText.indexOf(encryptedText.substring(0, 2), 0);

<<<<<<< Updated upstream:src/main/java/fr/unilim/iut/cryptanalyse/Kasiski.java
=======
        // TODO : boucler différentes analyses entre (0, 2)

        
>>>>>>> Stashed changes:Kasiski.java
        String sequence = encryptedText.substring(0, 2);
        int occurrences = 0;
        int fromIndex = 0;

<<<<<<< Updated upstream:src/main/java/fr/unilim/iut/cryptanalyse/Kasiski.java
        while ((fromIndex = encryptedText.indexOf(sequence, fromIndex)) != -1) {

            System.out.println("Found at index: " + fromIndex);
=======
        System.out.println("Searching : " + sequence);
        
        while ((fromIndex = encryptedText.indexOf(sequence, fromIndex)) != -1 ){
 
            System.out.println("Found at index : " + fromIndex);
>>>>>>> Stashed changes:Kasiski.java
            occurrences++;
            fromIndex++;

        }
<<<<<<< Updated upstream:src/main/java/fr/unilim/iut/cryptanalyse/Kasiski.java

        System.out.println("Total occurrences: " + occurrences);
=======
        
        System.out.println("Total occurrences : " + occurrences);
>>>>>>> Stashed changes:Kasiski.java
        return occurrences;
    }
}