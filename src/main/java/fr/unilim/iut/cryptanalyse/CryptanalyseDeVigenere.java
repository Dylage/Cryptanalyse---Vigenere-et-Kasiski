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
<<<<<<< Updated upstream:src/main/java/fr/unilim/iut/cryptanalyse/CryptanalyseDeVigenere.java
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
=======
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
                System.out.println(Vigenere.encrypt("abctexteclair", "cle"));
                Kasiski.estimateKeySize(Vigenere.encrypt("abctexteclair", "cle"));

                break;
        
            default:
                System.err.println("Mauvaise proposition !");
                break;
        }
>>>>>>> Stashed changes:CryptanalyseDeVigenere.java

            System.out.println("Veuillez entrer la clef :");
            key = sc.next();

            clearText = Vigenere.decrypt(crypted, key);

            System.out.println("Texte déchiffré : " + Vigenere.decrypt(crypted, key));
            break;
        case 3:
            System.out.println(Vigenere.encrypt("texteclair", "cle"));
            Kasiski.estimateKeySize(Vigenere.encrypt("texteclair", "cle"));

            break;

        default:
            System.err.println("Mauvaise proposition !");
            break;
        }

        System.out.println("\n\nÀ votre service\nAu revoir...");
        sc.close();

    }
}