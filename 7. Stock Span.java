import java.util.Stack;
import java.util.Arrays;
import java.util.Scanner;

public class Stock_Span 
{
    static void calc(int arr[], int n, int ans[])
    {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        ans[0] = 1;
        for(int i = 1; i<n; i++)
        {
            while(!st.empty() && arr[st.peek()] <= arr[i]) st.pop();
            ans[i] = st.empty() ? i + i :  i - st.peek();
            st.push(i);
        }
    }

    static void printArray(int arr[])
    {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of days you want to store: ");
        int n = sc.nextInt();

        System.out.println("Enter the price of the stocks: ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++) arr[i] = sc.nextInt();

        int ans[] = new int[n];
        calc(arr, n, ans);
        
        printArray(ans);
        sc.close();
    }
}
