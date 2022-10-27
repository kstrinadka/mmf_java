import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {




        MyOwnStack<Integer> stack2 = new MyOwnStack();
        stack2.push(5);
        stack2.push(5);
        stack2.push(5);
        //stack2.push("sdfgsdf");


        MyOwnStack<Integer> stack1 = new MyOwnStack();
        stack1.push(1);
        stack1.push(2);
        stack1.push(1);
        stack1.push(2);
        stack1.push(1);
        stack1.push(2);


        stack1.pushStack(stack2);

        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop());
        }



    }


}
