package fr.unilim.iut.cryptanalyse;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Kasiski
 */
public class Kasiski {

    public static HashMap<String, ArrayList> findRepetitions(String encryptedText){
        HashMap<String, ArrayList> listRepetitions = new HashMap<>();
        int j = encryptedText.length() - 1;
        int fromIndex;
        String sequence;

        while (j > 0) {
            int i = 0;

            while (i + j < encryptedText.length()) {
                sequence = encryptedText.substring(i, i + j);
                fromIndex = 0;
                listRepetitions.put(sequence, new ArrayList<Integer>());

                while ((fromIndex = encryptedText.indexOf(sequence, fromIndex)) != -1) {

                    listRepetitions.get(sequence).add(fromIndex);

                    fromIndex++;

                }

                // On ne s'embête pas avec ceux qui sont seuls
                if (listRepetitions.get(sequence).size() == 1) {
                    listRepetitions.remove(sequence);
                }

                i += 1;
            }
            j -= 1;
        }

        return listRepetitions;
    }

    public static int estimateKeySize(String encryptedText) {

        int size = 0;

        // On récupère la liste des répétitions de caractères
        HashMap<String, ArrayList> listRepetitions = findRepetitions(encryptedText);

        // On cherche la plus grande
        int length = 0;
        for (String str : listRepetitions.keySet()) {
            if (str.length() > length) {
                length = str.length();
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // On trie selon la taille de la chaine répétée
        for (String str : listRepetitions.keySet()) {
            // On ne garde que les répétitions de String de plus de deux caractères
            if (str.length() > 2) {
                ArrayList<Integer> list = new ArrayList<>();
                for (Object position : listRepetitions.get(str)) {
                    list.add((int) position);
                }
                size = smallerDistance(list.toArray());
                pq.add(size);
            }
            
        }
        int originalSize = pq.size();
        ArrayDeque<Integer> ad = new ArrayDeque();
        // On met tout dans un ArrayDeque de manière triée, sans les doublons
        for (int i = 0; i < originalSize; i++) {
            if (!ad.contains(pq.element())){
                ad.addLast(pq.poll());
            }else{
                pq.poll();
            }
        }
        
        int pgcd = 0;
        int i = 0;
        // Enfin, on fait les PGCD tant que différents de 1 pour avoir la taille probable de la clef
        while (i < ad.size() - 1) {
            if (pgcd == 0) {
                pgcd = gcd((int) ad.toArray()[i], (int) ad.toArray()[i+ 1]);
            }
            if (pgcd == 1) {
                pgcd = gcd((int) ad.toArray()[i], (int) ad.toArray()[i + 2]);
            }else{
                pgcd = gcd(pgcd, (int) ad.toArray()[i + 1]);
            }
            i += 1;
        }

        return pgcd;

    }

    /**
     * Méthode pour obtenir le plus grand commun diviseur (PGCD) de deux nombres
     * @param a
     * @param b
     * @return : PGCD(a,b)
     */
    private static int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
        return gcd(b % a, a); 
    } 

    private static int smallerDistance(Object arr[]){
        int n = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((int) arr[i + 1] - (int) arr[i] < n) {
                n = (int) arr[i + 1] - (int) arr[i];
            }
        }

        return n;
    }
}