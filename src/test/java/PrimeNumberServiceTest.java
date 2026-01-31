import org.example.prime_numbers.PrimeNumberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class PrimeNumberServiceTest {

    private PrimeNumberService primeNumberService;

    @BeforeEach
    public void setUp() {
        primeNumberService = new PrimeNumberService();
    }

    @Test
    public void findPrimesUpToTest() {
        int N = 31;
        Set<Integer> expected = Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);
        Set<Integer> actual = primeNumberService.findPrimesUpTo(N);
        Assertions.assertEquals(expected, actual);
    }

}
