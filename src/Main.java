import java.util.Arrays;
import java.util.Stack;

// idea is to push all items onto one stack, then pop them off and push them onto a second stack so that the
// first item into the first stack becomes the first item out of the sceond stack. The probleem is if i want
// to pop a couple items off the second stack then push some more on, since this is FIFO, the item needs to
// go on the bottom of the second stack. so i would need to pop/push all items onto first stack, push the new
// item and then pop and push them all back to the second stack. horribly inefficient. if you have a stack
// of 1,000 items, you would need to move all items twice just to add the new item

public class Main {
    public static void main(String[] args) {

    }
}

// MY SOLUTION. FINALLY CORRECT WITH GOOD EFFICIENCY
class MyQueue {
//    Stack<Integer> stackOne = new Stack<>();
//    Stack<Integer> stackTwo = new Stack<>();
    private Stack<Integer> stackOne;
    private Stack<Integer> stackTwo;

    public MyQueue() {
 //       System.out.println(Arrays.toString(stackTwo.toArray())); this was supposed to be constructor. my solution still great though
        stackOne = new Stack<>();
        stackTwo = new Stack<>();
    }

    public void push(int x) {
        while(!stackTwo.isEmpty()){
            stackOne.push(stackTwo.pop());
        }
        stackOne.push(x);
        while (!stackOne.isEmpty()){
            stackTwo.push(stackOne.pop());
        }
    }

    public int pop() {
        return stackTwo.pop();
    }

    public int peek() {
        return stackTwo.peek();
    }

    public boolean empty() {
        return(stackTwo.empty());
    }
}
