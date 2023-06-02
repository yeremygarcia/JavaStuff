
import org.example.Calculations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationsT {
    @Test
    void fourPlusThreeEqualsSeven () {
        Calculations mathAdd = new Calculations();
        assertEquals(7, mathAdd.add(4,3));
    }

    @Test
    void eightMinusThreeEqualsFive() {
        Calculations mathSubtract = new Calculations();
        assertEquals(5, mathSubtract.sub( 8,3));
    }

    @Test
    void fourTimesFourEqualsSixteen() {
        Calculations mathMultiply = new Calculations();
        assertEquals(16, mathMultiply.multiply(4,4));
    }

    @Test
    void tenDividedByTwoEqualsFivePointZero() {
        Calculations mathDivide = new Calculations();
        assertEquals(5.0, mathDivide.divide(10,2));
    }

    @Test
    void fiveDividedByTwoEqualsOne() {
        Calculations mathModulus = new Calculations();
        assertEquals(1.0, mathModulus.modulus(5, 2));
    }

}
