class Pair {
    long first;     // distance
    int second;     // node

    public Pair(long first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new Pair(w, v));
            adj.get(v).add(new Pair(w, u));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.first, b.first)
        );

        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new Pair(0, 0));

        int mod = 1000000007;

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            long dis = curr.first;
            int node = curr.second;

            if (dis > dist[node]) continue;

            for (Pair it : adj.get(node)) {

                int adjNode = it.second;
                long edgeWt = it.first;

                if (dis + edgeWt < dist[adjNode]) {

                    dist[adjNode] = dis + edgeWt;
                    ways[adjNode] = ways[node];
                    pq.offer(new Pair(dist[adjNode], adjNode));

                } else if (dis + edgeWt == dist[adjNode]) {

                    ways[adjNode] =
                        (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}