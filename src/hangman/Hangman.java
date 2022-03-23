package hangman;

import java.util.Scanner;

/**
 * @author Herbe
 */

public class Hangman {
    public static void draw(int intentos){
        switch (intentos) {
            case 0:
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                break;
            case 1:
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("     -------");
                break;
            case 2:
                System.out.println("");
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("     -------");
                break;
            case 3:
                System.out.println("   ------");
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("     -------");
                break;
            case 4:
                System.out.println("  |------");
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("     -------");
                break;
            case 5:
                System.out.println("  |------");
                System.out.println("  O     |");
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("     -------");
                break;
            case 6:
                System.out.println("  |------");
                System.out.println("  O_    |");
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("     -------");
                break;
            case 7:
                System.out.println("  |------");
                System.out.println(" _O_    |");
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("     -------");
                break;
            case 8:
                System.out.println("  |------");
                System.out.println(" _O_    |");
                System.out.println("  |     |");
                System.out.println("        |");
                System.out.println("        |");
                System.out.println("     -------");
                break;
            case 9:
                System.out.println("  |------");
                System.out.println(" _O_    |");
                System.out.println("  |     |");
                System.out.println(" /      |");
                System.out.println("        |");
                System.out.println("     -------");
                break;
            case 10:
                System.out.println("  |------");
                System.out.println(" _O_    |");
                System.out.println("  |     |");
                System.out.println(" / \\    |");
                System.out.println("        |");
                System.out.println("     -------");
                break;
        }
    } //switch with drawings
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        String letter = "";
        String result="";
        int attemp = 0,count=0;
        System.out.println("-- HANGMAN GAME --");
        System.out.print("ENTER THE WORD TO GUESS: ");
        String word = teclado.nextLine();
        for (int i = 0; i < word.length(); i++) { //we add "_" for every letter
            result+="_"; 
        }
        for (int i = 0; i < word.length(); i++) {
            System.out.print(result.charAt(i)+" "); //we show word with white spaces
        }
        System.out.println("");
        
        char[] newresult = result.toCharArray(); //we add the word to an array char
        
        while (attemp<10) {
            System.out.print("Please enter a letter: ");
            char charletter = teclado.nextLine().charAt(0); //we request letter
            letter+=charletter;

            if (word.contains(letter)) { //We check that the word contains the letter
                draw(attemp);
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i)==charletter) {
                        if (newresult[i]==charletter) {
                            attemp++;
                            System.out.println("REPEATED LETTER");
                            draw(attemp);
                        } else {
                            newresult[i]=charletter;
                        }
                    }
                }
                for (int i = 0; i < newresult.length; i++) {
                    if (newresult[i]!='_') {
                        count++;
                        if (count==newresult.length) {
                            attemp=11;
                        }
                    }
                }
                count=0;
                
            } else {
                attemp++;
                System.out.println("THAT LETTER IS NOT");
                draw(attemp);
            }
                for (int i = 0; i < newresult.length; i++) {
                    System.out.print(newresult[i]+" ");
                }
                System.out.println("");
            letter="";
        }
        
        if (attemp==10) {
            System.out.println("------------------");
            System.out.println("YOU HAVE LOST");
            System.out.println("------------------");
        } else if (attemp==11) {
            System.out.println("------------------");
            System.out.println("YOU HAVE WON!!");
            System.out.println("------------------");
        }

    }
    
}
