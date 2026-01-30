import org.example.two_sum.TwoSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class TwoSumTest {

    private TwoSum twoSum;

    @BeforeEach
    public void setUp() {
        twoSum = new TwoSum();
    }

    @Test
    public void twoSumTest() {
        int target = 9;
        int[] input = new int[]{2, 7, 11, 15};
        int[] expected = new int[]{0, 1};
        int[] actual = twoSum.twoSum(input, target);
        Assertions.assertTrue(
                (actual[0] == 0 && actual[1] == 1) || (actual[0] == 1 && actual[1] == 0)
        );
        Assertions.assertEquals(expected.length, actual.length);
    }

}
