//  Pierre LEMON
//  Inlämningsuppgift del 1 om morsekod
// TDD (Test-driven development)
//  2025-01-20
//  3/3


package MorseCodeInlamningsuppgift1;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MorseCodeTest {

    @Test
    public void testTextToMorse() {
        assertEquals(".... . .-.. .-.. ---", MorseCode.textToMorse("ello")); //Testa om Morse idenifierar fel
        assertEquals(".-- --- .-. .-.. -..", MorseCode.textToMorse("world"));
        assertEquals(".... . .-.. .-.. ---   .-- --- .-. .-.. -..", MorseCode.textToMorse("hello world"));
    }

    @Test
    public void testTextToMorse2() {
        assertEquals(".... . .---   - --- -- .- ...", MorseCode.textToMorse("hej tomas")); //Testa om Morse idenifierar fel
        assertEquals(".... . .---", MorseCode.textToMorse("hej"));
        assertEquals("- --- -- .- ...", MorseCode.textToMorse("tomas"));
    }

    @Test
    public void testMorseToText1() {
        assertEquals("HELLO", MorseCode.morseToText("... . .-.. .-.. ---"));
        assertEquals("WORLD", MorseCode.morseToText(".-- --- .-. .-.. -.."));
        assertEquals("HELLO WORLD", MorseCode.morseToText(".... . .-.. .-.. ---   .-- --- .-. .-.. -.."));
    }









}
