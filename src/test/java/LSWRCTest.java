import org.example.LSWRC.LSWRC;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LSWRCTest {

    private LSWRC lswrc;

    @BeforeEach
    public void init() {
        lswrc = new LSWRC();
    }

    @Test
    public void lengthOfLongestSubstringTest() {
        String input = "abcabcbb";
        int expected = 3;
        int actual = lswrc.lengthOfLongestSubstring(input);
        Assertions.assertEquals(expected, actual);
    }

}
