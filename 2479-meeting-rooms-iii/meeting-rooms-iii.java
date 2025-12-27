class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        long[] count = new long[n];
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return Long.compare(a[0], b[0]);
                return Long.compare(a[1], b[1]);
            }
        );
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for(int i = 0; i < n; i++) free.add(i);

        for (int[] meet : meetings) {
            long start = meet[0];
            long end = meet[1];
            long duration = end - start;
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                free.add((int) busy.poll()[1]);
            }

            int room;
            long finishTime;

            if (!free.isEmpty()) {
                room = free.poll();
                finishTime = end;
            } else {
                long[] cur = busy.poll();
                room = (int) cur[1];
                finishTime = cur[0] + duration;
            }

            count[room]++;
            busy.add(new long[]{finishTime, room});
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) ans = i;
        }
        return ans;
    }
}
