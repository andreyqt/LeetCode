import org.example.partition_labels.PartitionLabels;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PartitionLabelsTest {

    private PartitionLabels partitionLabels;

    @BeforeEach
    void setUp() {
        partitionLabels = new PartitionLabels();
    }

    @Test
    public void partitionLabelsTest() {
        String input = "ababcbacadefegdehijhklij";
        List<Integer> expected = List.of(9,7,8);
        List<Integer> actual = partitionLabels.partitionLabels(input);
        List<Integer> actual2 = partitionLabels.partitionLabels2(input);
        assertEquals(expected, actual);
        assertEquals(expected, actual2);
    }

}
