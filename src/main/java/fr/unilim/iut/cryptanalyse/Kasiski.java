package fr.unilim.iut.cryptanalyse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

        HashSet<Integer> hs = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (String str : listRepetitions.keySet()) {
            // if (str.length() == length) {
                ArrayList<Integer> list = new ArrayList<>();
                for (Object position : listRepetitions.get(str)) {
                    list.add((int) position);
                }
                size = findGCD(list.toArray());
                hs.add(size);
                if (!pq.contains(size)) {
                    pq.add(size);
                }
            // }
            
        }
        System.out.println(pq);
        int originalSize = pq.size();
        for (int i = 0; i < originalSize; i++) {
            System.out.println(pq.poll());
        }

        


        return size;

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
    
    /**
     * Méthode pour obtenir le PGCD d'une liste d'objets
     * @param arr : doivent être typecastable en entier
     * @return : PGCD(0, 1, ..., n)
     */
    private static int findGCD(Object arr[]) 
    { 
        int result = (int) arr[0]; 
        for (int i = 1; i < arr.length; i++) 
        { 
            result = gcd((int) arr[i], result); 
    
            if(result == 1) 
            { 
                return 1; 
            } 
        } 
        return result; 
    } 
}