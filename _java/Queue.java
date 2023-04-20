import java.lang.reflect.Array;

public class Queue<T> {
    private T[] queue;
    public int head = 0;
    public int tail = 0;

    @SuppressWarnings({"unchecked"})
    public Queue(Class<T> classType, int size) {
        queue = (T[]) Array.newInstance(classType, size);
    }

    public void enqueue(T data) throws Exception {

        if ( (head - 1 == tail) || ( (head == 0) && (tail == queue.length) ) ) {
            throw new Exception("Error. Overflow detected.");
        }

        queue[ tail ] = data;
        if (tail == queue.length) {
            tail = 0;
        } else {
            tail++;
        }
    }

    public T dequeue() throws Exception {

        if (head == tail) throw new Exception("Error. Underflow detected.");

        T tmp = queue[ head ];
        if (head == queue.length - 1) {
            head = 0;
        } else {
            head++;
        }
        return tmp;
    }

    public void showQueue() {
        for (T item : queue) System.out.println(item);
    }

    public void peek() throws Exception {
        if (head == tail) {
            throw new Exception("Error. Cannot call peek on empty list.");
        }
        System.out.println();
        System.out.println("Peeking at current top: " + queue[ head ]);
        System.out.println("Peeking at current tail: " + queue[ tail  - 1]);
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Queue<String> stringQueue = new Queue<>(String.class, 4);
        stringQueue.enqueue("Apple");
        stringQueue.enqueue("Banana");
        stringQueue.enqueue("Carrot");
        stringQueue.enqueue("Durian");
        stringQueue.showQueue();
        stringQueue.peek();
        stringQueue.dequeue();
        stringQueue.peek();


        Queue<Double> doubleQueue = new Queue<>(Double.class, 4);
        doubleQueue.enqueue(3.14159);
        doubleQueue.enqueue(6.28319);
        doubleQueue.enqueue(2.71828);
        doubleQueue.enqueue(0.57721);
        doubleQueue.showQueue();
        doubleQueue.peek();
        doubleQueue.dequeue();
        doubleQueue.peek();
        doubleQueue.dequeue();
        doubleQueue.peek();
        doubleQueue.dequeue();
        doubleQueue.peek();
        doubleQueue.dequeue();
    }

}
