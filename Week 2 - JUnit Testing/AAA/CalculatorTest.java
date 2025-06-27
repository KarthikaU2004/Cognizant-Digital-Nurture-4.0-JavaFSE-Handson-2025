import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("🔧 Setup before test");
        calculator = new Calculator(); // Arrange
    }

    @After
    public void tearDown() {
        System.out.println("🧹 Teardown after test");
        calculator = null;
    }

    @Test
    public void testAdd() {
        // Act
        int result = calculator.add(10, 5);

        // Assert
        assertEquals("Addition failed", 15, result);
    }

    @Test
    public void testSubtract() {
        // Act
        int result = calculator.subtract(9, 4);

        // Assert
        assertEquals("Subtraction failed", 5, result);
    }
}
