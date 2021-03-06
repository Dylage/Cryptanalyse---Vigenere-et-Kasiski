package fr.unilim.iut.cryptanalyse;

import java.util.Scanner;

/**
 * tp1
 */
public class CryptanalyseDeVigenere {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenue dans ce module de chiffrement / déchiffrement de VIGENERE");
        System.out.println("1 - Chiffrer");
        System.out.println("2 - Déchiffrer");
        System.out.println("3 - Cryptanalyse (Kasiski)");
        System.out.print("Votre choix : ");

        int choix = sc.nextInt();

        String crypted;
        String clearText;
        String key;

        switch (choix) {
            case 1:
                System.out.println("Veuillez entrer le texte à chiffrer :");
                clearText = sc.next();
        
                System.out.println("Veuillez entrer la clef :");
                key = sc.next();
        
                crypted = Vigenere.encrypt(clearText, key);
                
                System.out.println("Texte chiffré : " + crypted);
                break;
            case 2:
                System.out.println("Veuillez entrer le texte à déchiffrer :");
                crypted = sc.next();
        
                System.out.println("Veuillez entrer la clef :");
                key = sc.next();
        
                clearText = Vigenere.decrypt(crypted, key);
                
                System.out.println("Texte déchiffré : " + Vigenere.decrypt(crypted, key));
                break;
            case 3:
                System.out.println("Veuillez entrer le texte à analyser :");
                crypted = sc.next();
                int[] tailles = Kasiski.estimateKeySize(crypted);
                System.out.println("\nTaille probable de la clef : " + tailles[0] + " ou " + tailles[1]);

                break;
        
            default:
                System.err.println("Mauvaise proposition !");
                break;
        }

        System.out.println("\n\nÀ votre service\nAu revoir...");
        sc.close();

    }
}