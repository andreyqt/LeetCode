import org.example.integer_to_roman.RomanToInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RomanToIntegerTest {

    private RomanToInteger romanToInteger;

    @BeforeEach
    void setUp() {
        romanToInteger = new RomanToInteger();
    }

    @Test
    public void intToRomanTest() {
        String input = "III";
        int expected = 3;
        int actual = romanToInteger.romanToInt(input);
        assertEquals(expected, actual);
    }

}
