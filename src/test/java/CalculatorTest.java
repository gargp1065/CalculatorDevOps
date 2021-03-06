import calculator.Calculator;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-15;
    Calculator calculator = new Calculator();

    @Test
    public void factorialTruePositive(){
        assertEquals("Finding factorial of a number for True Positive", 720, calculator.factorial(6), DELTA);
        assertEquals("Finding factorial of a number for True Positive", 6, calculator.factorial(3), DELTA);
    }

    @Test
    public void factorialFalsePositive(){
        assertNotEquals("Finding factorial of a number for False Positive", 120, calculator.factorial(7), DELTA);
        assertNotEquals("Finding factorial of a number for False Positive", 2, calculator.factorial(3), DELTA);
    }

    @Test
    public void powerTruePositive(){
        assertEquals("Finding power for True Positive", 8, calculator.power(2, 3), DELTA);
        assertEquals("Finding power for True Positive", 216, calculator.power(6, 3), DELTA);
    }

    @Test
    public void powerFalsePositive(){
        assertNotEquals("Finding power for False Positive", 6, calculator.power(2, 2), DELTA);
        assertNotEquals("Finding power for False Positive", -7, calculator.power(2, 3), DELTA);
    }

    @Test
    public void logTruePositive(){
        assertEquals("Finding natural log for True Positive", 0, calculator.nlog(1), DELTA);
        assertEquals("Finding natural log for True Positive", 0, calculator.nlog(1), DELTA);
    }

    @Test
    public void logFalsePositive(){
        assertNotEquals("Finding natural log for False Positive", 6, calculator.nlog(2.4), DELTA);
        assertNotEquals("Finding natural log for False Positive", 8.9, calculator.nlog(2.1), DELTA);
    }

    @Test
    public void sqrootTruePositive(){
        assertEquals("Finding square root for True Positive", 4, calculator.sqroot(16), DELTA);
        assertEquals("Finding square root for True Positive", 0, calculator.sqroot(0), DELTA);
    }

    @Test
    public void sqrootFalsePositive(){
        assertNotEquals("Finding square root for False Positive", 9, calculator.sqroot(10), DELTA);
        assertNotEquals("Finding square root for False Positive", 1, calculator.sqroot(3), DELTA);

    }


}