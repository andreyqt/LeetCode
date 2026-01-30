import org.example.median_of_two_sorted_arrays.MedianOfTwoSortedArrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MedianOfTwoSortedArraysTest {

    private MedianOfTwoSortedArrays medianOfTwoSortedArrays;

    @BeforeEach
    public void init() {
        medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
    }

    @Test
    public void findMedianSortedArraysTest() {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        double expected = 2.5;
        double actual = medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(expected, actual);
    }

}
