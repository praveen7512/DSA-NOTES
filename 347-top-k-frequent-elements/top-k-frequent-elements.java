class Solution {
     public static int[] topKFrequent(int[] nums, int k) {

        int[] ans = new int[k];
        PriorityQueue<TopKFrequent> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        hashMap.forEach((integer, integer2) -> maxheap.offer(new TopKFrequent(integer, integer2)));

        for (int i = 0; i < k; i++) {
            TopKFrequent curr = maxheap.poll();
            ans[i] = curr.value;
        }
        return ans;


    }

    static class TopKFrequent implements Comparable<TopKFrequent> {
        int value;
        int frequency;

        public TopKFrequent(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(TopKFrequent o) {
            return this.frequency - o.frequency;
        }
    }
}