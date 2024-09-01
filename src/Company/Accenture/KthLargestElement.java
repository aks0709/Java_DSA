package Company.Accenture;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int arr[]={3,2,1,5,6,4};
        System.out.println(findKthLargest(arr,2));
        System.out.println(findKthSmallest(arr,2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(k);
        for(int num : nums){
            pq.add(num);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }
    public static int findKthSmallest(int[] nums, int k) {
        // Use a max-heap (PriorityQueue with reverse order) to store the k smallest elements
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> b - a);

        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();  // Remove the largest element in the heap to maintain k smallest elements
            }
        }

        // The root of the max-heap is the k-th smallest element
        return heap.peek();
    }

}
