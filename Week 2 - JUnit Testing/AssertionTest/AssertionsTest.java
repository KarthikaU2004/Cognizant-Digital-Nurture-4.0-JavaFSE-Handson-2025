import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAllAssertions() {
        assertEquals("Sum check failed", 10, 5 + 5);
        assertEquals("Even check failed", 6 % 2, 0);
        assertFalse("Negative check failed", false);
        assertNull("Null check failed", null);
    }
}
