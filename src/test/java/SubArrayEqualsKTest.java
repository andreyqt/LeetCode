import org.example.subarray_equals_k.SubArrayEqualsK;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SubArrayEqualsKTest {

    private SubArrayEqualsK subArrayEqualsK;

    @BeforeEach
    void setUp() {
        subArrayEqualsK = new SubArrayEqualsK();
    }

    @Test
    public void subArrayEqualsKTest() {
        int[] input = {1,1,1};
        int target = 2;
        int expected = 2;
        int actual = subArrayEqualsK.subArrayEquals(input, target);
        assertEquals(expected, actual);
    }

}
