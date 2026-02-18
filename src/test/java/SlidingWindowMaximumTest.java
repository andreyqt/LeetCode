import org.example.sliding_window.SlidingWindowMaximum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class SlidingWindowMaximumTest {

    private SlidingWindowMaximum slidingWindowMaximum;

    @BeforeEach
    void setUp() {
        slidingWindowMaximum = new SlidingWindowMaximum();
    }

    @Test
    public void maxSlidingWindowTest() {
        int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] actual = slidingWindowMaximum.maxSlidingWindow(input, k);
        int[] expected = {3, 3, 5, 5, 6, 7};
        assertArrayEquals(expected, actual);
    }

}
