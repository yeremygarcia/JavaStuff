import org.example.NumberComparison;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberComparisonTest<NumberComparison> {
    @Test
    <NumberComparison>
    void TwoIsEqualToTwo(){
        NumberComparison isEqual = new NumberComparison();
        assertTrue(isEqual.compareNumbers(2,2));
    }

    @Test
    void ThreeDoesNotEqualTwo(){
        NumberComparison notEqual = new NumberComparison();
        assertFalse(notEqual.clone(3,2));
        assertFalse(notEqual.clone(2,3));
    }
}