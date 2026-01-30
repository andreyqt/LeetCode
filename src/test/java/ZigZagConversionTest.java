import org.example.zigzag_conversion.ZigzagConversion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ZigZagConversionTest {

    private ZigzagConversion zigzagConversion;

    @BeforeEach
    public void setUp() {
        zigzagConversion = new ZigzagConversion();
    }

    @Test
    public void convertTest() {
        int numRows = 3;
        String expected = "PAHNAPLSIIGYIR";
        String input = "PAYPALISHIRING";
        String actual = zigzagConversion.convert(input, numRows);
        Assertions.assertEquals(expected, actual);
    }

}
