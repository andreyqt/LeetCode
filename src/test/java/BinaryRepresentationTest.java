import org.example.binary.BinaryRepresentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BinaryRepresentationTest {

    private BinaryRepresentation binaryRepresentation;

    @BeforeEach
    void setUp() {
        binaryRepresentation = new BinaryRepresentation();
    }

    @Test
    public void convertToDecimalTest() {
        String binary = "1101";
        int expected = 13;
        int actual = binaryRepresentation.convertToDecimal(binary);
        assertEquals(expected, actual);
    }

}
