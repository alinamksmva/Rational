import org.junit.*;
import static org.junit.Assert.*;

public class TestsOperation {

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
    public void testPlus() {
        rational_1.setNumerator(1);
        rational_1.setDenominator(2);
        rational_2.setNumerator(2);
        rational_2.setDenominator(3);
        assertTrue("Addition error", rational_1.plus(rational_2).equals(new Rational(7, 6)));
        rational_2.setNumerator(-2);        
        assertTrue("Addition error", rational_1.plus(rational_2).equals(new Rational(-1, 6)));
        rational_1.setNumerator(-1); 
        assertTrue("Addition error", rational_1.plus(rational_2).equals(new Rational(-7, 6)));
        rational_2.setNumerator(2);
        assertTrue("Addition error", rational_1.plus(rational_2).equals(new Rational(1, 6)));
    }

    @Test
    public void testMinus() {
        rational_1.setNumerator(1);
        rational_1.setDenominator(2);
        rational_2.setNumerator(2);
        rational_2.setDenominator(3);
        assertTrue("Subtraction error", rational_1.minus(rational_2).equals(new Rational(-1, 6)));
    }

    @Test
    public void testMultiply() {
        rational_1.setNumerator(1);
        rational_1.setDenominator(2);
        rational_2.setNumerator(2);
        rational_2.setDenominator(3);
        assertTrue("Multiplication error", rational_1.multiply(rational_2).equals(new Rational(1, 3)));
        rational_2.setNumerator(-2);        
        assertTrue("Multiplication error", rational_1.multiply(rational_2).equals(new Rational(-1, 3)));
        rational_1.setNumerator(-1); 
        assertTrue("Multiplication error", rational_1.multiply(rational_2).equals(new Rational(1, 3)));
        rational_2.setNumerator(0);
        assertTrue("Multiplication error", rational_1.multiply(rational_2).equals(new Rational()));
        rational_1.setNumerator(1);
        assertTrue("Multiplication error", rational_1.multiply(rational_2).equals(new Rational()));
        assertTrue("Multiplication error", rational_2.multiply(rational_2).equals(new Rational()));
    }

    @Test
    public void testDivide() {
        rational_1.setNumerator(1);
        rational_1.setDenominator(2);
        rational_2.setNumerator(2);
        rational_2.setDenominator(3);
        assertTrue("Division error", rational_1.divide(rational_2).equals(new Rational(3, 4)));
    }

    @Test (expected = ArithmeticException.class)
    public void DivideNegative() {
        rational_1.setNumerator(1);
        rational_1.setDenominator(2);
        rational_2.setNumerator(0);
        rational_2.setDenominator(3);
        rational_1.divide(rational_2);
    }
    
}