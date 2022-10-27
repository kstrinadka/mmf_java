import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyOwnStackIntegerTest {

    @Test
    public void pushAndPopTest() {
        MyOwnStack<Integer> stack = new MyOwnStack<>();
        Integer[] arr = {1,2,3,4,5};

        for (int elem : arr) {
            stack.push(elem);
        }
        for (int i = stack.count() - 1; i > 0; i--) {
            assertEquals(stack.pop(), arr[i]);
        }
    }


    @Test
    public void pushStackTest() {
        MyOwnStack<Integer> stack1 = new MyOwnStack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        MyOwnStack<Integer> stack2 = new MyOwnStack<>();
        stack2.push(4);
        stack2.push(5);
        stack2.push(6);
        Integer[] arr = {1,2,3,4,5,6};

        MyOwnStack<Integer> stack = new MyOwnStack<>();
        stack.pushStack(stack1);
        stack.pushStack(stack2);

        for (int i = stack.count() - 1; i > 0; i--) {
            assertEquals(stack.pop(), arr[i]);
        }
    }

    @Test
    public void popStackTest() {
        MyOwnStack<Integer> stack = new MyOwnStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        MyOwnStack<Integer> stackExp = new MyOwnStack<>();
        stackExp.push(4);
        stackExp.push(5);
        stackExp.push(6);

        MyOwnStack<Integer> stackCur = stack.popStack(3);

        while (!stackCur.isEmpty()) {
            assertEquals(stackExp.pop(), stackCur.pop());
        }
    }


    @Test
    public void countTest() {
        MyOwnStack<Integer> stack = new MyOwnStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        assertEquals(stack.count(), 6);
    }
}
