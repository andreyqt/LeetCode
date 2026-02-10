import org.example.palindrome_number.PalindromeNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class PalindromeNumberTest {

    private PalindromeNumber palindromeNumber;

    @BeforeEach
    void setUp() {
        palindromeNumber = new PalindromeNumber();
    }

    @Test
    public void isPalindromeTest() {
        int input = -121;
        int inputTwo = 12321;
        boolean result = palindromeNumber.isPalindrome(input);
        boolean resultTwo = palindromeNumber.isPalindrome(inputTwo);
        assertFalse(result);
        assertTrue(resultTwo);
    }

}
