
import org.example.CastingAssignment;
import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;

public class CastingAssignmentTest {
    private CastingAssignment castingAssignment;

    @Before
    public void setUp() {
        castingAssignment = new CastingAssignment();
    }

    @Test
    public void testCastDoubleToInt() {
        double decimalNum = castingAssignment.decimalNum;
        assertEquals(112, castingAssignment.castDoubleToInt(decimalNum));

    }

    @Test
    public void testParseStringToInt() {
        String stringValue = castingAssignment.stringValue;
        assertEquals(49, castingAssignment.parseStringToInt(stringValue));
    }
}