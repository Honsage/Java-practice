import java.util.LinkedList;

public class Stack<E> {
    private final LinkedList<E> queue;

    public Stack() {
        this.queue = new LinkedList<>();
    }

    public void push(E x) {
        this.queue.add(x);
        for(int i = 0; i < queue.size()-1; ++i) {
            this.queue.add(this.queue.poll());
        }
    }

    public E top() {
        return this.queue.peek();
    }

    public E pop() {
        return this.queue.poll();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        int size = this.queue.size();
        for(int i = 0; i < size; ++i) {
            s.append("'").append(this.pop().toString()).append("'").append(" ");
        }
        return s.toString();
    }
}
