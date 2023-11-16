class Solution {
    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<KClosest> minHeap = new PriorityQueue<>();
        int[][] ans = new int[k][2];

        for (int[] point : points) {
            int distance = 0;
            for (int i : point) {
                distance += i * i;
            }
            minHeap.offer(new KClosest(point, (distance)));
        }

        for (int i = 0; i < k; i++) {

            ans[i] = minHeap.poll().list;
        }

        return ans;

    }

    static class KClosest implements Comparable<KClosest> {
        int[] list;
        int distance;

        public KClosest(int[] list, int distance) {
            this.list = list;
            this.distance = distance;
        }

        @Override
        public int compareTo(KClosest o) {
            return this.distance - o.distance;
        }
    }
}