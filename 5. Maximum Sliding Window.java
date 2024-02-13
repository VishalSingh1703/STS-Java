import java.util.Deque;
import java.util.LinkedList;
public class Max_Sliding_Window 
{
    static void printMax(int arr[], int N, int k)
    {
        Deque<Integer> D = new LinkedList<Integer>();
        int i = 0;
        
        for(; i<k; i++)
        {
            while(!D.isEmpty() && arr[i] >= arr[D.peekLast()]) D.removeLast();
            D.addLast(i);
        }

        for(; i<N; i++)
        {
            System.out.print(arr[D.peek()] + " ");
            while((!D.isEmpty()) && D.peek() <= i - k) D.removeFirst();
            while(!D.isEmpty() && arr[i] >= arr[D.peekLast()]) D.removeLast();
            D.addLast(i);
        }
        System.out.println(arr[D.peek()]);
    }

    public static void main(String args[])
    {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        printMax(arr, arr.length, 3);
    }
}
