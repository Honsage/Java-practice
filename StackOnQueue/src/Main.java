import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Test();
    }

    public static void Test() {
        Stack<String> stack = new Stack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        System.out.println("The top of the stack is: '" + stack.top() + "'");
        System.out.println("The top of the stack is: '" + stack.pop() + "'. Let's delete it.");
        System.out.println("Sentence 'stack is empty' is " + stack.empty());
        System.out.println("Stack contains: " + stack);
        System.out.println("The top of the stack is: '" + stack.pop() + "'. Let's delete it.");
        System.out.println("Stack contains: " + stack);
    }
}