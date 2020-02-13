package fr.unilim.iut.cryptanalyse;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Kasiski
 */
public class Kasiski {

    public static int estimateKeySize(String encryptedText) {
        encryptedText.indexOf(encryptedText.substring(0, 2), 0);

        // TODO : remplacer par une hashmap (séquence, liste) pour avoir leurs positionS
        HashMap<String, ArrayList> hm = new HashMap<>();
        int j = encryptedText.length() - 1;
        int fromIndex;
        String sequence;

        while (j > 0) {
            int i = 0;

            while (i + j < encryptedText.length()) {
                sequence = encryptedText.substring(i, i + j);
                fromIndex = 0;
                hm.put(sequence, new ArrayList<Integer>());

                while ((fromIndex = encryptedText.indexOf(sequence, fromIndex)) != -1) {

                    System.out.println("Found at index: " + fromIndex);
                    System.out.println("Searching : " + sequence);

                    hm.get(sequence).add(fromIndex);

                    fromIndex++;

                }

                // On ne s'embête pas avec ceux qui sont seuls
                if (hm.get(sequence).size() == 1) {
                    hm.remove(sequence);
                }

                i += 1;
            }
            j -= 1;
        }

        System.out.println(encryptedText);
        System.out.println(hm.toString());

        return 0;

    }
}