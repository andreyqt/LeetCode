import org.example.container.ContainerWithMostWater;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ContainerWithMostWaterTest {

    private ContainerWithMostWater container;

    @BeforeEach
    void setUp() {
        container = new ContainerWithMostWater();
    }

    @Test
    public void maxAreaTest() {
        int[] input = {1,8,6,2,5,4,8,3,7};
        int actual = container.maxArea(input);
        int expected = 49;
        assertEquals(expected, actual);
    }

}
