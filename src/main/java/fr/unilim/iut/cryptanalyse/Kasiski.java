package fr.unilim.iut.cryptanalyse;

import java.util.HashMap;

/**
 * Kasiski
 */
public class Kasiski {

    public static int estimateKeySize(String encryptedText) {
        encryptedText.indexOf(encryptedText.substring(0, 2), 0);

        // TODO : remplacer par une hashmap (séquence, liste) pour avoir leurs positionS
        HashMap<String, Integer> hm = new HashMap<>();
        int i = 0;
        int j = 2;
        int occurrences;
        int fromIndex;
        String sequence;

        // TODO : boucler différentes analyses entre (0, 2)
        while (j < encryptedText.length()) {
            sequence = encryptedText.substring(i, j);
            occurrences = 0;
            fromIndex = 0;

            while ((fromIndex = encryptedText.indexOf(sequence, fromIndex)) != -1) {

                System.out.println("Found at index: " + fromIndex);
                System.out.println("Searching : " + sequence);

                occurrences++;
                fromIndex++;

            }
            hm.put(sequence, occurrences);
            i += 2;
            j += 2;
        }

        System.out.println(encryptedText);
        System.out.println(hm.toString());

        return 0;

    }
}