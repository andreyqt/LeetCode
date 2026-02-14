import org.example.string_tasks.Permutation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PermutationTest {

    private Permutation permutation;

    @BeforeEach
    void setUp() {
        permutation = new Permutation();
    }

    @Test
    void checkInclusionTest() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        boolean actual = permutation.checkInclusion(s1, s2);
        System.out.println(actual);
    }

}
