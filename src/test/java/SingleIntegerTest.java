import org.example.single_number.SingleInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SingleIntegerTest {

    private SingleInteger singleInteger;

    @BeforeEach
    void setUp() {
        singleInteger = new SingleInteger();
    }

    @Test
    public void singleNumberTest() {
        int[] input = {2,2,1};
        int actual = singleInteger.singleNumber(input);
        int expected = 1;
        assertEquals(expected, actual);
    }

}
