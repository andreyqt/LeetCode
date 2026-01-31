import org.example.bitwise_parity.BitwiseOrParity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BitWiseOrParityTest {

    private BitwiseOrParity bitwiseOrParity;

    @BeforeEach
    public void init() {
        bitwiseOrParity = new BitwiseOrParity();
    }

    @Test
    public void isEvenTest() {
        int[] nums = new int[]{1,2,2,2,4};
        boolean expected = false;
        boolean actual = bitwiseOrParity.isEven(nums);
    }

}
