import org.example.sort.SquaresOfSortedArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SquaresOfSortedArrayTest {

    private SquaresOfSortedArray squaresOfSortedArray;

    @BeforeEach
    void setUp() {
        squaresOfSortedArray = new SquaresOfSortedArray();
    }

    @Test
    public void squaresOfSortedArray2Test() {
        int[] input = new int[]{-5, -4, -3, -2, 0, 1, 2, 3};
        int[] expected = new int[]{0,1,4,4,9,9,16,25};
        int[] actual = squaresOfSortedArray.squaresOfSortedArray2(input);
        for (int j = 0; j < actual.length; j++) {
            assertEquals(expected[j], actual[j]);
        }
    }

}
