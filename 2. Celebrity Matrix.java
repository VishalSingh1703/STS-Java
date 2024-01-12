https://www.geeksforgeeks.org/problems/the-celebrity-problem/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article


//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++) st.push(i);
        
        while(st.size()>=2)
        {
            int a = st.pop();
            int b = st.pop();
            if(M[a][b] == 1) st.push(b);
            else st.push(a);
        }
        int pc = st.pop();
        boolean temp = true;
        for(int i = 0; i<n; i++)
        {
            if(i!=pc)
            {
                if(M[pc][i] == 1 || M[i][pc] == 0)
                {
                    temp = false;
                    break;
                }
            }
        }
        if(temp) return pc;
        else return -1;
    }
}
