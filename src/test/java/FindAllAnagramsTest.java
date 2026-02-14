import org.example.string_tasks.FindAllAnagrams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FindAllAnagramsTest {

    private FindAllAnagrams findAllAnagrams;

    @BeforeEach
    void setUp() {
        findAllAnagrams = new FindAllAnagrams();
    }

    @Test
    void findAllAnagramsTest() {
        String p = "ab";
        String s = "abab";
        List<Integer> actual = findAllAnagrams.findAllAnagrams(s, p);
        List<Integer> expected = List.of(0,1,2);
        assertEquals(expected, actual);
    }

}
