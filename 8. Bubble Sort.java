import java.util.Scanner;
import java.util.Arrays;

class Bubble_Sort
{
    static void sort(int arr[], int n)
    {
        for(int i = 0; i<n; i++)
        {
            for(int j = i+1; j<n; j++)
            {
                if(arr[j] < arr[i])
                {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    static void printArray(int arr[])
    {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        sort(arr, n);
        printArray(arr);

        sc.close();
    }

}
