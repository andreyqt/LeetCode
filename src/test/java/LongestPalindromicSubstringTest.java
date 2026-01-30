import org.example.longest_palindromic_substring.LongestPalindromicSubstring;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LongestPalindromicSubstringTest {

    private LongestPalindromicSubstring longestPalindromicSubstring;

    @BeforeEach
    public void init() {
        longestPalindromicSubstring = new LongestPalindromicSubstring();
    }

    @Test
    public void longestPalindromeTest() {
        String input = "cbbd";
        String expected = "bb";
        String actual = longestPalindromicSubstring.longestPalindrome(input);
        Assertions.assertEquals(expected, actual);
    }

}
