package Questions.LinkedList;

import java.util.LinkedList;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public void add(int data) {
        Node node = new Node(data);


    }
}

class Solution {
    public static void main(String[] args) {


        Node commonNode = new Node(6);

        Node headA = new Node(1);
        headA.next = new Node(2);
        headA.next.next = commonNode;

        Node headB = new Node(3);
        headB.next = commonNode;

        Node intersectionNode = intersectionOfTwo(headA, headB);

        if (intersectionNode != null) {
            System.out.println("Intersection node value: " + intersectionNode.data);
        } else {
            System.out.println("No intersection found.");
        }



    }

    public static Node mergeLL(Node l1, Node l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Node dumpy = new Node(0);
        Node current = dumpy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                current.next = l1;
                l1 = l1.next;

            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return dumpy.next;
    }

    public static Node reverseLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;


    }


    public static Node printLL(Node head) {
        Node temp = head;

        while (temp != null) {

            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.println("null");
        return temp;
    }

    public static void middleOfLL(Node head) {
        if (head == null) {
            System.out.println("NULl");
            return;
        }
        if (head.next == null) {
            System.out.println(head.data);
            return;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);

    }

    public static void printKthDistance(Node head, int k) {
        Node newHead = reverseLL(head);
        int count = 1;
        while (newHead != null) {
            if (k == count) {
                System.out.println(newHead.data);
            }
            newHead = newHead.next;
            count++;
        }
    }

    public static void printKthFromEnd(Node head, int k) {
        if (head == null || k <= 0) {
            System.out.println("Invalid input");
            return;
        }

        Node slow = head;
        Node fast = head;

        // Move the fast pointer k nodes ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                System.out.println("Invalid value of k");
                return;
            }
            fast = fast.next;
        }

        // Move both pointers until the fast pointer reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // At this point, the slow pointer is at the kth node from the end
        System.out.println("Kth node from the end: " + slow.data);
    }


    public static Node rotateByK(Node head,int k){
        if(head==null || k<=0) return null;
        Node tail =findTail(head);
        int size=sizeOfLL(head);
        tail.next= head;
        Node temp = head;
        int count=1;
        while (count!=size-k){
            temp= temp.next;
            count++;
        }
        head = temp;
        temp.next=null;
        return head;
    }

    public static Node rotateByKk(Node head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        int size = sizeOfLL(head);
        k = k % size;

        if (k == 0) {
            return head;
        }

        Node tail = findTail(head);
        Node temp = head;
        int count = 1;

        while (count != size - k) {
            temp = temp.next;
            count++;
        }

        Node newHead = temp.next;
        temp.next = null;
        tail.next = head;

        return newHead;
    }
    public static Node findTail(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        return current;
    }

    public static int sizeOfLL(Node head){

        Node temp = head;
        int count =0;
        while(temp!=null){
            temp = temp.next;
            count++;

        }
        return count;
    }

    public static Node intersectionOfTwo(Node h1, Node h2) {
        int h1_length = sizeOfLL(h1);
        int h2_length = sizeOfLL(h2);
        int diff = Math.abs(h1_length - h2_length);

        if (h1_length > h2_length) {
            for (int i = 0; i < diff; i++) {
                h1 = h1.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                h2 = h2.next;
            }
        }

        while (h1 != null && h2 != null) {
            if (h1 == h2) {
                return h1; // Found the intersection point.
            }
            h1 = h1.next;
            h2 = h2.next;
        }

        return null; // No intersection found.
    }

    public static boolean detectCycle(Node head) {
        if (head == null) {
            return false; // No cycle if the list is empty.
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Cycle detected.
            }
        }

        return false; // No cycle found.
    }

    public static int lengthOfCycleLL(Node head) {
        if (head == null) {
            return 0;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return calculateCycleLength(slow);
            }
        }

        return 0; // No cycle found.
    }

    private static int calculateCycleLength(Node meetingPoint) {
        int length = 1;
        Node current = meetingPoint.next;

        while (current != meetingPoint) {
            length++;
            current = current.next;
        }

        return length;
    }




}


