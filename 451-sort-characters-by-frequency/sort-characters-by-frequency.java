class Solution {
     public static String frequencySort(String s) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        PriorityQueue<TopKFrequent<Character>> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder ans = new StringBuilder("");

        for(char i :s.toCharArray()){
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        }
        hashMap.forEach((character, integer) -> {
            maxheap.offer(new TopKFrequent<Character>(character,integer));
        });

        while (!maxheap.isEmpty()){
            TopKFrequent<Character> curr = maxheap.poll();
            for (int i = 0; i < curr.frequency; i++) {
                ans.append(curr.value);
            }

        }
        return ans.toString();

    }
    
    static class TopKFrequent<T> implements Comparable<TopKFrequent> {
        T value;
        int frequency;

        public TopKFrequent(T value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(TopKFrequent o) {
            return this.frequency - o.frequency;
        }
    }
}