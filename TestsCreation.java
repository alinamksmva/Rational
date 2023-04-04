import org.junit.*;
import static org.junit.Assert.*;

public class TestsCreation {

    private Rational standard, rational;

    @Before
    public void initialize() {
        standard = new Rational();
        rational = new Rational(2, 3);
    }

    @After
    public void drop() {
        standard = null;
        rational = null;
    }

    @Test
    public void testStandardConstructor() {
        assertEquals("Standard constructor returns wrong numerator", 0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, standard.getDenominator());
    }

    @Test
    public void testConstructorWithParameters() {
        assertEquals("Constructor with parameters returns wrong numerator", 2, rational.getNumerator());
        assertEquals("Constructor with parameters returns wrong denominator", 3, rational.getDenominator());
    }

    @Test (expected = ArithmeticException.class)
    public void ConstructorWithParametersNegative() {
        rational = new Rational(5, 0);
    }

    @Test
    public void testToString() {
        assertEquals("Incorrect translation into a string", "2/3", rational.toString());
        rational.setNumerator(-2);
        assertEquals("Incorrect translation into a string", "-2/3", rational.toString());
    }

    @Test
    public void testReduce() {
        rational.setNumerator(-25);
        rational.setDenominator(35);
        assertEquals("After reduce returns wrong numerator", -5, rational.getNumerator());
        assertEquals("After reduce returns wrong denominator", 7, rational.getDenominator());
        rational.setNumerator(4);
        rational.setDenominator(2);
        assertEquals("After reduce returns wrong numerator", 2, rational.getNumerator());
        assertEquals("After reduce returns wrong denominator", 1, rational.getDenominator());
        rational.setNumerator(200);
        rational.setDenominator(-300);
        assertEquals("After reduce returns wrong numerator", -2, rational.getNumerator());
        assertEquals("After reduce returns wrong denominator", 3, rational.getDenominator());
        rational.setNumerator(-1000);
        rational.setDenominator(-500);
        assertEquals("After reduce returns wrong numerator", 2, rational.getNumerator());
        assertEquals("After reduce returns wrong denominator", 1, rational.getDenominator());
        standard.setDenominator(5);
        assertEquals("After reduce returns wrong denominator", 1, standard.getDenominator());
    }

    @Test (expected = ArithmeticException.class)
    public void SetDenominatorNegative() {
        rational.setDenominator(0);
    }
}