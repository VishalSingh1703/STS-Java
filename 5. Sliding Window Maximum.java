class Solution {
    public int[] maxSlidingWindow(int[] a, int k) 
    {
        int n = a.length;
        int[] result = new int[n-k+1];
        int resultIndex = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++)
        {
            while(!deque.isEmpty() && deque.peek() < i-k+1) deque.poll();
            while(!deque.isEmpty() && a[deque.peekLast()] < a[i]) deque.pollLast();
            deque.offer(i);
            if(i >= k-1) result[resultIndex++] = a[deque.peek()];
        }
        return result;
    }
}
