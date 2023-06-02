import org.example.SameOrNah;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SameOrNahTest {

    @Test
    void wordsAreTheSame() {
        SameOrNah wordsAreSame = new SameOrNah();
        assertTrue(wordsAreSame.compareWords("Hi", "hi"));
    }
    @Test
    void wordsAreDifferent() {
        SameOrNah wordsAreDifferent = new SameOrNah();
        assertFalse(wordsAreDifferent.compareWords("Bye", "Hi"));
    }
}
