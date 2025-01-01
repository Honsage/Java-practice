import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tester();
    }

    public static void Tester() {
        Stack<String> stack = new Stack<>();
        stack.push("first");
        stack.push("second");
        stack.push("last");
        System.out.println("The top of the stack is: '" + stack.top() + "'");
        System.out.println("The top of the stack is: '" + stack.pop() + "'. Let's delete it.");
        System.out.println("Sentence 'stack is empty' is " + stack.empty());
        System.out.println("Stack contains: " + stack);
    }

    public static void Test() {
        Scanner scan = new Scanner(System.in);
        MyStack<String> stack = new MyStack<>();
        System.out.println("Please, push five string elements to the stack:");
        for(int i = 0; i < 5; ++i) {
            stack.push(scan.nextLine());
        }
        System.out.println("Representation of data in the stack is: ");
        for(int i = 0; i < 5; ++i) {
            System.out.println(stack.pop());
        }
    }
}