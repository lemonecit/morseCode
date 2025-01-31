import java.util.HashMap;
import java.util.Map;

public class MorseCode {
    private static final Map<Character, String> textToMorse = new HashMap<>();
    private static final Map<String, Character> morseToText = new HashMap<>();

    // Fyll i morsekod-tabellen vid programmets start
    static {
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
        textToMorse.put('1', ".----"); textToMorse.put('2', "..---");
        textToMorse.put('3', "...--"); textToMorse.put('4', "....-");
        textToMorse.put('5', "....."); textToMorse.put('6', "-....");
        textToMorse.put('7', "--..."); textToMorse.put('8', "---..");
        textToMorse.put('9', "----."); textToMorse.put('0', "-----");

        // Bygg den omvända mappen (Morse → text)
        for (Map.Entry<Character, String> entry : textToMorse.entrySet()) {
            morseToText.put(entry.getValue(), entry.getKey());
        }
    }

    // Metod: Omvandla text till morsekod
    public static String textToMorse(String text) {
        StringBuilder morse = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (textToMorse.containsKey(c)) {
                morse.append(textToMorse.get(c)).append(" ");
            } else if (c == ' ') {
                morse.append("  "); // Två mellanslag mellan ord
            } else {
                throw new IllegalArgumentException("Fel: Ogiltigt tecken '" + c + "' i texten.");
            }
        }
        return morse.toString().trim();
    }

    // Metod: Omvandla morsekod till text
    public static String morseToText(String morse) {
        StringBuilder text = new StringBuilder();
        String[] words = morse.trim().split("   "); // Tre mellanslag mellan ord
        for (String word : words) {
            for (String letter : word.split(" ")) {
                text.append(morseToText.getOrDefault(letter, '?')); // ? vid okänd morsekod
            }
            text.append(" ");
        }
        return text.toString().trim();
    }
}
