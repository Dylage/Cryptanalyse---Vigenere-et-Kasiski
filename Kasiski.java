/**
 * Kasiski
 */
public class Kasiski {

    public static int estimateKeySize(String encryptedText) {
        encryptedText.indexOf(encryptedText.substring(0, 2), 0);

        
        String sequence = encryptedText.substring(0, 2);
        int occurrences = 0;
        int fromIndex = 0;
        
        while ((fromIndex = encryptedText.indexOf(sequence, fromIndex)) != -1 ){
 
            System.out.println("Found at index: " + fromIndex);
            occurrences++;
            fromIndex++;
            
        }
        
        System.out.println("Total occurrences: " + occurrences);
        return occurrences;
    }
}