
import org.example.Casting;
import org.junit.Before;
import org.junit.Test;

public class CastingT {
    private Casting castingAssignment;

    @Before
    public void setUp() {
        castingAssignment = new Casting();
    }

    @Test
    public void testCastDoubleToInt() {
        double decimalNum = castingAssignment.decimalNum;
        assertEquals(112, castingAssignment.castDoubleToInt(decimalNum));

    }

    private void assertEquals(int i, int i1) {
    }

    @Test
    public void testParseStringToInt() {
        String stringValue = castingAssignment.stringValue;
        assertEquals(49, castingAssignment.parseStringToInt(stringValue));
    }
}