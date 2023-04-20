import java.lang.reflect.Array;

public class Stack<T> {
    private T[] stack;
    public int top = 0;

    @SuppressWarnings({"unchecked"})
    public Stack(Class<T> classType, int size) {
        stack = (T[]) Array.newInstance(classType, size);
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(T data) throws Exception {
        if (top == stack.length) {
            throw new Exception("Error. Overflow detected.");
        }
        top++;
        stack[ top - 1] = data;
    }

    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Error. Underflow detected.");
        }
        top--;
        return stack[ top ];
    }

    public void showStack() {
        for (T item : stack) System.out.println(item);
    }

    public void peek() {
        System.out.println();
        System.out.println("Peeking at current top: " + stack[ top  - 1 ]);
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Stack<String> stringStack = new Stack<>(String.class, 4);
        stringStack.push("Apple");
        stringStack.push("Banana");
        stringStack.push("Carrot");
        stringStack.push("Durian");
        stringStack.showStack();
        stringStack.peek();
        stringStack.pop();
        stringStack.peek();
        stringStack.pop();
        stringStack.peek();

        System.out.println();

        Stack<Double> doubleStack = new Stack<>(Double.class, 4);
        doubleStack.push(3.14159);
        doubleStack.push(6.28319);
        doubleStack.push(2.71828);
        doubleStack.push(0.57721);
        doubleStack.showStack();
        doubleStack.peek();
        doubleStack.pop();
        doubleStack.peek();
        doubleStack.pop();
        doubleStack.peek();
    }
}
