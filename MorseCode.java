//  Pierre LEMON
//  Inlämningsuppgift del 1 om morsekod
//  2025-01-20
//  2/3

package MorseCodeInlamningsuppgift1;

import java.util.HashMap;
import java.util.Map;

public class MorseCode {
//    Skapar Static istället för private då det ger lite snabbare väg mellan klasser, vilket innebär
//    att static inte är instanser av den medan private kan bara användas inom samma klass

    private static final Map<Character, String> textToMorse = new HashMap<>();
    private static final Map<String, Character> morseToText = new HashMap<>();

    // Fyll i morsekod-tabellen vid programmets start
    static {
        // Bokstäver
        textToMorse.put('A', ".-");    textToMorse.put('B', "-...");
        textToMorse.put('C', "-.-.");  textToMorse.put('D', "-..");
        textToMorse.put('E', ".");     textToMorse.put('F', "..-.");
        textToMorse.put('G', "--.");   textToMorse.put('H', "....");
        textToMorse.put('I', "..");    textToMorse.put('J', ".---");
        textToMorse.put('K', "-.-");   textToMorse.put('L', ".-..");
        textToMorse.put('M', "--");    textToMorse.put('N', "-.");
        textToMorse.put('O', "---");   textToMorse.put('P', ".--.");
        textToMorse.put('Q', "--.-");  textToMorse.put('R', ".-.");
        textToMorse.put('S', "...");   textToMorse.put('T', "-");
        textToMorse.put('U', "..-");   textToMorse.put('V', "...-");
        textToMorse.put('W', ".--");   textToMorse.put('X', "-..-");
        textToMorse.put('Y', "-.--");  textToMorse.put('Z', "--..");





        // Här bygger den omvända mappen (Morse → text) och istället kan man spegla på
        // befintliga mönster/tabell på textToMorse och byter plats med värde på key och value. Bingo!
        for (Map.Entry<Character, String> entry : textToMorse.entrySet()) {
            morseToText.put(entry.getValue(), entry.getKey());
        }
    }


    // Metod för att skriva ut hela morsekodstabellen
// Metod för att skriva ut hela morsekodstabellen
    public static void printMorseTable() {
        System.out.println("\nMorse-tabell:\n");
        int counter = 0;

        for (Map.Entry<Character, String> entry : textToMorse.entrySet()) {
            // Skriver ut formaterad text med jämn bredd
            System.out.printf("%-3s → %-6s", entry.getKey(), entry.getValue()); // Justerar tecken och morsekod med bredder

            counter++;
            if (counter % 5 == 0) { // Efter varje 5:e tecken, byt rad
                System.out.println();
            } else {
                System.out.print("\t"); // Lägg till tab för jämnare justering
            }
        }
        System.out.println(); // Avsluta med en ny rad för snygg formatering
    }



    //    // Metod: Omvandla text till morsekod och använder stringbuilder istället för string är anledning
//    till att med string skapas en ny sträng i minnet och java kan inte modifiera så snabbt utan måste
//    skapa en ny vilket tar tid, så däremot är stringbuilder lämplig användning att användas just i samband
//            med den här koden är att man använder append som skapar samma objekt hela tiden.

    public static String textToMorse(String text) {
        StringBuilder morse = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (textToMorse.containsKey(c)) {
                morse.append(textToMorse.get(c)).append(" ");
            } else if (c == ' ') {
                morse.append("  "); // två mellanslag mellan ord
            } else {
                throw new IllegalArgumentException("Fel: Ogiltigt tecken '" + c + "' i texten.");
            }
        }
        return morse.toString().trim();
    }

//    // Metod: Omvandla morsekod till text och samma sak med den här som ovanstående klass morseCode om
//    varför man ska välja stringbuilder

    public static String morseToText(String morse) {
        StringBuilder text = new StringBuilder();
        String[] words = morse.trim().split("\\s{3,}"); // Tre eller fler mellanslag mellan ord

        for (String word : words) {
            for (String letter : word.trim().split("\\s+")) { // Hantera extra mellanslag
                if (morseToText.containsKey(letter)) {
                    text.append(morseToText.get(letter));
                } else {
                    System.out.println("Varning: Ogiltig morsekod '" + letter + "'. Skippas.");
                }
            }
            text.append(" ");
        }
        return text.toString().trim();
    }
}
