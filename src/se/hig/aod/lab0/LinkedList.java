package se.hig.aod.lab0;

/**
 * Linked list implementation of the {@link PrintableList} interface.
 *
 * @param <T> The data type that is to be stored in the list.
 */
public class LinkedList<T> implements PrintableList<T> {

    /**
     * Internal node class representing a single element in the list.
     */
    private class ListNode {
        T data;
        ListNode next;

        ListNode(T data) {
            this.data = data;
        }

        /**
         * Recursively builds a forward string representation:
         * "e1, e2, e3"
         */
        String toStringForwardRecursive() {
            if (next == null) {
                return String.valueOf(data);
            } else {
                return String.valueOf(data) + ", " + next.toStringForwardRecursive();
            }
        }

        /**
         * Recursively builds a reverse string representation:
         * "en, ..., e2, e1"
         */
        String toStringReverseRecursive() {
            if (next == null) {
                return String.valueOf(data);
            } else {
                String tailString = next.toStringReverseRecursive();
                return tailString + ", " + String.valueOf(data);
            }
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int numberOfElements() {
        return size;
    }

    @Override
    public void insertFirst(T t) {
        ListNode newNode = new ListNode(t);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            // List was empty before
            tail = newNode;
        }
        size++;
    }

    @Override
    public void insertLast(T t) {
        ListNode newNode = new ListNode(t);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new ListEmptyException(
                "Unable to remove first element, list is empty."
            );
        }
        T value = head.data;
        head = head.next;
        if (head == null) {
            // List became empty
            tail = null;
        }
        size--;
        return value;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new ListEmptyException(
                "Unable to remove last element, list is empty."
            );
        }

        if (head == tail) {
            // Only one element
            T value = head.data;
            head = null;
            tail = null;
            size = 0;
            return value;
        }

        // Find node before tail
        ListNode current = head;
        while (current.next != tail) {
            current = current.next;
        }

        T value = tail.data;
        tail = current;
        tail.next = null;
        size--;
        return value;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new ListEmptyException(
                "List is empty."
            );
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new ListEmptyException(
                "List is empty."
            );
        }
        return tail.data;
    }

    @Override
    public String toStringRecursive() {
        if (isEmpty()) {
            return "[]";
        }
        return "[" + head.toStringForwardRecursive() + "]";
    }

    @Override
    public String toStringReverseRecursive() {
        if (isEmpty()) {
            return "[]";
        }
        return "[" + head.toStringReverseRecursive() + "]";
    }
}