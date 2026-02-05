import org.example.atoi.Atoi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AtoiTest {

    Atoi atoi;

    @BeforeEach
    void setUp() {
        atoi = new Atoi();
    }

    @Test
    public void myAtoiTest() {
        String input = " -042";
        int expected = -42;
        int actual = atoi.myAtoi(input);
        assertEquals(expected, actual);
    }

}
