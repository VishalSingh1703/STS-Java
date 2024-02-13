import java.util.*;
class Node
{
    int data;
    Node next;
    Node (int val)
    {
        data = val;
        next = null;
    }
}

class Main
{
    static Node insertNode(Node head, int val)
    {
        Node newNode = new Node(val);
        if(head == null)
        {
            head = newNode;
            return head;
        }
        Node temp = head;
        while(temp.next!=null) temp = temp.next;
        temp.next = newNode;
        return head;
    }

    static void display(Node head)
    {
        Node temp = head;
        while(temp.next!=null)
        {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println(temp.data + "->NULL");
    }

    static void createCycle(Node head, int a, int b)
    {
        int cnta = 0, cntb = 0;
        Node p1 = head;
        Node p2 = head;
        while(cnta <= a || cntb <= b)
        {
            if(cnta <= a && p1.next!=null) p1 = p1.next; cnta++;
            if(cntb <= b && p2.next!=null) p2 = p2.next; cntb++;
        }
        if(cntb==b) p2.next = p1;
    }
    
    static boolean cycleDetect(Node head)
    {
        if(head == null || head.next == null) return false;
        Node slow = head, fast = head.next.next;
        while(fast != null && fast.next != null)
        {
            if(fast == slow) return true; 
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes you want: ");
        int n = sc.nextInt();
        Node head = null;
        System.out.println("Enter the nodes: ");
        for(int i = 0; i<n; i++)
        {
            int m = sc.nextInt();
            head = insertNode(head, m);
        }
        display(head);
        int a = sc.nextInt();
        createCycle(head, 1, a);
        if(cycleDetect(head) == true) System.out.println("Loop Detected");
        else System.out.println("No Loop Detected");
    }
}
