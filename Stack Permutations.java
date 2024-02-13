import java.util.Scanner;
import java.util.Stack;
public class Stack_Permutations 
{
    static boolean check(int n, int ip[], int op[])
    {
        Stack<Integer> s = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            s.push(ip[i]);
            while (!s.isEmpty() && s.peek() == op[j]) {s.pop(); j++;}
        }
        return s.isEmpty();
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int n = sc.nextInt();
        int input[] = new int[n];
        int output[] = new int[n];
        for(int i = 0; i<n; i++) input[i] = sc.nextInt();
        for(int i = 0; i<n; i++) output[i] = sc.nextInt();
        System.out.println(check(n, input, output));
        sc.close();
    }
}
