import java.lang.reflect.Array;

/*
Note: A Queue can only store (Queue.length - 1) elements.
Allowing the queue to actually fill results in weird behavior.
i.e. Say queue has 3 of 4 slots filled. If you filled the 4th slot before
dequeuing something, then tail would be equal to head and thus dequeue() would fail
even though the queue is full.
 */

public class Queue<T> {
    private final T[] queue;
    public int head = 0;
    public int tail = 0;

    @SuppressWarnings({"unchecked"})
    public Queue(Class<T> classType, int size) {
        queue = (T[]) Array.newInstance(classType, size);
    }

    public void enqueue(T data) throws Exception {

        if ( (head - 1 == tail) || ( (head == 0) && (tail == queue.length - 1) ) ) {
            throw new Exception("Error. Overflow detected.");
        }

        queue[ tail ] = data;
        if (tail == queue.length - 1) {
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
        if (queue.length == 0) {
            throw new Exception("Error. Cannot call peek on empty list.");
        }
        System.out.println();
        System.out.println("Peeking at current head: " + queue[ head ]);
        System.out.println("Peeking at current tail: " + queue[ tail ]);
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Queue<String> stringQueue = new Queue<>(String.class, 4);
        stringQueue.enqueue("Apple");
        stringQueue.enqueue("Banana");
        stringQueue.enqueue("Carrot");
        //stringQueue.enqueue("Durian");
        stringQueue.showQueue();
        stringQueue.peek();
        stringQueue.dequeue();
        stringQueue.peek();


        Queue<Double> doubleQueue = new Queue<>(Double.class, 4);
        doubleQueue.enqueue(3.14159);
        doubleQueue.enqueue(6.28319);
        doubleQueue.enqueue(2.71828);
        //doubleQueue.enqueue(0.57721);
        doubleQueue.showQueue();
        doubleQueue.peek();
        doubleQueue.dequeue(); // 1
        doubleQueue.peek();
        doubleQueue.dequeue(); // 2
        doubleQueue.peek();
        doubleQueue.dequeue(); // 3
        doubleQueue.peek();
        doubleQueue.dequeue(); // 4 Note: Should fail here
        doubleQueue.peek();

    }
}
