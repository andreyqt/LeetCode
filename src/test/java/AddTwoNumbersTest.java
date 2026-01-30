import org.example.add_two_numbers.AddTwoNumbers;
import org.example.add_two_numbers.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddTwoNumbersTest {

    private AddTwoNumbers addTwoNumbers;

    @BeforeEach
    public void Init() {
        addTwoNumbers = new AddTwoNumbers();
    }

    @Test
    public void addTwoNumbersTest() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode expected = new ListNode(7, new ListNode(0, new ListNode(8)));
        ListNode actual = addTwoNumbers.addTwoNumbers(l1, l2);
        Assertions.assertEquals(expected.val, actual.val);
        Assertions.assertEquals(expected.next.val, actual.next.val);
        Assertions.assertEquals(expected.next.next.val, actual.next.next.val);
    }

}
