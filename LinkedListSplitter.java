package linkedList;

class nodesLinked {
    int val;
    nodesLinked next;

    nodesLinked(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListSplitter {
    public static nodesLinked[] splitAlternate(nodesLinked head) {
        if (head == null || head.next == null) {
            return new nodesLinked[]{head, null};
        }

        nodesLinked list1 = new nodesLinked(-1); // Dummy node for first list
        nodesLinked list2 = new nodesLinked(-1); // Dummy node for second list

        nodesLinked current = head;
        nodesLinked currentList1 = list1;
        nodesLinked currentList2 = list2;
        int count = 1;

        while (current != null) {
            if (count % 2 != 0) {
                currentList1.next = current;
                currentList1 = currentList1.next;
            } else {
                currentList2.next = current;
                currentList2 = currentList2.next;
            }

            current = current.next;
            count++;
        }

        // Terminate the two new lists
        currentList1.next = null;
        currentList2.next = null;

        // Remove the dummy nodes from the two new lists
        nodesLinked[] result = new nodesLinked[]{list1.next, list2.next};
        return result;
    }

    public static void main(String[] args) {
        // Test case: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        nodesLinked head = new nodesLinked(1);
        head.next = new nodesLinked(2);
        head.next.next = new nodesLinked(3);
        head.next.next.next = new nodesLinked(4);
        head.next.next.next.next = new nodesLinked(5);
        head.next.next.next.next.next = new nodesLinked(6);

        nodesLinked[] result = splitAlternate(head);

        System.out.println("List 1:");
        printLinkedList(result[0]);

        System.out.println("\nList 2:");
        printLinkedList(result[1]);
    }

    public static void printLinkedList(nodesLinked head) {
        nodesLinked current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
