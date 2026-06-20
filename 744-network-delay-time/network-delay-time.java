import java.util.*;

class tuple {
    int dis;
    int node;
    int weight;

    public tuple(int dis, int node, int weight) {
        this.dis = dis;
        this.node = node;
        this.weight = weight;
    }
}

class pair {
    int node;
    int weight;

    public pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        int rows = times.length;

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        ArrayList<ArrayList<pair>> adjLS = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjLS.add(new ArrayList<>());
        }

        for (int i = 0; i < rows; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int wei = times[i][2];

            adjLS.get(u).add(new pair(v, wei));
        }

        PriorityQueue<tuple> pq = new PriorityQueue<>(
            (a, b) -> a.dis - b.dis
        );

        dist[k] = 0;
        pq.offer(new tuple(0, k, 0));

        while (!pq.isEmpty()) {

            tuple curr = pq.poll();

            int dis = curr.dis;
            int node = curr.node;

            if (dis > dist[node]) {
                continue;
            }

            for (pair adj : adjLS.get(node)) {

                int no = adj.node;
                int edgeweight = adj.weight;

                if (dis + edgeweight < dist[no]) {

                    dist[no] = dis + edgeweight;

                    pq.offer(
                        new tuple(dist[no], no, edgeweight)
                    );
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}