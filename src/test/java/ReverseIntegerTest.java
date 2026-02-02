import org.example.reverse_integer.ReverseInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ReverseIntegerTest {

    private ReverseInteger reverseInteger;

    @BeforeEach
    void setUp() {
        reverseInteger = new ReverseInteger();
    }

    @Test
    public void reverse1Test() {
        int input = 12345;
        int expected = 54321;
        int actual = reverseInteger.reverse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void reverse2Test() {
        int input = 12345;
        int expected = 54321;
        int actual = reverseInteger.reverse2(input);
        assertEquals(expected, actual);
    }

    @Test
    public void reverse1NegativeTest() {
        int input = -12345;
        int expected = -54321;
        int actual = reverseInteger.reverse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void reverse2NegativeTest() {
        int input = -12345;
        int expected = -54321;
        int actual = reverseInteger.reverse2(input);
        assertEquals(expected, actual);
    }

    @Test
    public void reverse1GivenOverflow() {
        int input = Integer.MAX_VALUE + 1;
        int expected = 0;
        int actual = reverseInteger.reverse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void reverse2GivenOverflow() {
        int input = Integer.MAX_VALUE + 1;
        int expected = 0;
        int actual = reverseInteger.reverse2(input);
        assertEquals(expected, actual);
    }

}
