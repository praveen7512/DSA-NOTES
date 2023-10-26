class Solution {
     public static int minStoneSum(int[] piles, int k) {
        //first step -> sabko heap mein daalo

        

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int sum=0;

        for (int pile : piles) {
            maxHeap.offer(pile);
        }

        // second step -> o to k loop chalo and kam karo

        for (int i = 0; i < k; i++) {
            int curr = maxHeap.poll();
            int element = (int) (curr - Math.floor(curr / 2));
            maxHeap.offer(element);
        }

        for (Integer integer : maxHeap) {
            sum = sum+integer;
        }
        // sum print karo
        return sum;
    }
}