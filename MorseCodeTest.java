//  Pierre LEMON
//  Inlämningsuppgift del 1 om morsekod
//  2025-01-20
//  3/3



package MorseCodeInlamningsuppgift1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MorseCodeTest {

    // 📌 1️⃣ TESTER FÖR TEXT → MORSE
    @Test
    public void testTextToMorse_Hello() {
        assertEquals(".... . .-.. .-.. ---", MorseCode.textToMorse("HELLO"));
    }

    @Test
    public void testTextToMorse_World() {
        assertEquals(".-- --- .-. .-.. -..", MorseCode.textToMorse("WORLD"));
    }

    @Test
    public void testTextToMorse_HelloWorld() {
        assertEquals(".... . .-.. .-.. ---   .-- --- .-. .-.. -..", MorseCode.textToMorse("HELLO WORLD"));
    }

    @Test
    public void testTextToMorse_HejTomas() {
        assertEquals(".... . .---   - --- -- .- ...", MorseCode.textToMorse("HEJ TOMAS"));
    }

    @Test
    public void testTextToMorse_Hej() {
        assertEquals(".... . .---", MorseCode.textToMorse("HEJ"));
    }

    @Test
    public void testTextToMorse_Tomas() {
        assertEquals("- --- -- .- ...", MorseCode.textToMorse("TOMAS"));
    }

    // 📌 2️⃣ TESTER FÖR MORSE → TEXT
    @Test
    public void testMorseToText_Hello() {
        assertEquals("HELLO", MorseCode.morseToText(".... . .-.. .-.. ---"));
    }

    @Test
    public void testMorseToText_World() {
        assertEquals("WORLD", MorseCode.morseToText(".-- --- .-. .-.. -.."));
    }

    @Test
    public void testMorseToText_HelloWorld() {
        assertEquals("HELLO WORLD", MorseCode.morseToText(".... . .-.. .-.. ---   .-- --- .-. .-.. -.."));
    }

    @Test
    public void testMorseToText_HejTomas() {
        assertEquals("HEJ TOMAS", MorseCode.morseToText(".... . .---   - --- -- .- ..."));
    }

    // 📌 3️⃣ FELHANTERINGSTESTER (EXCEPTION TESTER)
    @Test
    public void testTextToMorse_InvalidCharacters() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> MorseCode.textToMorse("123"));
        assertEquals("Fel: Ogiltigt tecken '1' i texten.", exception.getMessage());
    }

    @Test
    public void testTextToMorse_EmptyInput() {
        assertEquals("", MorseCode.textToMorse(""));
    }

    @Test
    public void testMorseToText_EmptyInput() {
        assertEquals("", MorseCode.morseToText(""));
    }

    @Test
    public void testTextToMorse_Space() {
        assertEquals("/", MorseCode.textToMorse(" ")); // Mellanslag i Morse-kod är '/'
    }

    @Test
    public void testMorseToText_Space() {
        assertEquals(" ", MorseCode.morseToText("/")); // '/' konverteras tillbaka till mellanslag
    }
}
