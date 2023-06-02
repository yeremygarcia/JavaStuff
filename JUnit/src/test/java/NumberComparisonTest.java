import org.example.NumberComparison;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberComparisonTest {
    @Test
    void TwoIsEqualToTwo(){
        NumberComparison isEqual = new NumberComparison();
        assertTrue(isEqual.compareNumbers(2,2));
    }

    @Test
    void ThreeDoesNotEqualTwo(){
        NumberComparison notEqual = new NumberComparison();
        assertFalse(notEqual.compareNumbers(3,2));
        assertFalse(notEqual.compareNumbers(2,3));
    }
}