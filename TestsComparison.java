import org.junit.*;
import static org.junit.Assert.*;

public class TestsComparison {

    private Rational rational_1, rational_2;

    @Before
    public void initialize() {
        rational_1 = new Rational();
        rational_2 = new Rational();
    }

    @After
    public void drop() {
        rational_1 = null;
        rational_2 = null;
    }

    @Test
    public void testEquals() {
        assertFalse("Equality error", rational_1.equals(null));
        assertFalse("Equality error", rational_1.equals(new Object()));
        assertTrue("Equality error", rational_1.equals(rational_2));
        rational_1.setNumerator(1);
        assertFalse("Equality error", rational_1.equals(rational_2));
        rational_1.setDenominator(-2);
        assertFalse("Equality error", rational_1.equals(rational_2));
        rational_2.setNumerator(-1);
        assertFalse("Equality error", rational_1.equals(rational_2));
    }

    @Test
    public void testLess() {
        rational_1.setNumerator(-5);
        rational_1.setDenominator(6);
        rational_2.setNumerator(7);
        rational_2.setDenominator(6);
        assertTrue("Less error", rational_1.less(rational_2));
        rational_2.setNumerator(-5);
        assertFalse("Less error", rational_1.less(rational_2));
        rational_2.setDenominator(7);
        assertTrue("Less error", rational_1.less(rational_2));
        rational_1.setNumerator(5);
        rational_1.setNumerator(5);
        assertFalse("Less error", rational_1.less(rational_2));
        rational_2.setNumerator(-3);
        assertFalse("Less error", rational_1.less(rational_2));
        rational_1.setNumerator(-4);
        assertTrue("Less error", rational_1.less(rational_2));
    }

    @Test
    public void testLessOrEqual() {
        rational_1.setNumerator(-5);
        rational_1.setDenominator(6);
        rational_2.setNumerator(7);
        rational_2.setDenominator(6);
        assertTrue("LessOrEqual error", rational_1.lessOrEqual(rational_2));
        rational_2.setNumerator(-5);
        assertTrue("LessOrEqual error", rational_1.lessOrEqual(rational_2));
        rational_1.setNumerator(25);
        assertFalse("LessOrEqual error", rational_1.lessOrEqual(rational_2));
    }
}