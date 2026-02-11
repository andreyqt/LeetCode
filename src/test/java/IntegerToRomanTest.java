import org.example.integer_to_roman.IntegerToRoman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class IntegerToRomanTest {

    private IntegerToRoman integerToRoman;

    @BeforeEach
    void setUp() {
        integerToRoman = new IntegerToRoman();
    }

    @Test
    public void intToRomanTest() {
        int input = 3749;
        String actual = integerToRoman.intToRoman(input);
        String expected = "MMMDCCXLIX";
        assertEquals(expected, actual);
    }

}
