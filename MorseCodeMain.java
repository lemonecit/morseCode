import java.util.Scanner;

public class MorseCodeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Be användaren skriva in något
            System.out.print("\nSkriv in text eller morsekod: ");
            String input = scanner.nextLine().trim();

            // Kontrollera om inmatningen är tom
            if (input.isEmpty()) {
                System.out.println("⚠️ Fel: Du måste skriva något!");
                continue; // Gå tillbaka till början av loopen
            }

            // Identifiera och hantera rätt format
            try {
                if (isMorseCode(input)) {
                    // Om det är morsekod → översätt till text
                    System.out.println("🔍 Identifierad som morsekod!");
                    String translatedText = MorseCode.morseToText(input);

                    // Kontrollera om det blev en ogiltig översättning
                    if (translatedText.contains("?")) {
                        System.out.println("⚠️ Fel: Morseinmatning innehåller ogiltiga koder.");
                    } else {
                        System.out.println("📜 Text: " + translatedText);
                    }

                } else if (isValidText(input)) {
                    // Om det är vanlig text → översätt till morsekod
                    System.out.println("🔍 Identifierad som vanlig text!");
                    System.out.println("📜 Morse: " + MorseCode.textToMorse(input));
                } else {
                    System.out.println("⚠️ Fel: Textinmatning innehåller ogiltiga tecken.");
                }

            } catch (Exception e) {
                System.out.println("❌ Ett oväntat fel inträffade: " + e.getMessage());
            }

            // Fråga användaren om de vill fortsätta
            String answer;
            while (true) {
                System.out.print("\n🔁 Vill du fortsätta? (j/n): ");
                answer = scanner.nextLine().trim().toLowerCase();

                if (answer.equals("j")) {
                    break; // Fortsätt loopen
                } else if (answer.equals("n")) {
                    System.out.println("\n✅ Tack för att du använt vår översättningsmaskin!");
                    scanner.close(); // Stäng scanner innan vi avslutar
                    return; // Avsluta programmet
                } else {
                    System.out.println("⚠️ Fel: Skriv 'j' för att fortsätta eller 'n' för att avsluta.");
                }
            }
        }
    }

    // Metod för att identifiera om inmatningen är morsekod
    private static boolean isMorseCode(String input) {
        return input.matches("[ .\\-]+"); // Tillåter endast mellanslag, punkt (.) och streck (-)
    }

    // Metod för att identifiera om texten är giltig (endast bokstäver och siffror)
    private static boolean isValidText(String input) {
        return input.matches("[a-zA-Z0-9 ]+"); // Tillåter endast bokstäver, siffror och mellanslag
    }
}
